package com.example.Service;

import com.example.DAO.DAO_Serie;
import com.example.Entities.Serie;

import java.util.List;

public class ServiceSerie {
    public static boolean ajouterScore(Serie s,int score){
        if(contientSerie(s))
            return DAO_Serie.ajouterScore(s,score);
        else return false;
    }
    public static boolean ajouterSerie(Serie s){
        if(!contientSerie(s))
            return DAO_Serie.insererSerie(s);
        else return false;
    }




    public static boolean contientSerie(Serie s){//verifier l'existance du serie
        return DAO_Serie.findAll().stream().filter(x->(x.getTitre().equals(s.getTitre())&&x.getProducteur().equals(s.getProducteur()))).anyMatch(x->true);
    }




    public static List<Serie> afficherTous (){
        return DAO_Serie.findAll();
    }
    public static Serie afficherSerie(String titre){
     for (Serie serie : DAO_Serie.findAll())
     {
         if (serie.getTitre().equals(titre))
             return serie;
     }
        return null;
    }
    public static List<Serie> chercherParAnnee(int annee){
        return DAO_Serie.findByAnnee(annee);
    }
    public static List<Serie> chercherParProducteur(String producteur){
        return DAO_Serie.findByProducteur(producteur);
    }
    public static List<Serie> chercherParLangue(String Langue){
        return DAO_Serie.findByLangue(Langue);
    }
    public static List<Serie> chercherparPays(String Pays){
        return DAO_Serie.findByPays(Pays);
    }
    public static List<Serie> chercherparGenre(String Genre){
        return DAO_Serie.findByGenre(Genre);
    }





    public static boolean modifierAnnee(Serie s,int nouvAnnee){
        if(contientSerie(s)) {
            s.setDateSortie(nouvAnnee);
            return DAO_Serie.modify(s, 3);
        }
        else return false;

    }
    public static boolean modifierLangue(Serie s,String nouvLangue){
        if(contientSerie(s)) {
            s.setLangue(nouvLangue);
            return DAO_Serie.modify(s, 4);
        }
        else return false;

    }
    public static boolean modifierPays(Serie s,String Pays){
        if(contientSerie(s)) {
            s.setPaysOrigine(Pays);
            return DAO_Serie.modify(s, 5);
        }
        else return false;

    }
    public static boolean modifierGenre(Serie s,String genre){
        if(contientSerie(s)) {
            s.setGenre(genre);
            return DAO_Serie.modify(s, 6);
        }
        else return false;
    }





    public static boolean supprimerSerie(Serie s){
        if(contientSerie(s))
            return DAO_Serie.deleteSerie(s);
        else return false;
    }


}
