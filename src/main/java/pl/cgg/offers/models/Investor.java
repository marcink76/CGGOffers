package pl.cgg.offers.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "inwestor")
public class Investor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inwestor_id")
    private Long id;

    @NotEmpty(message = "Podaj poprawną nazwę inwestora.")
    @Size(min = 2, max = 30, message = "Nazwa musi zawierać min 2 litery")
    @Column(name = "Nazwa")
    private String name;

    @Column(name = "Imie")
    @Size(min = 2, max = 30, message = "Imię musi zawierać min 2 litery")
    @NotNull
    private String firstName;

    @Column(name = "Nazwisko")
    @Size(min = 2, max = 30, message = "Nazwisko musi zawierać min 2 litery")
    @NotNull
    private String lastName;

    @Column (name = "miejsce")
    @Enumerated(value = EnumType.STRING)
    private Place place;

    @Column(name = "Ulica")
    private String street;

    @Column(name = "Nr_posesji")
    private String posesionNumber;

    @Column(name = "Nr_lokalu")
    private String localNumber;

    @Column(name = "Miasto")
    private String city;

    @Column(name = "Typ_inwestora")
    @Enumerated(value = EnumType.STRING)
    private InvestorsCategory category;

    @Column(name = "Kod_pocztowy")
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$", message = "Podaj kod pocztowy w formacie XX-XXX")
    private String zipcode;

    @Column(name = "nip")
    @Size(min = 10, max=10)
    private String nip;
    @Column(name = "email")
    private String email;
    @Column(name = "numertelefonu")
    private String phoneNumber;
    @Column(name = "archiwalny")
    private boolean archive;

    @OneToMany
    private List<Offer> offerList;

    public Investor() {
    }

    public Investor(String name) {
        this.name = name;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPosesionNumber() {
        return posesionNumber;
    }

    public void setPosesionNumber(String posesionNumber) {
        this.posesionNumber = posesionNumber;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public InvestorsCategory getCategory() {
        return category;
    }

    public void setCategory(InvestorsCategory category) {
        this.category = category;
    }
}
