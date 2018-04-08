package pl.cgg.offers.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "etapy")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etapu")
    private Long id;

    @Column(name = "opis_etapu")
    //@Size(min = 2, max = 50, message = "Nazwa etapu musi mieć od 2 do 50 liter")
    private String description;

    @Column(name = "czas_trwania")
    //@Min(1)
    //@Max(100)
    private int durationTime;

    @ManyToOne()
    private Offer offer;

    public Stage(String description, int durationTime) {
        this.description = description;
        this.durationTime = durationTime;
    }

    public Stage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
