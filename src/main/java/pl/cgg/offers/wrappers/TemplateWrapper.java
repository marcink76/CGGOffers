package pl.cgg.offers.wrappers;

import org.springframework.stereotype.Component;
import pl.cgg.offers.models.Template;

import java.util.List;

@Component
public class TemplateWrapper {

    private List<Template> templateWrapperList;

    public List<Template> getTemplateWrapperList() {
        return templateWrapperList;
    }

    public void setTemplateWrapperList(List<Template> templateWrapperList) {
        this.templateWrapperList = templateWrapperList;
    }
}
