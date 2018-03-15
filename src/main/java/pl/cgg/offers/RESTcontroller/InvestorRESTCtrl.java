package pl.cgg.offers.RESTcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cgg.offers.models.Investor;
import pl.cgg.offers.service.InvestorService;

import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorRESTCtrl {

    @Autowired
    private InvestorService investorService;

    @GetMapping("")
    private List<Investor> showAll(){
        return investorService.getAllInvestors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneInvestor(@PathVariable("id") Long id){
        Investor investor = investorService.getInvestorById(id);
        if (investor == null){
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(investor);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addInvestor(@RequestBody Investor investor ){
        Investor investor1 = investorService.saveInvestor(investor);
        return ResponseEntity.ok(investor1);
    }
}