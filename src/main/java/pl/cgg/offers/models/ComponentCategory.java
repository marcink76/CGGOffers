package pl.cgg.offers.models;

public enum ComponentCategory {
    FIELD_TESTS("Badania terenowe"),
    SUPERVISIONS("Nadzory"),
    DEVELOPMENT("Opacowania"),
    LABORATORY_TESTS("Badania laboratoryjne");

    private String description;

    ComponentCategory(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
