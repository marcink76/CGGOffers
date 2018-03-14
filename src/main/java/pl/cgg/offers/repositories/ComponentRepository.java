package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.ComponentOffer;

@Repository
public interface ComponentRepository extends JpaRepository<ComponentOffer, Long> {
}
