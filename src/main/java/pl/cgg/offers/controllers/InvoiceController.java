package pl.cgg.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.service.InvoiceService;
import pl.cgg.offers.service.OfferService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/showAll")
    public String showAllInvoices(Model model){
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "showAllInvoices";
    }

    @PostMapping("/addInvoice")
    public String addInvoice(@RequestParam("offerId") Long offerId) {

        invoiceService.addToBase(offerId);

        return "redirect:/offers/showAll";
    }


}
