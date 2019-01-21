package de.unidue.inf.is.domain;

import java.util.Date;
import java.util.Set;

public final class Anzeige {

    private String titel;
    private double preis;
    private String beschreibung;
    private String[] kategorien;
    private Date erstellungsDatum;
    private String user;


    public Anzeige() {
    }


    public Anzeige(String titel, double preis, String beschreibung, String[] kategorien, Date datum, String user) {
        this.titel = titel;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.kategorien = kategorien;
        this.erstellungsDatum = datum;
        this.user = user;

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

    public String[] getKategorien() {
        return kategorien;
    }
    public Date getErstellungsDatum() {
        return erstellungsDatum;
    }

    public String getUser() {
        return user;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setKategorien(String[] kategorien) {
        this.kategorien = kategorien;
    }

    public void setErstellungsDatum(Date erstellungsDatum) {
        this.erstellungsDatum = erstellungsDatum;
    }

    public void setUser(String user) {
        this.user = user;
    }
}