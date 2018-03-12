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
public class Component implements Serializable, Comparator<Component>, Comparable<Component>  {

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

    @ManyToMany
    private List<ComponentPrice> componentPriceList;

    @ManyToMany(fetch = FetchType.EAGER)
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

    @Override
    public int compareTo(Component o) {
        return 0;
    }

    @Override
    public int compare(Component o1, Component o2) {
        return 0;
    }

    @Override
    public Comparator<Component> reversed() {
        return null;
    }

    @Override
    public Comparator<Component> thenComparing(Comparator<? super Component> other) {
        return null;
    }

    @Override
    public <U> Comparator<Component> thenComparing(Function<? super Component, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Component> thenComparing(Function<? super Component, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Component> thenComparingInt(ToIntFunction<? super Component> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Component> thenComparingLong(ToLongFunction<? super Component> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Component> thenComparingDouble(ToDoubleFunction<? super Component> keyExtractor) {
        return null;
    }
}
