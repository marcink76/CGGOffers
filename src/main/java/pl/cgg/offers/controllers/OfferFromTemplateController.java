package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.models.Investor;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.service.OfferService;
import pl.cgg.offers.service.TemplateService;

import java.util.List;

@Controller
@RequestMapping("/offerFromTemplate")
public class OfferFromTemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private OfferService offerService;

    @GetMapping("/addOfferFromTemplate")
    public String addOfferFromTemplate(Model model){
        model.addAttribute("templateList", templateService.getAllTemplate());
        return "addOfferFromTemplateForm";
    }
    @PostMapping("/setTemplateToOffer")
    public String setTemplateToOffer(@RequestParam("template-id") Long id,
                                     Model model){
        Template template = templateService.getTemplateById(id);
        List<Component> componentList = template.getComponentList();
        model.addAttribute("investor", new Investor());
        model.addAttribute("componentList", componentList);
        return "setInvestorToTemplateOffer";
    }
}
