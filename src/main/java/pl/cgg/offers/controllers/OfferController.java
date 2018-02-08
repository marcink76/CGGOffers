package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.service.ComponentService;
import pl.cgg.offers.service.InvestorService;
import pl.cgg.offers.service.OfferService;

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

    @GetMapping("/showAll")
    private String showAll(Model model) {
        model.addAttribute("offersList", offerService.getAll());
        return "showAllOffers";
    }

    @GetMapping("/addOffer")
    public String addOffer(Model model) {
        model.addAttribute("offer", new Offer());
        model.addAttribute("investorsList", investorService.getAllInvestors());
        return "setInvestorToOfferForm";
    }

    @PostMapping("/setInvestorToOffer")
    public String addOfferToBase(Offer offer, Model model,
                                 @RequestParam Long investor_id) {
        offerService.setInvestorToOffer(offer, investor_id);

        return "addComponentToOfferForm";
    }

    @PostMapping("/addComponentToOffer")
    public String setComponentsToOffer(@ModelAttribute("componentMap") HashMap<Component, Boolean> componentMap,
                                       Offer offer,
                                       Model model) {
        List<Component> componentList = componentService.setComponentToList(componentMap);
        model.addAttribute("componentList", componentList);
        return "showCompleteOfferForm";
    }


}
