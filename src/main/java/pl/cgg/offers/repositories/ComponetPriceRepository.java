package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.models.ComponentPrice;
import pl.cgg.offers.models.Offer;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ComponetPriceRepository extends JpaRepository<ComponentPrice, Long> {

    List<ComponentPrice> getAllByOffer(Offer offer);

    void deleteByComponentOffer(ComponentOffer component);

    void deleteByComponentOfferAndOffer(ComponentOffer component, Offer offer);

    //TODO
    @Modifying
    @Query(value = "UPDATE ComponentPrice c set c.componentPrice = ?1, c.quantity = ?2 where c.id = ?3")
    void updateComponentPrice(Double price, Double quantity, Long id);


}
