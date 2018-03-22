package pl.cgg.offers.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "etapy")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etapu")
    private Long id;

    @Column(name = "opis_etapu")
    private String description;

    @Column(name = "czas_trwania")
    private int durationTime;

    @ManyToMany()
    //@JoinColumn(name = "id_etapu", referencedColumnName = "id_oferty")
    private List<Offer> offers;

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
}
