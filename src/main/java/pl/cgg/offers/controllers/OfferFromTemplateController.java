package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.models.Investor;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.service.InvestorService;
import pl.cgg.offers.service.OfferService;
import pl.cgg.offers.service.TemplateService;
import pl.cgg.offers.utility.Utils;

import java.util.List;

@Controller
@RequestMapping("/offerFromTemplate")
public class OfferFromTemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private InvestorService investorService;

    @Autowired
    private Utils utils;

    @GetMapping("/addOfferFromTemplate")
    public String addOfferFromTemplate(Model model) {
        model.addAttribute("templateList", templateService.getAllTemplate());
        return "addOfferFromTemplateForm";
    }

    @PostMapping("/setTemplateToOffer")
    public String setTemplateToOffer(@RequestParam(value = "template-id", required = false) Long id,
                                     @RequestParam(value = "investorType", required = false) String investorType,
                                     @RequestParam(required = false) Character firstLetter,
                                     Model model) {
        Offer offer = new Offer();

        Template template = templateService.getTemplateById(id);
        offer.setComponentOfferList(template.getComponentOfferList());
        offer.setOfferFromTemplate(true);
        offerService.setOffer(offer);
        if ("fromBase".equals(investorType)) {
            if (firstLetter == null) {
                model.addAttribute("investorsList", investorService.getAllInvestors());
            }
            if (firstLetter != null) {
                model.addAttribute("investorsList", investorService.getByFirstLetter(firstLetter));
            }
            model.addAttribute("method", "post");
            model.addAttribute("componentList", offer.getComponentOfferList());
            model.addAttribute("chars", utils.alphabet());
            model.addAttribute("link", "/offerFromTemplate/finalOfferFromTemplate");
            return "setInvestorFromBaseToTemplateOffer";
        }
        if ("adHoc".equals((investorType))) {
            model.addAttribute("investor", new Investor());
            model.addAttribute("componentList", offer.getComponentOfferList());
            return "setInvestorToTemplateOffer";
        }
        return "";
    }

    @PostMapping("/finalOfferFromTemplate")
    public String setTemplateOfferTobase(@RequestParam(value = "investorId", required = false) Long investorId,
                                         @RequestParam(value = "total-price", required = false) Double totalPrice,
                                         Investor investor,
                                         Model model) {
        Offer offer = offerService.getOffer();
        if (investorId != null) {
            Investor investorFromBase = investorService.getInvestorById(investorId);
            offer.setInvestor(investorFromBase);
        }
        if (investorId == null) {
            offer.setInvestor(investor);
        }
        offerService.setOffer(offer);
        model.addAttribute("componentList", offer.getComponentOfferList());
        model.addAttribute("investor", investor);
        model.addAttribute("offer", offer);

        offerService.saveToBase(offer);
        return "finalOfferFromTemplateForm";
    }
}
