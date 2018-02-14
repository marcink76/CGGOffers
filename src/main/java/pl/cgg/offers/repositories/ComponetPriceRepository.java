package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.ComponentPrice;

@Repository
public interface ComponetPriceRepository extends JpaRepository<ComponentPrice, Long> {
}
