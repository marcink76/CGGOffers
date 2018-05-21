package pl.cgg.offers.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.service.ComponentService;

import java.util.List;

@RestController
@RequestMapping("/api/components")
public class ComponentRESTCtrl {

    @Autowired
    private ComponentService componentService;

    @GetMapping("")
    public List<ComponentOffer> showAll() {
        return componentService.getAllComponents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showOneComponent(@PathVariable("id") Long id) {
        ComponentOffer componentOffer = componentService.getOneComponent(id);
        if (componentOffer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(componentOffer);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addComponent(@RequestBody ComponentOffer componentOffer) {
        componentService.addToBase(componentOffer);
        return ResponseEntity.ok(componentOffer);
    }
//  TODO add PUT request
//    @PutMapping("{id}")
//    public ResponseEntity<?>
}