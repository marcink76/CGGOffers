package pl.cgg.offers.wrappers;

import org.springframework.stereotype.Component;
import pl.cgg.offers.models.ComponentPrice;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComponentPriceWrapper {
    List<ComponentPrice> componentPriceList = new ArrayList<>();

    public List<ComponentPrice> getComponentPriceList() {
        return componentPriceList;
    }

    public void setComponentPriceList(List<ComponentPrice> componentPriceList) {
        this.componentPriceList = componentPriceList;
    }
}
