package pl.cgg.offers.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "skladnik_oferty")
public class Component implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skladnik_id")
    private Long id;
    @NotNull
    @Column(name = "Nazwa_uslugi")
    private String name;
    @Column(name = "opis")
    private String description;
    @Column(name = "jednostka")
    private String unit;

    //TODO Zmienić na ManyToOne
    @OneToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ComponentPrice> componentPriceList;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Offer> offer;

    public Component(String name, String description, int quantity, double unitPrice, String unit, Offer offer) {
        this.name = name;
        this.description = description;
        this.unit = unit;

    }

    public Component() {
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

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", offer=" + offer +
                '}';
    }
}
