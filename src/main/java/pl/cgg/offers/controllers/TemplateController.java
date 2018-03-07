package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.service.ComponentService;
import pl.cgg.offers.service.TemplateService;

@Controller
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ComponentService componentService;


    @GetMapping("/showAll")
    public String showAllTemplate(Model model) {
        model.addAttribute("templatesList", templateService.getAllTemplate());
        return "showAllTemplate";
    }

    @GetMapping("/addTemplate")
    public String addTemplate(Model model){
        model.addAttribute("template", new Template());
        model.addAttribute("components", componentService.getAllComponents());
        return "addTemplateForm";
    }
    @PostMapping("/setToBase")
    public String setTemplate(Template template){
        template.setComponentList(componentService.getAllComponents());
        templateService.saveTemplate(template);
        return "showAllTemplate";
    }
}
