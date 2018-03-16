package pl.cgg.offers.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "oferta")
public class Offer {
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

    @Column(name = "zafakturowanie")
    private boolean invoicing;

    @Column(name = "oferta_z_szablonu")
    private boolean offerFromTemplate;


    @ManyToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ComponentOffer> componentOfferList;

    @ManyToOne
    private Investor investor;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_szablonu")
    private Template template;

    public Offer() {
    }

    public Offer(LocalDate date, String description, double totalPrice, List<ComponentOffer> componentOfferList, Investor investor) {
        this.date = date;
        this.description = description;
        this.totalPrice = totalPrice;
        this.componentOfferList = componentOfferList;
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

    public List<ComponentOffer> getComponentOfferList() {
        return componentOfferList;
    }

    public void setComponentOfferList(List<ComponentOffer> componentOfferList) {
        this.componentOfferList = componentOfferList;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public boolean isInvoicing() {
        return invoicing;
    }

    public void setInvoicing(boolean invoicing) {
        this.invoicing = invoicing;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isOfferFromTemplate() {
        return offerFromTemplate;
    }

    public void setOfferFromTemplate(boolean offerFromTemplate) {
        this.offerFromTemplate = offerFromTemplate;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
