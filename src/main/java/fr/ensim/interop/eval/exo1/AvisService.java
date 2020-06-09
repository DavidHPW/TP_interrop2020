package fr.ensim.interop.eval.exo1;

import com.neovisionaries.i18n.CountryCode;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

@WebService
public class AvisService {

    // TODO Exercice 1 - Implémentation d’un Web Service SOAP d’avis consommateur

    ArrayList<Avis> ListAvis = new ArrayList<Avis>();

    /*
    Enregistrer un avis sur un produit
    */
    @WebMethod
    public int enregistrerAvis(@WebParam(name = "date") Calendar date,
                               @WebParam(name = "refProduit") String refProduit,
                               @WebParam(name = "note") int note,
                               @WebParam(name = "commentaires") String commentaires,
                               @WebParam(name = "refFournisseur") String refFournisseur) {

        //1 : Journaliser l'appel
        System.out.println("enregistrerAvis : " + date + ", " + refProduit + ", " + note + ", " + commentaires + ", " + refFournisseur);


        //1 : Simulation de l'enregistrement d'avis
        Avis avis = new Avis(date, refProduit, note, commentaires, refFournisseur);

        avis.setDate(Calendar.getInstance());
        avis.setCountryCode(CountryCode.getByLocale(Locale.getDefault()));

        ListAvis.add(avis);

        //4 : Fournir le nombre d'avis
        int nbAvis = 0;
        for (int i = 0; i < ListAvis.size(); i++) {
            if (ListAvis.get(i).getRefFournisseur().equals(refFournisseur)) {
                nbAvis++;
            }
        }

        return nbAvis;
    }

    /*
    Lister les avis sur un produit
     */
    @WebMethod
    public ArrayList<Avis> listerAvis(@WebParam(name = "refProduit") String refProduit) {
        if (!refProduit.matches("[a-zA-Z0-9]+") || refProduit.length() > 20)
            throw new IllegalArgumentException(("La référence doit être écrite avec les symbole alphanumérique."));

        ArrayList<Avis> listResultAvis = new ArrayList<Avis>();

        for (int i = ListAvis.size() - 1; i >= 0; i--) {
            if (ListAvis.get(i).getRefProduit().equals(refProduit)) {
                listResultAvis.add(ListAvis.get(i));
            }
        }

        return listResultAvis;

    }
}