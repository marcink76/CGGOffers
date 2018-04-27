package pl.cgg.offers.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "template", "user"})
@Table(name = "oferta")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferty")
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Data_wprowadzenia")
    //@NotNull
    private LocalDate date;

    @Column(name = "opis")
    private String description;

    @Column(name = "Koszt_calkowity")
    private double totalPrice;

    @Column(name = "Koszt_ryczaltowy")
    private double totalLumpPrice;

    @Column(name = "Zafakturowanie")
    private boolean invoicing;

    @Column(name = "Oferta_z_szablonu")
    private boolean offerFromTemplate;

    @Column(name = "Archwalne")
    private boolean archival;

    @Column(name = "Koszt_skladników_opcjonalnych")
    private double optionalComponentPrice;

    @Column(name = "Rabat")
    private int discount;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ComponentOffer> componentOfferList;

    @ManyToOne
    private Investor investor;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_szablonu")
    private Template template;

    @OneToMany
    @JoinColumn(name = "offer_id", referencedColumnName = "id_oferty")
    private List<Stage> stages;

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

    public boolean isArchival() {
        return archival;
    }

    public void setArchival(boolean archival) {
        this.archival = archival;
    }

    public double getOptionalComponentPrice() {
        return optionalComponentPrice;
    }

    public void setOptionalComponentPrice(double optionalComponentPrice) {
        this.optionalComponentPrice = optionalComponentPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getTotalLumpPrice() {
        return totalLumpPrice;
    }

    public void setTotalLumpPrice(double totalLumpPrice) {
        this.totalLumpPrice = totalLumpPrice;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }
}
