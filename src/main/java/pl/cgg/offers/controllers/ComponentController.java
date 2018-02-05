package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.service.ComponentService;

@Controller
@RequestMapping("/component")
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("ComponentList", componentService.getAllComponents());
        return "showAllComponent";
    }

    @GetMapping("/addComponent")
    public String addComponent(Model model) {
        model.addAttribute("component", new Component());
        return "addComponentForm";
    }

    @PostMapping("/addComponentToBase")
    public String addComponentToBase(Component component){
        componentService.addToBase(component);
        return "redirect:showAll";
    }

}
