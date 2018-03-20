package pl.cgg.offers.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@Entity
@Table(name = "skladnik_oferty")
public class ComponentOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skladnik_id")
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 40, message = "Nazwa składnika musi mieć minimum 2 litery!")
    @Column(name = "nazwa_uslugi")
    private String name;

    @Column(name = "opis")
    private String description;

    @Column(name = "jednostka")
    @Enumerated(value = EnumType.STRING)
    private Units unit;

    @Column(name = "kategoria_skladnika")
    @Enumerated(value = EnumType.STRING)
    private ComponentCategory category;

    @OneToOne
    private ComponentPrice componentPrice;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Offer> offer;

    @ManyToOne
    @JoinColumn(name = "id_skladnika")
    private Template template;

    public ComponentOffer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }

    public ComponentPrice getComponentPrice() {
        return componentPrice;
    }

    public void setComponentPrice(ComponentPrice componentPrice) {
        this.componentPrice = componentPrice;
    }

    public ComponentCategory getCategory() {
        return category;
    }

    public void setCategory(ComponentCategory category) {
        this.category = category;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "ComponentOffer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", offer=" + offer +
                '}';
    }
}
