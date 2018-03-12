package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.repositories.TemplateRepository;
import pl.cgg.offers.service.ComponentService;
import pl.cgg.offers.service.TemplateService;
import pl.cgg.offers.wrappers.ComponentWrapper;

import java.util.ArrayList;
import java.util.Iterator;
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
    public List<Component> allComponents() {
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
        wrapper.setComponentList(componentService.getAllComponents());
        model.addAttribute("wrapper", wrapper);
        model.addAttribute("template", new Template());
        return "addTemplateForm";
    }

    @PostMapping("/setToBase")
    public String addTemplate(@ModelAttribute("wrapper") ComponentWrapper wrapper, Template template, Model model) {
        template.setComponentList(null);
        List<Component> tempList = wrapper.getComponentList();
        List<Component> componentList = new ArrayList<>();// = componentService.getAllComponents();

        tempList.removeIf(component -> component.getId() == null);

        for (Component comp : tempList) {
            componentList.add(componentService.getOneComponent(comp.getId()));
        }
        componentService.setTempComponentList(componentList);

        model.addAttribute("wrapper", componentList);
        model.addAttribute("template", template);
        template.setComponentList(componentList);
        templateRepository.save(template);
        return "showCompleteTemplate";
    }
}
