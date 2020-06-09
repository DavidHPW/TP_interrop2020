package fr.ensim.interop.eval.exo2.model;

import java.util.Calendar;

public class Plantation {
    private int id;
    private Calendar date;
    private String parcelle;
    private String namePlant;
    private String familyPlant;

    public Plantation(int andIncrement, Calendar date, String parcelle, String namePlant, String familyPlant) {
    }

    public int getId() {
        return id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getParcelle() {
        return parcelle;
    }

    public void setParcelle(String parcelle) {
        this.parcelle = parcelle;
    }

    public String getNamePlant() {
        return namePlant;
    }

    public void setNamePlant(String namePlant) {
        this.namePlant = namePlant;
    }

    public String getFamilyPlant() {
        return familyPlant;
    }

    public void setFamilyPlant(String familyPlant) {
        this.familyPlant = familyPlant;
    }
}
