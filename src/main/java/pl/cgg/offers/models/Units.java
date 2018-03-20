package pl.cgg.offers.models;

public enum Units {
    SQUARE("m2", false),
    KILOMETER("km", true),
    METER("m", true),
    LINEAR_METER("mb", true),
    PIECE("szt.", true),
    PLN_METER("zł/m", true),
    PLN("zł", true),
    PLN_PIECE("zł/szt.", true),
    SPECIMEN("egz.", true),
    POINT("pkt", true);

    //km   m   mb  szt   zl/m   zl   zl/szt   egzempl.    zł/pkt.

    private boolean active;
    private String unit;

    Units(String unit, boolean active) {
        this.unit = unit;
        this.active = active;
    }

    public String getUnits() {
        return unit;
    }
    public boolean isActive(){
        return active;
    }
}
