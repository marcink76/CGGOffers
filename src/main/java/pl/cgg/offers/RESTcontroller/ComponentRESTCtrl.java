package pl.cgg.offers.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.Component;
import pl.cgg.offers.service.ComponentService;

import java.util.List;

@RestController
@RequestMapping("/api/components")
public class ComponentRESTCtrl {

    @Autowired
    private ComponentService componentService;

    @GetMapping("")
    public List<Component> showAll() {
        return componentService.getAllComponents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showOneComponent(@PathVariable("id") Long id) {
        Component component = componentService.getOneComponent(id);
        if (component == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(component);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addComponent(@RequestBody Component component) {
        componentService.addToBase(component);
        return ResponseEntity.ok(component);
    }
    //TODO add PUT request
//    @PutMapping("{id}")
//    public ResponseEntity<?>
}