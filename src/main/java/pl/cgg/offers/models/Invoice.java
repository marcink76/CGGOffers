package pl.cgg.offers.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "faktury")
public class Invoice {

    @Id
    @Column(name = "id_faktury")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_utworzenia")
    private LocalDate creatingDate;

    @Column(name = "data_duplikatu")
    private LocalDate duplicateDate;

    @OneToOne
    private Offer offer;

    public Invoice(Long id, LocalDate creatingDate, Offer offer) {
        this.id = id;
        this.creatingDate = creatingDate;
        this.offer = offer;
    }

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(LocalDate creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public LocalDate getDuplicateDate() {
        return duplicateDate;
    }

    public void setDuplicateDate(LocalDate duplicateDate) {
        this.duplicateDate = duplicateDate;
    }
}
