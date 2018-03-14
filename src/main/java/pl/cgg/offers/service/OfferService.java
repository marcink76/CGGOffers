package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.repositories.OfferRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ComponentService componentService;

    @Autowired
    private InvestorService investorService;

    private Offer offer;

    public List<Offer> getAll() {
        return offerRepository.findAll();
    }

    public void saveToBase(Offer offer) {
        offerRepository.save(offer);
    }

    public void setInvestorToOffer(Offer offer, Long id){
        offer.setDate(LocalDate.now());
        offer.setInvestor(investorService.getInvestorById(id));
        offerRepository.save(offer);
    }

    public List<ComponentOffer> getAllComponent(){
        return componentService.getAllComponents();
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}