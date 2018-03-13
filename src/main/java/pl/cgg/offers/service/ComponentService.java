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

    private Component component;
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

    public void addToTempComponentList(Long componentId, Long componentIdDel) {

        if (componentId == null && componentIdDel == null) {
            componentList = componentRepository.findAll();
            tempComponentList.clear();
        } else if (componentId != null && componentIdDel == null) {
            for (Component componentsToAdd : componentList) {
                if (componentsToAdd.getId() == componentId) {
                    System.out.println(componentsToAdd.toString());
                    tempComponentList.add(componentsToAdd);
                }
            }
            componentList.removeIf(component -> component.getId() == componentId);
        } else if (componentIdDel != null && componentId == null) {
            for (Component componentsToAdd : tempComponentList) {
                if (componentsToAdd.getId() == componentIdDel) {
                    System.out.println(componentsToAdd.toString());
                    componentList.add(componentsToAdd);
                }
            }
            tempComponentList.removeIf(component -> component.getId() == componentIdDel);
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

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
}