package pl.cgg.offers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homeController(Model model){
        model.addAttribute("message", "Witaj na stronie z ofertami.");
        return "homesite";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "homesite";
    }
}
