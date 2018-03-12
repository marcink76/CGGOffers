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

    private String templateName;

    @ManyToMany
    private List<Component> componentList;

    public Template() {
    }

    public Template(String templateName, List<Component> componentList) {
        this.templateName = templateName;
        this.componentList = componentList;
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

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return id == template.id &&
                Objects.equals(templateName, template.templateName) &&
                Objects.equals(componentList, template.componentList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, templateName, componentList);
    }
}
