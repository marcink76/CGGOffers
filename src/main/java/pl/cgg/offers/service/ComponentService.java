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

    @Autowired
    private ComponentRepository componentRepository;

    public List<Component> getAllComponents() {
        return componentRepository.findAll();
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

    public List<Component> getComponent(Long id){
        List<Component> components = new ArrayList<>();
         if (components.size() == 0){
             components = componentRepository.findAll();
         }

        return components;
    }
}