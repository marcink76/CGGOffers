package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.models.Stage;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

    //List<Stage> findAllByOffers(Offer offer);

    //@Query(value = "select Stage s from Stage where offer ")
    List<Stage> getByOffer(Offer offer);

//    @Query("select Stage s where ")
//    List<Stage>
}
