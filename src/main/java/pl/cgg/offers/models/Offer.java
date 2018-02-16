package pl.cgg.offers.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "oferta")
public class Offer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferty")
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Data_wprowadzenia")
    private LocalDate date;
    @Column(name = "opis")
    private String description;
    @Column(name = "Koszt_calkowity")
    private double totalPrice;

    @ManyToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Component> componentList;

    @OneToMany
    private List<ComponentPrice> componentPriceList;

    @ManyToOne
    private Investor investor;

    public Offer() {
    }

    public Offer(LocalDate date, String description, double totalPrice, List<Component> componentList, Investor investor) {
        this.date = date;
        this.description = description;
        this.totalPrice = totalPrice;
        this.componentList = componentList;
        this.investor = investor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public List<ComponentPrice> getComponentPriceList() {
        return componentPriceList;
    }

    public void setComponentPriceList(List<ComponentPrice> componentPriceList) {
        this.componentPriceList = componentPriceList;
    }
}
