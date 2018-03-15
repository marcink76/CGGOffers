package pl.cgg.offers.AjaxControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AJAXcontroller {

    @GetMapping("/ajax")
    public String ajax(@RequestParam(required = false) Integer id, Model model) {
        return "ajax";
    }
}
