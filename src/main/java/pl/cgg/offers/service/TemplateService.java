package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Template;
import pl.cgg.offers.repositories.TemplateRepository;

import java.util.ArrayList;
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

    public List<String> saveTemplate(Template template) {
        List<String> stringList = new ArrayList<>();
        boolean validation = true;
        if (template.getTemplateName() == null || template.getTemplateName().equals("")) {
            validation = false;
            stringList.add("Uzupełnij nazwę profilu");
        }
        if (template.getComponentList() == null || template.getComponentList().isEmpty()) {
            validation = false;
            stringList.add("Dodaj składniki szablonu");
        }
        if (compareName(template)) {
            stringList.add("Szablon o takiej nazwie jest już w bazie. Zmień nazwę");
            validation = false;
        }

        if (validation) {
            templateRepository.save(template);
            stringList.add("Zapis poprawny");
            return stringList;
        } else {
            return stringList;
        }
    }

    private boolean compareName(Template template) {
        List<Template> templateList = this.getAllTemplate();
        for (Template templates : templateList) {
            if (templates.getTemplateName().equals(template.getTemplateName())) {
                return true;
            }
        }
        return false;
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
