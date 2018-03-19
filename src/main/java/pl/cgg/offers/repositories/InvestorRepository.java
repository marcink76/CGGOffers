package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.Investor;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    List<Investor> getInvestorsByNameStartingWith (String firstLetter);
    List<Investor> getInvestorsByCityStartingWith (String investorCityFirstLetters);
    List<Investor> getInvestorsByLastNameStartingWith(String investorLastNameFirstLetters);
    List<Investor> getInvestorsByNameStartingWithAndLastNameStartingWith(String nameFirstLetters,
                                                                         String investorLastNameFirstLetters);
}
