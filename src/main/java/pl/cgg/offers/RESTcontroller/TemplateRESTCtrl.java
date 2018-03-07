package pl.cgg.offers.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.service.TemplateService;

@RestController
@RequestMapping("/api/templates")
public class TemplateRESTCtrl {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getTemplateByName(@PathVariable("name") String name){
        Template template = templateService.getByName(name);
        if (name == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(template);
    }
    @ResponseBody
    @GetMapping("/getByFirstLetter/{letters}")
    public String getTemplateByFirstLetter(@PathVariable("letters") String letters){
        String name = templateService.getByFirstLetter(letters);
        System.out.println(name);
        return name;
    }
}
