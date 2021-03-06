package pl.cgg.offers.controllers;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pl.cgg.offers.models.*;
import pl.cgg.offers.service.*;
import pl.cgg.offers.utility.PdfGenerator;
import pl.cgg.offers.utility.Utils;
import pl.cgg.offers.wrappers.ComponentPriceWrapper;
import sun.net.www.content.text.plain;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
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

    @Autowired
    private PdfGenerator pdfGenerator;

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("offersList", offerService.getAll());
        return "showAllOffers";
    }

    @GetMapping("/edit/{id}")
    public String editOffer(@PathVariable("id") Long id,
                            Model model) {
        Offer offer = offerService.getOneOffer(id);
        ComponentPriceWrapper wrapper = new ComponentPriceWrapper();

        List<Stage> stages = stageService.getByOffer(offer);
        List<ComponentPrice> prices = componentPriceService.getComponentPriceByOffer(offer);
        wrapper.setComponentPrices(prices);
        model.addAttribute("stages", stages);
        model.addAttribute("offer", offer);
        model.addAttribute("components", offer.getComponentOfferList());
        model.addAttribute("wrapper", wrapper);
        model.addAttribute("investors", investorService.getAllInvestors());
        model.addAttribute("stage", new Stage());

        return "editOfferForm";
    }

    @PostMapping("/edit/addStage")
    public String addStageToOffer(@Valid @ModelAttribute("offer") Offer offer,
                                  @Valid @ModelAttribute("stage") Stage stage,
                                  @RequestParam(required = false) Long stageId,
                                  Model model,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "";
        }
        if (stageId != null) {
            stageService.removeStage(stageId);
        }
        List<Stage> stages = stageService.getByOffer(offer);
        if (stageId == null) {
            stages.add(stage);
            stage.setOffer(offer);
            stageService.saveStage(stages);
        }
        model.addAttribute("stages", stages);
        return "editOfferForm";
    }

    @PostMapping("/edit/save")
    public String saveEditedOfferToBase(@Valid @ModelAttribute("offer") Offer offer,
                                        @ModelAttribute("investor") Investor investor,
                                        BindingResult result) {
        System.out.println(investor.getId());
        if (result.hasErrors()) {
            return "";
        }
        offerService.saveToBase(offer);
        return "redirect:/offers/showOneOffer/" + offer.getId();
    }

    @GetMapping("/showOneOffer/{id}")
    public String showOne(@PathVariable("id") Long id,
                          Model model) {
        Offer offer = offerService.getOneOffer(id);
        List<ComponentPrice> componentPrices = componentPriceService.getComponentPriceByOffer(offer);
        model.addAttribute("offer", offer);
        model.addAttribute("prices", componentPrices);
        model.addAttribute("stages", stageService.getByOffer(offer));
        return "offerForm";
    }
    //TODO poprawić
    @GetMapping("/clone/")
    public String cloneOffer(@ModelAttribute("offer") Offer offer){
        Offer newOffer = new Offer();
        newOffer = offer;
        newOffer.setDate(LocalDate.now());
        newOffer.setComponentOfferList(offer.getComponentOfferList());
        newOffer.setId(null);
        offerService.saveToBase(newOffer);

        return "redirect:/offers/showOneOffer/" + newOffer.getId();
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
        model.addAttribute(offer);
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
        offer.setDate(LocalDate.now());
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

    @PostMapping("/makepdf")
    public String makePdf(@RequestParam(name = "pdf-id") Long pdfId) throws IOException, DocumentException {
        pdfGenerator.makePdf(pdfId);
        return "homesite";
    }

    @GetMapping("/ajaxtest")
    public String ajaxTest() {

        return "ajax";
    }
}