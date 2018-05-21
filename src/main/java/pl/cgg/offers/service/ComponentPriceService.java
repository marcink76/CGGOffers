package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.models.ComponentPrice;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.repositories.ComponetPriceRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ComponentPriceService {

    @Autowired
    private ComponentService componentService;

    @Autowired
    private ComponetPriceRepository componetPriceRepository;

    @Autowired
    private OfferService offerService;

    private List<ComponentPrice> componentPriceList = new ArrayList<>();

    public List<ComponentPrice> getComponentPriceByOffer(Offer offer) {
        return componetPriceRepository.getAllByOffer(offer);
    }

    public void updateComponentPrice(Double componentPrice, Double quantity, Long id) {
        componetPriceRepository.updateComponentPrice(componentPrice, quantity, id);
    }


    public void deleteByComponentAndOffer(Long componentId, Long offerId) {
        ComponentOffer component = componentService.getOneComponent(componentId);
        Offer offer = offerService.getOneOffer(offerId);
        componetPriceRepository.deleteByComponentOfferAndOffer(component, offer);
    }


    public void removeComponentPrice(Offer offer, Long id) {
        List<ComponentPrice> prices = componetPriceRepository.getAllByOffer(offer);
        for (ComponentPrice price : prices) {
            if (price.getComponentOffer().getId().equals(id)) {
                componetPriceRepository.delete(price.getId());
                System.out.println(price.getComponentOffer().getId() + " " + price.getId());
            }
        }
    }

    public HashMap<ComponentOffer, ComponentPrice> getComponentPriceToMap() {
        HashMap<ComponentOffer, ComponentPrice> componentPriceHashMap = new HashMap<>();
        List<ComponentOffer> componentOfferList = componentService.getTempComponentOfferList();
        for (ComponentOffer components : componentOfferList) {
            componentPriceHashMap.put(components, new ComponentPrice());
        }
        return componentPriceHashMap;
    }

    public void saveComponentPrice(ComponentPrice componentPrice) {
        componetPriceRepository.save(componentPrice);
    }

    public List<ComponentPrice> getComponentPrice() {
        List<ComponentPrice> componentPrices = new ArrayList<>();
        List<ComponentOffer> componentOfferList = componentService.getTempComponentOfferList();
        for (ComponentOffer comps : componentOfferList) {
            componentPrices.add(new ComponentPrice());
        }
        return componentPrices;
    }

    public ComponentPrice getOneComponentPrice(Long id) {
        return componetPriceRepository.findOne(id);
    }

    public List<ComponentPrice> getPriceComponent() {
        return null;
    }

    public List<ComponentPrice> getComponentPriceList() {
        return componentPriceList;
    }

    public void setComponentPriceList(List<ComponentPrice> componentPriceList) {
        this.componentPriceList = componentPriceList;
    }
}
