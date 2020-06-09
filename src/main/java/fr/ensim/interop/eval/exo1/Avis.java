package fr.ensim.interop.eval.exo1;

import com.neovisionaries.i18n.CountryCode;

import java.util.Calendar;
import java.util.Locale;

public class Avis {

    private String refProduit;
    private int note;
    private String commentaires;
    private CountryCode countryCode;
    private String refFournisseur;
    private Calendar date;

    public Avis() {
    }

    public Avis(Calendar date, String refProd, int note, String comm, String refFourn) {
        this.date = Calendar.getInstance();
        this.refProduit = refProd;
        this.note = note;
        this.commentaires = comm;
        this.countryCode = CountryCode.getByLocale(Locale.getDefault());
        this.refFournisseur = refFourn;

    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getRefProduit() {
        return refProduit;
    }


    // 2 : valider les données en entrée

    public void setRefProduit(String refProduit) {
        if (!this.refProduit.matches("[a-zA-Z0-9]+") || this.refProduit.length() > 20)
            throw new IllegalArgumentException(("La référence doit être écrite avec les symbole alphanumérique."));
        this.refProduit = refProduit;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        if (this.note < 0 || this.note > 10)
            throw new IllegalArgumentException("Note non comprise entre 0 et 10.");
        this.note = note;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        if (this.commentaires.length() > 300)
            throw new IllegalArgumentException("Le commentaire dépasse la limite de 300 caractères");
        this.commentaires = commentaires;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    // 2 : valider les données en entrée

    public String getRefFournisseur() {
        if (!this.refFournisseur.matches("[a-zA-Z0-9]+") || this.refFournisseur.length() > 15)
            throw new IllegalArgumentException("la référence est incorrect");
        return refFournisseur;
    }

    public void setRefFournisseur(String refFournisseur) {
        this.refFournisseur = refFournisseur;
    }


}
