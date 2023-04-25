package com.example.Service;

import com.example.DAO.DAO_Avis;
import com.example.Entities.*;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceAvis {

    public static boolean ajouterAvisSerie (AvisProduit av){
        Serie s= ServiceSerie.afficherSerie(av.getNomProduit());
        if(!contientAvisSerie(av.getUtilisateur(),s))
            return DAO_Avis.insererAvisSerie(av);
        else return false;
    }
    public static  boolean ajouterAvisSaison(AvisSaison av){
        Saison s=ServiceSaison.afficherSaison(av.getNomProduit(),av.getNumSaison());
        if (!contientAvisSaison(av.getUtilisateur(),s))
            return DAO_Avis.insererAvisSaison(av);
        else return false;
    }
    public static  boolean ajouterAvisEpisode(AvisEpisode av){
        Episode ep =ServiceEpisode.afficherEpisode(av.getNomProduit(),av.getNumSaison(), av.getNumSaison());
        if(!contientAvisEpisode(av.getUtilisateur(),ep))
            return DAO_Avis.insererAvisEpisode(av);
        else return  false;
    }
    public static  boolean insererAvisFilm(AvisProduit av){
        Film f= ServiceFilm.afficherFilm(av.getNomProduit());
        if(!contientAvisFilm(av.getUtilisateur(),f))
            return DAO_Avis.insererAvisFilm(av);
        else return false;

    }



    public static boolean contientAvisFilm(Utislisateur u, Film f){//verifier qu'un utilisateur a donne un avis deja ou nn a un film
       List<String> L =DAO_Avis.afiicherTousAvisFilm(f).stream().map(x->x.getUtilisateur().getNomprenom()).toList();
        if(L.contains(u.getNomprenom()))
            return true;
        else
            return false;
    }
    public static boolean contientAvisSerie(Utislisateur u, Serie s){//verifier qu'un utilisateur a donne un avis deja ou nn a une serie
        List<String> L =DAO_Avis.afiicherTousAvisSerie(s).stream().map(x->x.getUtilisateur().getNomprenom()).toList();
        if(L.contains(u.getNomprenom()))
            return true;
        else
            return false;
    }
    public static boolean contientAvisSaison(Utislisateur u, Saison s){//verifier qu'un utilisateur a donne un avis deja ou nn a une saison
        List<String> L =DAO_Avis.afiicherTousAvisSaison(s).stream().map(x->x.getUtilisateur().getNomprenom()).toList();
        if(L.contains(u.getNomprenom()))
            return true;
        else
            return false;
    }
    public static boolean contientAvisEpisode(Utislisateur u, Episode e){//verifier qu'un utilisateur a donne un avis deja ou nn a une episode
        List<String> L =DAO_Avis.afiicherTousAvisEpisode(e).stream().map(x->x.getUtilisateur().getNomprenom()).toList();
        if(L.contains(u.getNomprenom()))
            return true;
        else
            return false;
    }





    public static List<AvisProduit> afiicherTousAvisSerie(Serie s){
        return DAO_Avis.afiicherTousAvisSerie(s);
    }
    public static List<AvisProduit> afiicherAvisSerieDunActeur(Serie s, String nomActeur){

        return DAO_Avis.afiicherTousAvisSerie(s).stream().filter(x->x.getUtilisateur().getNomprenom().equals(nomActeur)).collect(Collectors.toList());
    }
    public static List<AvisProduit> afiicherAvisSerieDunProducteur(Serie s, String nomProductuer){

        return DAO_Avis.afiicherTousAvisSerie(s).stream().filter(x->ServiceSerie.afficherSerie(x.getNomProduit()).getProducteur().equals(nomProductuer)).collect(Collectors.toList());
    }
    public static List<AvisProduit> afiicherTousAvisFilm(Film f){
        return DAO_Avis.afiicherTousAvisFilm(f);
    }
    public static List<AvisProduit> afiicherAvisFilmDunActeur(Film f, String nomActeur){

        return DAO_Avis.afiicherTousAvisFilm(f).stream().filter(x->x.getUtilisateur().getNomprenom().equals(nomActeur)).collect(Collectors.toList());
    }
    public static List<AvisProduit> afiicherAvisFilmDunProducteur(Film f, String nomProductuer){

        return DAO_Avis.afiicherTousAvisFilm(f).stream().filter(x->ServiceSerie.afficherSerie(x.getNomProduit()).getProducteur().equals(nomProductuer)).collect(Collectors.toList());
    }
    public static List<AvisSaison> afiicherTousAvisSaison(Saison s){
        return DAO_Avis.afiicherTousAvisSaison(s);
    }
    public static List<AvisSaison> afiicherAvisSaisonDunActeur(Saison s, String nomActeur){

        return DAO_Avis.afiicherTousAvisSaison(s).stream().filter(x->x.getUtilisateur().getNomprenom().equals(nomActeur)).collect(Collectors.toList());
    }
    public static List<AvisSaison> afiicherAvisFilmDunProducteur(Saison s, String nomProductuer){

        return DAO_Avis.afiicherTousAvisSaison(s).stream().filter(x->ServiceSerie.afficherSerie(x.getNomProduit()).getProducteur().equals(nomProductuer)).collect(Collectors.toList());
    }


    public static List<AvisEpisode> afiicherTousAvisEpisode(Episode e){
        return DAO_Avis.afiicherTousAvisEpisode(e);
    }

    public static List<AvisEpisode> afiicherAvisEpisodeDunActeur(Episode e, String nomActeur){

        return DAO_Avis.afiicherTousAvisEpisode(e).stream().filter(x->x.getUtilisateur().getNomprenom().equals(nomActeur)).collect(Collectors.toList());
    }
    public static List<AvisEpisode> afiicherAvisEpisodeDunProducteur(Episode e, String nomProductuer){

        return DAO_Avis.afiicherTousAvisEpisode(e).stream().filter(x->ServiceSerie.afficherSerie(x.getNomProduit()).getProducteur().equals(nomProductuer)).collect(Collectors.toList());
    }





    public static  boolean modifierAvisSerie(AvisProduit av){
        Serie s= ServiceSerie.afficherSerie(av.getNomProduit());
        if(contientAvisSerie(av.getUtilisateur(),s))
            return DAO_Avis.insererAvisSerie(av);
        else return false;

    }
    public static  boolean modifierAvisFilm(AvisProduit av){
        Film f= ServiceFilm.afficherFilm(av.getNomProduit());
        if(contientAvisFilm(av.getUtilisateur(),f))
            return DAO_Avis.modifyAvisFilm(av);
        else return false;
    }
    public static  boolean modifierAvisSaison(AvisSaison av){
        Saison s=ServiceSaison.afficherSaison(av.getNomProduit(),av.getNumSaison());
        if (contientAvisSaison(av.getUtilisateur(),s))
            return DAO_Avis.modifyAvisSaison(av);
        else return false;
    }
    public static  boolean modifierAvisEpisode(AvisEpisode av){
        Episode ep =ServiceEpisode.afficherEpisode(av.getNomProduit(),av.getNumSaison(), av.getNumSaison());
        if(contientAvisEpisode(av.getUtilisateur(),ep))
            return DAO_Avis.modifyAvisEpisode(av);
        else return  false;
    }




    public static  boolean supprimerAvisFilm(AvisProduit av){
        Film f= ServiceFilm.afficherFilm(av.getNomProduit());
        if(contientAvisFilm(av.getUtilisateur(),f))
            return DAO_Avis.supprimerAvisFilm(av);
        else return false;

    }
    public static  boolean supprimerAvisSerie(AvisProduit av){
        Serie s= ServiceSerie.afficherSerie(av.getNomProduit());
        if(contientAvisSerie(av.getUtilisateur(),s))
            return DAO_Avis.supprimerAvisSerie(av);
        else return false;
    }
    public static  boolean supprimerAvisEpisode(AvisEpisode av){
        Episode ep =ServiceEpisode.afficherEpisode(av.getNomProduit(),av.getNumSaison(), av.getNumSaison());
        if(contientAvisEpisode(av.getUtilisateur(),ep))
            return DAO_Avis.supprimerAvisEpisode(av);
        else return  false;

    }
    public static  boolean supprimerAvisSaison(AvisSaison av){
        Saison s=ServiceSaison.afficherSaison(av.getNomProduit(),av.getNumSaison());
        if (contientAvisSaison(av.getUtilisateur(),s))
            return DAO_Avis.supprimerAvisSaison(av);
        else return false;
    }


}
