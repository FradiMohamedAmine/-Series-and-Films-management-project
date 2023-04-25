package com.example.Service;

import com.example.DAO.DAO_acteur;
import com.example.Entities.Acteur;
import com.example.Entities.Produit;

import java.util.List;

import static com.example.DAO.DAO_acteur.insererActeur;

public class ServiceActeur {

    public static boolean ajouterActeur(Acteur a) {
        if (!contientActeur(a)) {
            insererActeur(a);
            return true;
        }
        return false;
    }
    public static boolean ajouterParticipationActeur(Acteur a,Produit p,String role) {
        if (!contientPartacipation(a, p)) {
            DAO_acteur.insererParticipation(a,p,role);
            return true;
        }
        return false;
    }



        public static boolean contientActeur(Acteur a) {//verifier l'existance du episode
        return DAO_acteur.findAll().contains(a);
    }

    public static boolean contientPartacipation(Acteur a, Produit p) {
        return (DAO_acteur.findParticipation(a.getNomprenom(),p.getTitre()));
    }





    public static List<Acteur> afficherTous() {
        return DAO_acteur.findAll();

    }

    public static Acteur afficheActeur(String nomPrenom) {
        List<Acteur> acteursList = afficherTous();
        for (Acteur a : acteursList) {
            if (a.getNomprenom() == nomPrenom)
                return a;
        }
        System.out.println("Un acteur qui n'exicte pas");
        return null;
    }




    public boolean modifierParticipation(Acteur a,Produit p,String nouveaaurole) {
        if (!contientPartacipation(a, p)) {
            DAO_acteur.modifierParticipation(a.getNomprenom(), p.getTitre(), nouveaaurole);
            return true;
        }
        return false;
    }






    public  static boolean supprimerActeur(Acteur a) {
        if (contientActeur(a))
        {
            DAO_acteur.supprimerActeur(a);
            return true;
        }
        else
            return false;
        //Suppression
    }
    public  boolean supprimerParticipation(Acteur a,Produit p) {
        if (contientPartacipation(a,p))
        {
            DAO_acteur.supprimerParticipation(a.getNomprenom(),p.getTitre());
            return true;
        }
        else
            return false;
    }
}
