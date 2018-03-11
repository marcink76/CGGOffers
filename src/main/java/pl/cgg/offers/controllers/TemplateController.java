package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.service.ComponentService;
import pl.cgg.offers.service.TemplateService;
import pl.cgg.offers.wrappers.ComponentWrapper;

import java.util.List;

@Controller
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ComponentService componentService;

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
        List<Component> componentList = componentService.getAllComponents();
//        TODO
        for (int i = 0; i < tempList.size(); i++) {
            for (int j = 0; j < componentList.size(); j++) {
                if(tempList.get(i).getId() == null){

                }
            }
        }

//        for (int i = 0; i < componentList.size(); i++) {
//            if (tempList.get(i).getId() == null) {
//                final int j = i + 1;
//                componentList.removeIf(component -> component.getId() == j);
//            }
//        }
        model.addAttribute("wrapper", componentList);
        model.addAttribute("template", template);
        template.setComponentList(componentList);
        templateService.saveTemplate(template);
        return "showCompleteTemplate";
    }
//    @GetMapping("/addTemplate")
//    public String addTemplate(Model model) {
//        model.addAttribute("template", new Template());
//        model.addAttribute("components", componentService.getAllComponents());
//        return "addTemplateForm";
//    }
//
//    @PostMapping("/setToBase")
//    public String setTemplate(
//            @RequestParam("") Template template, Model model) {
//        template.setComponentList(componentService.getAllComponents());
//        if (templateService.saveTemplate(template)) {
//            model.addAttribute("message", "Błąd w dodawaniu szablonu");
//            return "message";
//        }
//        return "redirect:/templates/showAll";
//    }

}
