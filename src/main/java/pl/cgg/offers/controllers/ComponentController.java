package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.service.ComponentService;

import javax.validation.Valid;

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
        model.addAttribute("component", new ComponentOffer());
        return "addComponentForm";
    }

    @PostMapping("/addComponentToBase")
    public String addComponentToBase(@Valid @ModelAttribute("component") ComponentOffer componentOffer,
                                     BindingResult result){
        if(result.hasErrors()){
            return "addComponentForm";
        }
        componentService.addToBase(componentOffer);
        return "redirect:showAll";
    }

}
