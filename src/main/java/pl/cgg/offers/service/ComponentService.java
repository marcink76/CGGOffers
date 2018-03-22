package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.repositories.ComponentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Service
public class ComponentService {

    private ComponentOffer componentOffer;
    private List<ComponentOffer> componentOfferList;
    private List<ComponentOffer> tempComponentOfferList = new ArrayList<>();


    @Autowired
    private ComponentRepository componentRepository;

    public List<ComponentOffer> getAllComponents() {
        return componentRepository.findAll();
    }

    public ComponentOffer getOneComponent(Long id) {
        return componentRepository.findOne(id);
    }

    public void addToBase(ComponentOffer componentOffer) {
        componentRepository.save(componentOffer);
    }

    public HashMap<ComponentOffer, Boolean> getComponentBoolMap() {
        HashMap<ComponentOffer, Boolean> componentBooleanHashMap = new HashMap<>();
        List<ComponentOffer> list = componentRepository.findAll();

        for (ComponentOffer components : list) {
            componentBooleanHashMap.put(components, true);
        }
        return componentBooleanHashMap;
    }

    public List<ComponentOffer> setComponentToList(HashMap<ComponentOffer, Boolean> componentMap) {

        List<ComponentOffer> componentOfferList = new ArrayList<>();
        for (HashMap.Entry<ComponentOffer, Boolean> hashMap : componentMap.entrySet()) {
            if (!hashMap.getValue()) {
                componentOfferList.add(hashMap.getKey());
            }
        }
        return componentOfferList;
    }

    public void addToTempComponentList(Long componentId, Long componentIdDel) {

        if (componentId == null && componentIdDel == null) {
            componentOfferList = componentRepository.findAll();
            tempComponentOfferList.clear();
        } else if (componentId != null && componentIdDel == null) {
            for (ComponentOffer componentsToAdd : componentOfferList) {
                if (componentsToAdd.getId() == componentId) {
                    System.out.println(componentsToAdd.toString());
                    tempComponentOfferList.add(componentsToAdd);
                }
            }
            componentOfferList.removeIf(component -> component.getId() == componentId);
        } else if (componentIdDel != null && componentId == null) {
            for (ComponentOffer componentsToAdd : tempComponentOfferList) {
                if (componentsToAdd.getId() == componentIdDel) {
                    System.out.println(componentsToAdd.toString());
                    componentOfferList.add(componentsToAdd);
                }
            }
            tempComponentOfferList.removeIf(component -> component.getId() == componentIdDel);
        }
    }

    public void mergeComponent(ComponentOffer component){
        componentRepository.updateComponent(component.getCategory(),
                                            component.getDescription(),
                                            component.getName(),
                component.getUnit(),
                component.getId());
    }

    // getters and setters
//------------------------------------------------------------

    public List<ComponentOffer> getComponentOfferList() {
        return componentOfferList;
    }

    public void setComponentOfferList(List<ComponentOffer> componentOfferList) {
        this.componentOfferList = componentOfferList;
    }

    public List<ComponentOffer> getTempComponentOfferList() {
        return tempComponentOfferList;
    }

    public void setTempComponentOfferList(List<ComponentOffer> tempComponentOfferList) {
        this.tempComponentOfferList = tempComponentOfferList;
    }

    public ComponentOffer getComponentOffer() {
        return componentOffer;
    }

    public void setComponentOffer(ComponentOffer componentOffer) {
        this.componentOffer = componentOffer;
    }
}