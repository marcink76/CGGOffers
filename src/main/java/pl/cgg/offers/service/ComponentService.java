package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.repositories.ComponentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ComponentService {


    private List<Component> componentList;
    private List<Component> tempComponentList = new ArrayList<>();


    @Autowired
    private ComponentRepository componentRepository;

    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    public Component getOneComponent(Long id) {
        return componentRepository.findOne(id);
    }

    public void addToBase(Component component) {
        componentRepository.save(component);
    }

    public HashMap<Component, Boolean> getComponentBoolMap() {
        HashMap<Component, Boolean> componentBooleanHashMap = new HashMap<>();
        List<Component> list = componentRepository.findAll();

        for (Component components : list) {
            componentBooleanHashMap.put(components, true);
        }
        return componentBooleanHashMap;
    }

    public List<Component> setComponentToList(HashMap<Component, Boolean> componentMap) {

        List<Component> componentList = new ArrayList<>();
        for (HashMap.Entry<Component, Boolean> hashMap : componentMap.entrySet()) {
            if (!hashMap.getValue()) {
                componentList.add(hashMap.getKey());
            }
        }
        return componentList;
    }

    public void getDoubleListComponent(Long component_id) {

        if (component_id == null) {
            componentList = componentRepository.findAll();
            tempComponentList.clear();
        } else {

            for (Component componentsToAdd : componentList) {
                if (componentsToAdd.getId() == component_id) {
                    System.out.println(componentsToAdd.toString());
                    tempComponentList.add(componentsToAdd);
                }
            }
            componentList.removeIf(component -> component.getId() == component_id);
        }
    }

    // getters and setters
//------------------------------------------------------------

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public List<Component> getTempComponentList() {
        return tempComponentList;
    }

    public void setTempComponentList(List<Component> tempComponentList) {
        this.tempComponentList = tempComponentList;
    }
}