package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.ComponentCategory;
import pl.cgg.offers.models.ComponentOffer;
import pl.cgg.offers.models.Units;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ComponentRepository extends JpaRepository<ComponentOffer, Long> {

    @Modifying
    @Query(value = "update ComponentOffer c " +
            "set c.category = ?1, c.description = ?2, c.name = ?3, c.unit =?4, c.id =?5  where c.id = id")
    void updateComponent(ComponentCategory category, String description, String name, Units unit, Long id);
}

// where c.id = skladnik_id