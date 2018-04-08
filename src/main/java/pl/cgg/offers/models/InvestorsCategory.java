package pl.cgg.offers.models;

public enum InvestorsCategory {
    INDIVIDUAL("Inwestor indywidualny"),
    CORPORATE("Inwestor korporacyjny");

    private String description;

    InvestorsCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
