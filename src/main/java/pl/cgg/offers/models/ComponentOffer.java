package pl.cgg.offers.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @Column(name = "nazwa_uslugi")
    private String name;
    @Column(name = "opis")
    private String description;
    @Column(name = "jednostka")
    private String unit;
    @Column(name = "kategoria_skladnika")
    @Enumerated(value = EnumType.STRING)
    private ComponentCategory category;

    @ManyToMany
    private List<ComponentPrice> componentPriceList;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Offer> offer;

    public ComponentOffer(String name, String description, int quantity, double unitPrice, String unit, Offer offer) {
        this.name = name;
        this.description = description;
        this.unit = unit;
    }

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }

    public List<ComponentPrice> getComponentPriceList() {
        return componentPriceList;
    }

    public void setComponentPriceList(List<ComponentPrice> componentPriceList) {
        this.componentPriceList = componentPriceList;
    }

    public ComponentCategory getCategory() {
        return category;
    }

    public void setCategory(ComponentCategory category) {
        this.category = category;
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
