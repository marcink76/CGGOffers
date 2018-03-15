package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.*;
import pl.cgg.offers.service.*;
import pl.cgg.offers.utility.Utils;
import pl.cgg.offers.wrappers.ComponentPriceWrapper;

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

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("offersList", offerService.getAll());
        return "showAllOffers";
    }

    @GetMapping("/showOneOffer/{id}")
    public String showOne(@PathVariable("id")Long id,
                          Model model){

        model.addAttribute("offer", offerService.getOneOffer(id));
        return "offerForm";
    }

    @GetMapping("/addOffer")
    public String addOffer(@RequestParam(required = false) Character firstLetter,
                           Model model) {
        List<Investor> investorList;
        if (firstLetter == null) {
            investorList = investorService.getAllInvestors();
        } else {
            investorList = investorService.getByFirstLetter(firstLetter);
        }
        model.addAttribute("firstLetter", firstLetter);
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
                                  Offer offer,
                                  Model model) {

        List<ComponentPrice> componentPrices = componentPriceService.getComponentPriceList();
        for (int i = 0; i < componentPrices.size() ; i++) {
            componentPrices.get(i).setComponentPrice(wrapper.getComponentPrices().get(i).getComponentPrice());
            componentPrices.get(i).setQuantity(wrapper.getComponentPrices().get(i).getQuantity());
            componentPriceService.saveComponentPrice(componentPrices.get(i));
        }

        model.addAttribute("componentPricesList", componentPrices);
        model.addAttribute(offer);
        offerService.saveToBase(offer);
        return "finalOfferForm";
    }

    @GetMapping("/ajaxtest")
    public String ajaxTest() {

        return "ajax";
    }
}