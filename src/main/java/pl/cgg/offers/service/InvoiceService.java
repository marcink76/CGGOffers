package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Invoice;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.repositories.InvoiceRepository;

import java.time.LocalDate;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OfferService offerService;

    public void addToBase(Long offerId){
        Invoice invoice = new Invoice();
        invoice.setCreatingDate(LocalDate.now());
        Offer offer = offerService.getOneOffer(offerId);
        offer.setInvoicing(true);
        invoice.setOffer(offer);
        invoiceRepository.save(invoice);
        offerService.saveToBase(offer);
    }
}
