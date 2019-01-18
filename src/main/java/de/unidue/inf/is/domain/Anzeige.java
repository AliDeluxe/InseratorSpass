package de.unidue.inf.is.domain;

import java.util.Set;

public final class Anzeige {

    private String titel;
    private double preis;
    private String beschreibung;
    private Set<String> kategorien;


    public Anzeige() {
    }


    public Anzeige(String titel, double preis, String beschreibung, Set<String> kategorien ) {

        this.titel = titel;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.kategorien = kategorien;



    }

    public String getTitel() {
        return titel;
    }

    public double getPreis() {
        return preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Set<String> getKategorien() {
        return kategorien;
    }
}