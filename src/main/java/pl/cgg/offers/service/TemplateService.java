package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.repositories.TemplateRepository;

import java.util.List;

@Service
public class TemplateService {

    private Template template;

    @Autowired
    private TemplateRepository templateRepository;

    public Template getTemplateById(Long id) {
        return templateRepository.findOne(id);
    }

    public List<Template> getAllTemplate() {
        return templateRepository.findAll();
    }

    public boolean saveTemplate(Template template) {
        boolean checkName = false;
        List<Template> templateList = this.getAllTemplate();
        for (Template templates : templateList) {
            checkName = templates.getTemplateName().equals(template.getTemplateName());
        }
        if (checkName) {
            return true;
        } else {
            templateRepository.save(template);
            return false;
        }
    }

    public Template getByName(String name) {
        return templateRepository.getByTemplateName(name);
    }

    public String getByFirstLetter(String letters) {
        return templateRepository.getByTemplateNameStartsWith(letters).getTemplateName();
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
