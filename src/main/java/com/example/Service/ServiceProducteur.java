package com.example.Service;

import com.example.DAO.DAO_producteur;
import com.example.DAO.DAO_utilisateur;
import com.example.Entities.Producteur;
import com.example.Entities.Utislisateur;

import java.util.List;

import static com.example.DAO.DAO_utilisateur.findAll;
import static com.example.DAO.DAO_utilisateur.insererUtilisateur;

public class ServiceProducteur {
    public static boolean ajouterProducteur(Producteur p) {
        if (!contientProducteur(p)) {
            DAO_producteur.insererProducteur(p);
            return true;
        }
        return false;
    }


    public static boolean contientProducteur(Producteur p) {//verifier l'existance du producteur
        return DAO_producteur.findAll().contains(p);
    }




    public static List<Producteur> afficherTous() {
        return DAO_producteur.findAll();
    }
    public static Producteur afficherUnProducteur(String nomPrenom) {

        List<Producteur> producteursList = afficherTous();
        for (Producteur p: producteursList) {
            if (p.getNomprenom().equals(nomPrenom))
                return p;
        }
        System.out.println("Un Producteurr qui n'exicte pas");
        return null;
    }



    public static boolean supprimerProducteur(Producteur p) {
        if (contientProducteur(p)) {
            DAO_producteur.supprimerProducteur(p);
            return true;
        }
        else
            return false;
    }


}
