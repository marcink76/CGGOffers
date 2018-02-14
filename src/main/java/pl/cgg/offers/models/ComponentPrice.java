package pl.cgg.offers.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cena_skladnika")
public class ComponentPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ilosc")
    private int quantity;
    @Column(name = "cena_jednostkowa")
    private double componentPrice;
    @Column(name = "cena_calkowita")
    private double totalPrice;

    @ManyToMany
    private List<Component> componentList;

    @ManyToMany
    private List<Offer> offerList;

    public ComponentPrice(int quantity, double componentPrice){
        this.componentPrice = componentPrice;
        this.quantity = quantity;
        this.totalPrice = quantity * componentPrice;
    }

    public ComponentPrice(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getComponentPrice() {
        return componentPrice;
    }

    public void setComponentPrice(double componentPrice) {
        this.componentPrice = componentPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }
}
