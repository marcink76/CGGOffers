package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.models.ComponentPrice;
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

    private List<ComponentPrice> componentPriceList = new ArrayList<>();

    public List<ComponentPrice> makeComponentPriceTempList() {
        List<Component> componentList = componentService.getTempComponentList();
        List<ComponentPrice> componentPriceList = new ArrayList<>();
        for (int i = 0; i < componentList.size(); i++) {
            componentPriceList.add(new ComponentPrice());
        }
        return componentPriceList;
    }

    public HashMap<Component, ComponentPrice> getComponentPriceToMap() {
        HashMap<Component, ComponentPrice> componentPriceHashMap = new HashMap<>();
        List<Component> componentList = componentService.getTempComponentList();
        for (Component components : componentList) {
            componentPriceHashMap.put(components, new ComponentPrice());
        }
        return componentPriceHashMap;
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
