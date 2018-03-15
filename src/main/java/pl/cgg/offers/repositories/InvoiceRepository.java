package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
}
