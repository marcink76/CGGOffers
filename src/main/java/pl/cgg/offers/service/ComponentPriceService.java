package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.models.ComponentPrice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ComponentPriceService {

    @Autowired
    private ComponentService componentService;
    private List<ComponentPrice> componentPriceList = new ArrayList<>();

    public HashMap<Component, ComponentPrice> getComonentPriceToMap() {
        HashMap<Component, ComponentPrice> componentPriceHashMap = new HashMap<>();
        List<Component> componentList = componentService.getTempComponentList();
        for (Component components : componentList) {
            componentPriceHashMap.put(components, new ComponentPrice());
        }
        return componentPriceHashMap;
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
