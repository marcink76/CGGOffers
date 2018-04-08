package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.models.Stage;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> getOffersByInvestor_CityStartsWith(String filterLetter);

    @Modifying
    @Query(value = "UPDATE Offer o set o.stages = ?1 where o.id = ?2")
    void updateStagesInOffer (List<Stage> stages, Long id);


}