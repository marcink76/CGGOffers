package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    //TODO  dokończyć edycję

    @GetMapping("/edit")
    public String editComponent(@RequestParam("id") Long id,
                                Model model) {
        ComponentOffer component = componentService.getOneComponent(id);
        model.addAttribute("component", component);
        model.addAttribute("edit", true);
        return "addComponentForm";
    }

    @GetMapping("/addComponent")
    public String addComponent(Model model) {
        model.addAttribute("component", new ComponentOffer());
        return "addComponentForm";
    }

    @PostMapping("/addComponentToBase")
    public String addComponentToBase(@Valid @ModelAttribute("component") ComponentOffer componentOffer,
                                     @RequestParam(value = "edit", required = false) boolean edit,
                                     BindingResult result) {
        if (result.hasErrors()) {
            return "addComponentForm";
        }
        if (edit) {
            componentService.editComponent(componentOffer);
        } else {
            componentService.addToBase(componentOffer);
        }
        return "redirect:showAll";
    }

}
