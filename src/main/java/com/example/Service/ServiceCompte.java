package com.example.Service;

import com.example.DAO.DAO_Compte;
import com.example.Entities.*;

import java.sql.SQLException;
import java.util.List;

public class ServiceCompte {

   public static boolean ajouterCompte(Personne p) throws SQLException {
       if(!contientCompte(p.getCompte())) {
           switch (p.getCompte().getType()) {
               case "utilisateur": {
                   Utislisateur u = new Utislisateur(p.getNomprenom(), p.getCompte());
                   return ServiceUtilisateur.ajouterUtilisateur(u);
               }
               case "acteur": {
                   Acteur a = new Acteur(p.getNomprenom(), p.getCompte());
                   return ServiceActeur.ajouterActeur(a);
               }
               case "producteur": {
                   Producteur pr = new Producteur(p.getNomprenom(), p.getCompte());
                   return ServiceProducteur.ajouterProducteur(pr);
               }
           }
       }
       return false;
   }



    public static boolean contientCompte(Compte e) throws SQLException {//verifier l'existance d'un compte
        return ((List<Personne>)DAO_Compte.getAll()).stream().filter(x->x.getCompte().equals(e)).anyMatch(x->true);
    }







    public static Personne afficherUnCompte(String m, String md) throws SQLException {
        return DAO_Compte.get(m,md);
    }
    public static List<?super Personne> afficherToutesComptes() throws SQLException{
        return DAO_Compte.getAll();
    }







    public static boolean modifierNomComplet(Compte c , String nouveauNom) throws SQLException {
        if (contientCompte(c)) {
            return DAO_Compte.modifyUserName(c.getMail(), c.getMdp(),nouveauNom);
        }
        return false ;
    }
    public static boolean modifierMotDePasse(Compte c , String nouveauMdp) throws SQLException {
        if (contientCompte(c)) {
            return DAO_Compte.modifyPassword(c.getMail(), c.getMdp(),nouveauMdp);
        }
        return false ;
    }








    public static boolean supprimerCompte(Personne p) throws SQLException {
        if(contientCompte(p.getCompte())) {
            switch (p.getCompte().getType()) {
                case "utilisateur" -> {
                    Utislisateur u = new Utislisateur(p.getNomprenom(), p.getCompte());
                    return ServiceUtilisateur.supprimerUtilisateur(u);
                }
                case "acteur" -> {
                    Acteur a = new Acteur(p.getNomprenom(), p.getCompte());
                    return ServiceActeur.supprimerActeur(a);
                }
                case "producteur" -> {
                    Producteur pr = new Producteur(p.getNomprenom(), p.getCompte());
                    return ServiceProducteur.supprimerProducteur(pr);
                }
            }
        }
        return false;
    }
}
