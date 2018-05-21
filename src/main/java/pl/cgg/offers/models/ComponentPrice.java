package pl.cgg.offers.models;

import javax.persistence.*;

@Entity
@Table(name = "cena_skladnika")
public class ComponentPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ilosc")
    private double quantity;

    @Column(name = "cena_jednostkowa")
    private double componentPrice;

    @Column(name = "cena_calkowita")
    private double totalPrice;

    @Column(name = "ryczalt")
    private boolean aLumpSum;

    @Column(name = "pozycja_opcjonalna")
    private boolean optional;

    @OneToOne//(cascade = CascadeType.REMOVE)
    private ComponentOffer componentOffer;

    @OneToOne(cascade = CascadeType.REMOVE)
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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

    public boolean isaLumpSum() {
        return aLumpSum;
    }

    public void setaLumpSum(boolean aLumpSum) {
        this.aLumpSum = aLumpSum;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }
}
