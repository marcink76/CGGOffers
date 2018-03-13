package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.*;
import pl.cgg.offers.service.*;
import pl.cgg.offers.utility.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/offers")
@SessionAttributes({"offer", "componentMap"})
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

    @GetMapping("/addOffer")
    public String addOffer(@RequestParam(required = false) Character firstLetter,
                           Model model) {
        List<Investor> investorList;
        if (firstLetter == null) {
            investorList = investorService.getAllInvestors();
        } else {
            investorList = investorService.getByFirstLetter(firstLetter);
        }

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
        model.addAttribute("componentList", componentService.getComponentList());
        if (componentService.getTempComponentList() != null) {
            model.addAttribute("tempComponentList", componentService.getTempComponentList());
        }
        return "addComponentToOfferForm";
    }

    @PostMapping("/addComponentToOffer")
    public String setComponentsToOffer(Offer offer, Model model) {
        List<Component> tempComponentList = componentService.getTempComponentList();
        offer.setComponentList(tempComponentList);
        model.addAttribute("componentList", tempComponentList);
        model.addAttribute("componentPriceList", componentPriceService.makeComponentPriceTempList());
        offerService.saveToBase(offer);
        return "showCompleteOfferForm";
    }

    @PostMapping("/completeOffer")
    public String saveOfferToBase(Offer offer, Model model) {


        //model.addAttribute("componentPrices", componentPrices);

        return "redirect:showall";
    }

    @GetMapping("/ajaxtest")
    public String ajaxTest() {

        return "ajax";
    }
}