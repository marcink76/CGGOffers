package pl.cgg.offers.models;

import javax.persistence.*;

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

    @ManyToOne
    private ComponentOffer componentOffer;

    @ManyToOne
    private Offer offer;

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

    public ComponentOffer getComponentOffer() {
        return componentOffer;
    }

    public void setComponentOffer(ComponentOffer componentOffer) {
        this.componentOffer = componentOffer;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
