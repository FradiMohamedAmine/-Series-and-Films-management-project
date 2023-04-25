package com.example.Service;

import com.example.DAO.DAO_utilisateur;
import com.example.Entities.Utislisateur;

import java.util.ArrayList;
import java.util.List;

import static com.example.DAO.DAO_utilisateur.findAll;
import static com.example.DAO.DAO_utilisateur.insererUtilisateur;

public class ServiceUtilisateur {

    public static boolean ajouterUtilisateur(Utislisateur u) {
        if (!contientUtilisatuer(u)) {
            insererUtilisateur(u);
            return true;
        }
        return false;
    }
    public void ajouterPreferncesdunUtilisateur(Utislisateur utislisateur) {
        ServiceFavoris serviceFavoris = new ServiceFavoris();

        utislisateur.setFilmsFavoris(serviceFavoris.afficherFilmFavorisDunUtilisateur(utislisateur.getNomprenom()));
        utislisateur.setSeriesFavoris(serviceFavoris.afficherSerieFavorisDunUtilisateur(utislisateur.getNomprenom()));
        utislisateur.setActeursFavoris(serviceFavoris.afficherActeursFavorisDunUtilisateur(utislisateur.getNomprenom()));
        utislisateur.setGenresFavoris(serviceFavoris.afficherGenreFavorisDunUtilisateur(utislisateur.getNomprenom()));

    }


    public static boolean contientUtilisatuer(Utislisateur u) {//verifier l'existance d un utilisateur
        return findAll().contains(u);
    }



    public  List<Utislisateur> afficherTous() {
        List<Utislisateur> utislisateurList =DAO_utilisateur.findAll() ;
        List<Utislisateur> utislisateurList1 = new ArrayList<>();
        for (Utislisateur u : utislisateurList){
            ajouterPreferncesdunUtilisateur(u);
            utislisateurList1.add(u);
        }
        return utislisateurList1;
    }

    public  Utislisateur afficherUtilisateur(String nomPrenom) {
        List<Utislisateur> utislisateursList = afficherTous();
        for (Utislisateur u : utislisateursList) {
            if (u.getNomprenom() == nomPrenom)
                return u;
        }
        System.out.println("Un utilisatuer qui n'exicte pas");
        return null;
    }



    public static boolean supprimerUtilisateur(Utislisateur u) {
        if (contientUtilisatuer(u))
            return !DAO_utilisateur.supprimerUtilisateur(u);
        else
            return false;
    }





}
