package pl.cgg.offers.service;

import org.springframework.stereotype.Service;
import pl.cgg.offers.models.ComponentPrice;
import pl.cgg.offers.models.Offer;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComponentPriceService {

    private List<ComponentPrice> componentPriceList = new ArrayList<>();

    public List<ComponentPrice> getPriceComponent(Offer offer) {
        return null;
    }

    public List<ComponentPrice> getComponentPriceList() {
        return componentPriceList;
    }

    public void setComponentPriceList(List<ComponentPrice> componentPriceList) {
        this.componentPriceList = componentPriceList;
    }
}
