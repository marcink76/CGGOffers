package pl.cgg.offers.wrappers;

import org.springframework.stereotype.Component;
import pl.cgg.offers.models.Template;

import java.util.HashMap;

@Component
public class TemplateWrapper {

    private HashMap<Template, Double> templateWrapperList;

    public HashMap<Template, Double> getTemplateWrapperList() {
        return templateWrapperList;
    }

    public void setTemplateWrapperList(HashMap<Template, Double> templateWrapperList) {
        this.templateWrapperList = templateWrapperList;
    }
}
