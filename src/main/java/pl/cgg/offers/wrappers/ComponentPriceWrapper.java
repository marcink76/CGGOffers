package pl.cgg.offers.wrappers;
import pl.cgg.offers.models.ComponentPrice;
import java.util.List;

public class ComponentPriceWrapper {
    private List<ComponentPrice> componentPrices;

    public List<ComponentPrice> getComponentPrices() {
        return componentPrices;
    }

    public void setComponentPrices(List<ComponentPrice> componentPrices) {
        this.componentPrices = componentPrices;
    }
}
