package pl.cgg.offers.wrappers;

import pl.cgg.offers.models.ComponentOffer;

import java.util.List;

public class ComponentWrapper {
    private List<ComponentOffer> componentOfferList;

    public List<ComponentOffer> getComponentOfferList() {
        return componentOfferList;
    }

    public void setComponentOfferList(List<ComponentOffer> componentOfferList) {
        this.componentOfferList = componentOfferList;
    }
}
