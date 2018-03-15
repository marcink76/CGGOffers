package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.Investor;
import pl.cgg.offers.service.InvestorService;

import javax.validation.Valid;

@Controller
@RequestMapping("/investor")
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
                              Model model) {
        model.addAttribute("investor", new Investor());

        return "addInvestrorForm";
    }

    @PostMapping("/addInvestorToBase")
    public String addInvestorToBase(@Valid @ModelAttribute Investor investor, BindingResult result) {
        if (result.hasErrors()) {
            return "addInvestor";
        }
        investorService.addInvestor(investor);
        return "redirect:showAll";
    }

    @PostMapping("/deleteInvestor")
    public String deleteInvestor(@RequestParam("investorId") Long investorId) {
        investorService.deleteInvestorFromBase(investorId);
        return "redirect:showAll";
    }
}