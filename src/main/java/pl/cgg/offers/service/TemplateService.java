package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.repositories.TemplateRepository;

import java.util.List;

@Service
public class TemplateService {
    @Autowired
    private TemplateRepository templateRepository;

    public List<Template> getAllTemplate(){
        return templateRepository.findAll();
    }

    public void saveTemplate(Template template){
        templateRepository.save(template);
    }
}
