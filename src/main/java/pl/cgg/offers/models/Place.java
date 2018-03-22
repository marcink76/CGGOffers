package pl.cgg.offers.models;

public enum Place {
    STREET("ul."),
    PLACE("pl."),
    AVENUE("Al."),
    SETTLEMENT("os.");

    private String place;

    Place(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }
}
