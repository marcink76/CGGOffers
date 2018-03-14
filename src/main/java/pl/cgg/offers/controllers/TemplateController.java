package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.repositories.TemplateRepository;
import pl.cgg.offers.service.ComponentService;
import pl.cgg.offers.service.TemplateService;
import pl.cgg.offers.wrappers.ComponentWrapper;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ComponentService componentService;

    @Autowired
    private TemplateRepository templateRepository;

    @ModelAttribute("allComponents")
    public List<ComponentOffer> allComponents() {
        return componentService.getAllComponents();
    }

    @GetMapping("/showAll")
    public String showAllTemplate(Model model) {
        model.addAttribute("templatesList", templateService.getAllTemplate());
        return "showAllTemplate";
    }

    @GetMapping("/addTemplate")
    public String addTemplate2(Model model) {
        ComponentWrapper wrapper = new ComponentWrapper(); // nowy wrapper
        wrapper.setComponentOfferList(componentService.getAllComponents());
        model.addAttribute("wrapper", wrapper);
        model.addAttribute("template", new Template());
        return "addTemplateForm";
    }

    @PostMapping("/setToBase")
    public String addTemplate(@ModelAttribute("wrapper") ComponentWrapper wrapper, Template template, Model model) {
        template.setComponentOfferList(null);
        List<ComponentOffer> tempList = wrapper.getComponentOfferList();
        List<ComponentOffer> componentOfferList = new ArrayList<>();

        tempList.removeIf(component -> component.getId() == null);

        for (ComponentOffer comp : tempList) {
            componentOfferList.add(componentService.getOneComponent(comp.getId()));
        }

        template.setComponentOfferList(componentOfferList);
        model.addAttribute("wrapper", componentOfferList);
        model.addAttribute("template", template);
        model.addAttribute("message", templateService.saveTemplate(template));

        return "showCompleteTemplate";
    }
}
