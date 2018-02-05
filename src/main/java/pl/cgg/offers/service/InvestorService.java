package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Investor;
import pl.cgg.offers.repositories.InvestorRepository;

import java.util.List;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    public List<Investor> getAllInvestors(){
        return investorRepository.findAll();
    }
    public void saveInvestor(Investor investor){
        investorRepository.save(investor);
    }

    public Investor getInvestorById(Long id){
        return investorRepository.findOne(id);
    }
}
