package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.models.Stage;
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

    public void updateOffer(Offer offer){
    }

    public void updateOfferByStages(List<Stage> stages, Long id){
        offerRepository.updateStagesInOffer(stages, id);
    }

    public void saveToBase(Offer offer) {
        offerRepository.save(offer);
    }

    public List<Offer> getOffersByString(String filterString){
        return offerRepository.getOffersByInvestor_CityStartsWith(filterString);
    }

    public void setInvestorToOffer(Offer offer, Long id){
        offer.setInvestor(investorService.getInvestorById(id));
        offerRepository.save(offer);
    }

    public Offer getOneOffer(Long id){
        return offerRepository.findOne(id);
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