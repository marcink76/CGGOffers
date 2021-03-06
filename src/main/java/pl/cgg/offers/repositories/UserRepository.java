package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
}
