package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cgg.offers.models.Investor;
import pl.cgg.offers.service.InvestorService;

@Controller
@RequestMapping("/inwestor")
public class InvestorController {

    @Autowired
    private InvestorService investorService;

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("investorList", investorService.getAllInvestors());

        return "showAllInvestors";
    }

    @GetMapping("/addInvestor")
    public String addInvesotr(@ModelAttribute("investor") Investor investor,
                              Model model ){
        model.addAttribute("investor", new Investor());

        return "addInvestroForm";
    }
    @PostMapping("/addInvestorToBase")
    public String addInvestorToBase(Investor investor){
        investorService.saveInvestor(investor);
        return "redirect:showAll";
    }
}