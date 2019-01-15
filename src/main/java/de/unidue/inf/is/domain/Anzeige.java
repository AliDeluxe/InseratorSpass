package de.unidue.inf.is.domain;

import java.util.Date;

public final class Anzeige {

    private boolean isActive;

    private String title;
    private String beschreibung;
    private double price;
    //TODO enum kategorie

    public Anzeige() {

    }

    public Anzeige(boolean isActive, String title,String beschreibung, double price) {

        this.isActive = isActive;
        this.title = title;
        this.price = price;
        this.beschreibung = beschreibung;
    }


    public boolean isActive() {
        return isActive;
    }

    public String getTitle() {
        return title;
    }

    public double getPreis() {
        return price;
    }
}
