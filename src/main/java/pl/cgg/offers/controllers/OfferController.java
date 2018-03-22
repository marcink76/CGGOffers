package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pl.cgg.offers.models.*;
import pl.cgg.offers.service.*;
import pl.cgg.offers.utility.Utils;
import pl.cgg.offers.wrappers.ComponentPriceWrapper;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/offers")
@SessionAttributes({"offer"})
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private InvestorService investorService;

    @Autowired
    private ComponentService componentService;

    @Autowired
    private ComponentPriceService componentPriceService;

    @Autowired
    private TemplateService templateService;

    @Autowired
    private Utils utils;

    @Autowired
    private UserService userService;

    @Autowired
    private StageService stageService;

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("offersList", offerService.getAll());
        return "showAllOffers";
    }

    @GetMapping("/edit/{id}")
    public String editOffer(@PathVariable("id") Long id,
                            boolean edit,
                            Model model){

        Offer offer = offerService.getOneOffer(id);
        List<Stage> stages = stageService.getByOffer(offer);

        model.addAttribute("stages", stages);
        model.addAttribute("offer", offer);
        model.addAttribute("stage", new Stage());
        return "editOfferForm";
    }

    @PostMapping("/edit/save")
    public String saveEditedOfferToBase(@Valid @ModelAttribute("offer") Offer offer,
                                        @Valid @ModelAttribute("stage") Stage stage,
                                        BindingResult result,
                                        Model model){
        if (result.hasErrors()){
            return "";
        }
        stageService.saveStage(stage);
        //TODO dokończyć
        //offer.setStages(stages);
        offerService.saveToBase(offer);
        stageService.setStageList(null);
        return "redirect:/offers/showOneOffer/" + offer.getId();
    }

    @GetMapping("/showOneOffer/{id}")
    public String showOne(@PathVariable("id") Long id,
                          Model model) {
        Offer offer = offerService.getOneOffer(id);
        List<ComponentPrice> componentPrices = componentPriceService.getComponentPriceByOffer(offer);
        model.addAttribute("offer", offer);
        model.addAttribute("prices", componentPrices);
        return "offerForm";
    }

    @GetMapping("/addOffer")
    public String addOffer(@RequestParam(required = false) String nameFirstLetter,
                           @RequestParam(required = false) String investorLastNameFirstLetters,
                           @RequestParam(required = false) String investorCityFirstLetters,
                           Model model) {
        List<Investor> investorList;
        if (nameFirstLetter == null && investorLastNameFirstLetters == null && investorCityFirstLetters == null) {
            investorList = investorService.getAllInvestors();
        } else {
            investorList = investorService.getOffersByFirstLetters(
                    nameFirstLetter,
                    investorLastNameFirstLetters,
                    investorCityFirstLetters);
        }
        model.addAttribute("nameFirstLetter", nameFirstLetter);
        model.addAttribute("investorLastNameFirstLetters", investorLastNameFirstLetters);
        model.addAttribute("investorCityFirstLetters", investorCityFirstLetters);
        model.addAttribute("method", "get");
        model.addAttribute("chars", utils.alphabet());
        model.addAttribute("offer", new Offer());
        model.addAttribute("investorsList", investorList);
        return "setInvestorToOfferForm";
    }

    @PostMapping("/setInvestorToOffer")
    public String addOfferToBase(Offer offer,
                                 Model model,
                                 @RequestParam(required = false) Long investorId,
                                 @RequestParam(required = false) Long componentId,
                                 @RequestParam(required = false) Long componentIdDel) {
        if (investorId != null) {
            offerService.setInvestorToOffer(offer, investorId);
        }
        offer.setUser(userService.getOneUser(1L));
        componentService.addToTempComponentList(componentId, componentIdDel);
        model.addAttribute("componentList", componentService.getComponentOfferList());
        if (componentService.getTempComponentOfferList() != null) {
            model.addAttribute("tempComponentList", componentService.getTempComponentOfferList());
        }
        model.addAttribute("investor", investorService.getInvestorById(investorId));
        return "addComponentToOfferForm";
    }

    @PostMapping("/addComponentToOffer")
    public String setComponentsToOffer(Offer offer, Model model) {

        ComponentPriceWrapper wrapper = new ComponentPriceWrapper();
        List<ComponentOffer> tempComponentOfferList = componentService.getTempComponentOfferList();

        List<ComponentPrice> emptyList = componentPriceService.getComponentPrice();
        wrapper.setComponentPrices(emptyList);
        model.addAttribute(offer);//to dodałem
        model.addAttribute("wrapper", wrapper);
        model.addAttribute("componentList", tempComponentOfferList);

        for (int i = 0; i < wrapper.getComponentPrices().size(); i++) {
            wrapper.getComponentPrices().get(i).setOffer(offer);
            wrapper.getComponentPrices().get(i).setComponentOffer(tempComponentOfferList.get(i));
            componentPriceService.saveComponentPrice(wrapper.getComponentPrices().get(i));
        }
        componentPriceService.setComponentPriceList(wrapper.getComponentPrices());
        offer.setComponentOfferList(tempComponentOfferList);
        return "showCompleteOfferForm";
    }

    @PostMapping("/completeOffer")
    public String saveOfferToBase(@ModelAttribute("wrapper") ComponentPriceWrapper wrapper,
                                  @RequestParam("offerDesc") String offerDesc,
                                  Offer offer,
                                  Model model) {
        double totalPrice = 0;
        double optionalPrice = 0;
        List<ComponentPrice> componentPrices = componentPriceService.getComponentPriceList();
        for (int i = 0; i < componentPrices.size(); i++) {
            double componentPrice = wrapper.getComponentPrices().get(i).getComponentPrice();
            double componentQuantity = wrapper.getComponentPrices().get(i).getQuantity();
            boolean componentOptional = wrapper.getComponentPrices().get(i).isOptional();
            boolean componentLumpSum = wrapper.getComponentPrices().get(i).isaLumpSum();
            componentPrices.get(i).setComponentPrice(componentPrice);
            componentPrices.get(i).setQuantity(componentQuantity);
            componentPrices.get(i).setaLumpSum(componentLumpSum);
            componentPrices.get(i).setOptional(componentOptional);
            componentPriceService.saveComponentPrice(componentPrices.get(i));
            if (componentOptional) {
                optionalPrice += componentPrice * componentQuantity;
            }
            totalPrice += componentPrice * componentQuantity;
        }
        offer.setOptionalComponentPrice(optionalPrice);
        offer.setDescription(offerDesc);
        offer.setTotalPrice(totalPrice);
        model.addAttribute("componentPricesList", componentPrices);
        model.addAttribute(offer);
        offerService.saveToBase(offer);
        return "finalOfferForm";
    }

    @PostMapping("/getOfferByFilter")
    public String getOfferByFilter(@RequestParam("filterString") String filterString,
                                   Model model,
                                   SessionStatus sessionStatus) {

        model.addAttribute("offersList", offerService.getOffersByString(filterString));
        sessionStatus.setComplete();
        return "showAllOffers";
    }

    @GetMapping("/ajaxtest")
    public String ajaxTest() {

        return "ajax";
    }
}