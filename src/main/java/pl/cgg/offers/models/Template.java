package pl.cgg.offers.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "szablon")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_szablonu")
    private long id;

    @Column(name = "nazwa_szablonu")
    private String templateName;

    @Column(name = "opis_szablonu")
    private String templateDescription;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ComponentOffer> componentOfferList;

    public Template() {
    }

    public Template(String templateName, List<ComponentOffer> componentOfferList) {
        this.templateName = templateName;
        this.componentOfferList = componentOfferList;
    }

    public Template(String templateName) {
        this.templateName = templateName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public List<ComponentOffer> getComponentOfferList() {
        return componentOfferList;
    }

    public void setComponentOfferList(List<ComponentOffer> componentOfferList) {
        this.componentOfferList = componentOfferList;
    }

    public String getTemplateDescription() {
        return templateDescription;
    }

    public void setTemplateDescription(String templateDescription) {
        this.templateDescription = templateDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return id == template.id &&
                Objects.equals(templateName, template.templateName) &&
                Objects.equals(componentOfferList, template.componentOfferList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, templateName, componentOfferList);
    }
}
