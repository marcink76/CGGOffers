package pl.cgg.offers.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;


public enum Category {
    ROBOTY_ZIEMNE,
    BADANIA_LABORATORYJNE,
    PRACE_TERENOWE;

    Category() {
    }
}
