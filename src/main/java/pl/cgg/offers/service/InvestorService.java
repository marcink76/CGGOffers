package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Investor;
import pl.cgg.offers.repositories.InvestorRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class InvestorService {

    private List<Investor> investorList;

    private Investor investor;

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

    public List<Investor> getOffersByFirstLetters(String nameFirstLetters,
                                                  String investorLastNameFirstLetters,
                                                  String investorCityFirstLetters) {
        if (nameFirstLetters.equals("") && investorLastNameFirstLetters.equals("")) {
            return investorRepository.getInvestorsByCityStartingWith(investorCityFirstLetters);
        }
        if (investorLastNameFirstLetters.equals("") && investorCityFirstLetters.equals("")) {
            return investorRepository.getInvestorsByNameStartingWith(nameFirstLetters);
        }
        if (investorCityFirstLetters.equals("") && investorLastNameFirstLetters.equals("")) {
            return investorRepository.getInvestorsByLastNameStartingWith(investorLastNameFirstLetters);
        }
        if (investorCityFirstLetters.equals("")) {
            return investorRepository.getInvestorsByNameStartingWithAndLastNameStartingWith(nameFirstLetters, investorLastNameFirstLetters);
        }
        if (nameFirstLetters.equals("")) {
            return investorRepository.getInvestorsByLastNameStartingWithAndCityStartingWith
                    (investorLastNameFirstLetters, investorCityFirstLetters);
        }
        if (investorLastNameFirstLetters.equals("")) {
            return investorRepository.getInvestorsByNameStartingWithAndCityStartingWith(nameFirstLetters, investorCityFirstLetters);
        }
        return investorRepository.getInvestorsByNameStartingWithAndCityStartingWithAndLastNameStartingWith
                (nameFirstLetters,
                investorCityFirstLetters, investorLastNameFirstLetters);
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

    public void deleteInvestorFromBase(Long investorId) {
        investorRepository.delete(investorId);
    }

    public List<Investor> getByFirstLetter(String firstLetter) {
        String firstLetters = firstLetter;
        return investorRepository.getInvestorsByNameStartingWith(firstLetters);
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
