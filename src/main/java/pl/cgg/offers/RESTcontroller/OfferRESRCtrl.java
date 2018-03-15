package pl.cgg.offers.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.service.OfferService;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferRESRCtrl {

    @Autowired
    private OfferService offerService;

    @GetMapping("")
    public List<Offer> getOffers(){
        return offerService.getAll();
    }
}
