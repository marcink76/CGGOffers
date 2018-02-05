package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.service.ComponentService;
import pl.cgg.offers.service.InvestorService;
import pl.cgg.offers.service.OfferService;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/offers")
@SessionAttributes("offer")
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
                                 @RequestParam Long investor_id,
                                 RedirectAttributes redirectAttributes) {
        offerService.setInvestorToOffer(offer, investor_id);
        System.out.println(investor_id);
        HashMap <Component, Boolean> componentMap = componentService.getComponentBoolMap();
        model.addAttribute("componentMap", componentMap);

        return "addComponentToOfferForm";
    }

    @PostMapping("/addComponentToOffer")
    public String setComponentsToOffer(@RequestParam HashMap<Component, Long> componentMap,
                                       Offer offer,
                                       Model model) {
        model.addAttribute("componentMap", componentMap);
        return "showCompleteOfferForm";
    }


}
