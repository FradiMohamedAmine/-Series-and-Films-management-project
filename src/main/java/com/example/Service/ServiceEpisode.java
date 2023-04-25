package com.example.Service;

import com.example.DAO.DAO_Episode;
import com.example.Entities.Episode;
import com.example.Entities.Saison;
import com.example.Entities.Serie;
import com.example.Entities.Utislisateur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.DAO.DAO_Episode.*;

public class ServiceEpisode {


    public static boolean ajouterEpisode(Episode e) {
        if (!contientEpisode(e)) {
            insererEpisode(e);
            return true;
        }
        return false;
    }
    public static void ajouterVu(Episode e) {
        if (contientEpisode(e))
            DAO_Episode.AjouterVu(e.getNomSerie(), e.getNumeroSaison(), e.getNumeroEpisode());
        else System.out.println("Episode non trouvalble");
    }
    public static boolean ajouterScore(Episode e,int score){
        if(contientEpisode(e))
            return DAO_Episode.ajouterScore(e,score);
        else return false;
    }




    public static boolean contientEpisode(Episode e) {//verifier l'existance du episode
       return DAO_Episode.findAll().stream().filter(x->(e.getNomSerie().equals(x.getNomSerie()) && e.getNumeroSaison() == x.getNumeroSaison() && e.getNumeroEpisode() == x.getNumeroEpisode())).anyMatch(x->true);
    }





    public static  List<Episode> afficherTous(String titreSerie, int numSaison) {
        return findBySaison(titreSerie, numSaison);

    }
    public static Episode afficherEpisode(String titreSerie, int numSaison, int numEp) {
        List<Episode> episodeList = findBySaison(titreSerie, numSaison);
        for (Episode e : episodeList) {
            if (e.getNumeroEpisode() == numEp)
                return e;
        }
        System.out.println("Un mumero d'epidode qui n'exicte pas");
        return null;
    }
    public static List<Episode> afficherComingSoonEpisodePrefere(Utislisateur u) {
        ServiceFavoris serviceFavoris = new ServiceFavoris();
        List<Serie> serieList =serviceFavoris.afficherSerieFavorisDunUtilisateur(u.getNomprenom());
        List<Episode> episodeList = new ArrayList<>();
        for (Serie s : serieList){
            for(Saison saison : s.getSaisons()) {
                episodeList = findBySaison(s.getTitre(), saison.getNumeroSaison());
            }
        }
        List<Episode> episodeList1 = new ArrayList<>() ;
        episodeList1 = episodeList.stream().filter(x->x.getDateDiff().isAfter(LocalDate.now())).collect(Collectors.toList());
        return episodeList1 ;
    }




        public static boolean modifierResumeEpisode(Episode e, String nouveauResume) {
        if (contientEpisode(e) ) {
            e.setResume(nouveauResume);

            return modify(e, 3);
        } else
            return false;
    }







    public static boolean supprimerEpisode(Episode e) {
        if (!contientEpisode(e))
            return deleteEpisode(e.getNomSerie(), e.getNumeroSaison(), e.getNumeroEpisode());
        else
            return false;
    }


}
