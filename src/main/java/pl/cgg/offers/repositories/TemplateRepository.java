package pl.cgg.offers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cgg.offers.models.Template;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long>{

    Template getByTemplateName(String name);

    Template getByTemplateNameStartsWith(String letters);

}
