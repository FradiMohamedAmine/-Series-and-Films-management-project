package com.example.Service;

import com.example.DAO.DAO_Episode;
import com.example.DAO.DAO_Saison;
import com.example.Entities.Episode;
import com.example.Entities.Saison;

import java.time.LocalDate;
import java.util.List;

import static com.example.DAO.DAO_Episode.findBySaison;
import static com.example.DAO.DAO_Episode.insererEpisode;
import static com.example.DAO.DAO_Episode.modify;
import static com.example.DAO.DAO_Saison.*;

public class ServiceSaison {
    public static boolean ajouterScore(Saison s,int score){
        if(contientSaison(s))
            return DAO_Saison.ajouterScore(s,score);
        else return false;
    }
    public static boolean ajouterSaison(Saison s) {
        if (!contientSaison(s)) {

            return insererSaison(s) ;
        }
        return false;
    }



    public  static boolean contientSaison(Saison s) {
        return DAO_Saison.findAll().stream().filter(x->(x.getNumeroSaison()==s.getNumeroSaison()&&x.getNomSerie().equals(s.getNomSerie()))).anyMatch(x->true);
    }



    public static List<Saison> afficherTousaprtirDate(LocalDate DS){
        return DAO_Saison.findByDateSortie(DS);
    }
    public static List<Saison> afficherTousaprtirNomSerie(String titreSerie) {
        return findBySerie(titreSerie);
    }
    public static Saison afficherSaison(String titreSerie, int numSaison) {
        List<Saison> episodeList = findBySerie(titreSerie);
        for (Saison s : episodeList) {
            if (s.getNumeroSaison() == numSaison)
                return s;
        }
        System.out.println("Un mumero d'epidode qui n'exicte pas");
        return null;
    }


    public static boolean modifierResumeEpisode(Saison s, String nouveauResume) {
        if (contientSaison(s) ) {
            s.setResume(nouveauResume);

            return DAO_Saison.modify(s, 3);
        } else
            return false;
    }



    public static boolean supprimerSaison(Saison s){
        if (contientSaison(s)) {
            DAO_Episode.findBySaison(s.getNomSerie(), s.getNumeroSaison()).forEach(x -> ServiceEpisode.supprimerEpisode(x));
            return DAO_Saison.deleteSaison(s);
        }
        else return false;

    }



}
