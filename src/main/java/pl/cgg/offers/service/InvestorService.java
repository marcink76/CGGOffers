package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Investor;
import pl.cgg.offers.repositories.InvestorRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class InvestorService {

    private List<Investor> investorList;

    @Autowired
    private InvestorRepository investorRepository;

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public void addInvestor(Investor investor) {
        investorRepository.save(investor);
    }

    public Investor saveInvestor(Investor investor) {
        investorRepository.save(investor);
        return investor;
    }

    public List<Investor> getInvestorList() {
        return investorList;
    }

    public void setInvestorList(List<Investor> investorList) {
        this.investorList = investorList;
    }

    public Investor getInvestorById(Long id) {
        return investorRepository.findOne(id);
    }

    public List<Investor> getByFirstLetter(Character firstLetter){
        String firstLetters = firstLetter.toString();
        return investorRepository.getInvestorsByNameStartsWith(firstLetters);
    }
}
