package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.ComponentPrice;
import pl.cgg.offers.models.Offer;

import java.util.List;

@Repository
public interface ComponetPriceRepository extends JpaRepository<ComponentPrice, Long> {

    List<ComponentPrice> getAllByOffer(Offer offer);

}
