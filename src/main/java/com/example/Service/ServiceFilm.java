package com.example.Service;

import com.example.DAO.DAO_film;
import com.example.Entities.Film;

import java.util.List;

public class ServiceFilm {

    public static  boolean ajouterVu(Film f){
        if(contientFilm(f))
            return DAO_film.AjouterVu(f.getTitre(),f.getProducteur());
        else return false;
    }
    public static  boolean ajouterCover(Film f,String url){
        if(contientFilm(f))
            return DAO_film.AjouterCover(f.getTitre(),f.getProducteur(),url);
        else return false;
    }
    public static boolean ajouterFilm(Film f){
        if(!contientFilm(f))
            return DAO_film.insererFilm(f);
        else return false;
    }
    public static boolean ajouterScore(Film f, int score){
        if(contientFilm(f))
        {  boolean test=DAO_film.ajouterScore(f,score);
            int sc;
            if(f.getScoreMoy()==0)
                f.setScoreMoy(score);
            else {sc=(f.getScoreMoy()+score)/2;
                f.setScoreMoy(sc);
            }
            return test;
        }
        else return false;
    }





    public static boolean contientFilm(Film f){
        return DAO_film.findAll().stream().filter(x->(x.getTitre().equals(f.getTitre()) && x.getProducteur().equals(f.getProducteur()))).anyMatch(x->true);
    }




    public static List<Film> afficherToutsFilm(){
        return DAO_film.findAll();
    }
    public static Film afficherFilm(String titre){
        for (Film f : DAO_film.findAll())
        {
            if (f.getTitre().equals(titre))
                return f;
        }
        return null;
    }




    public static boolean modifierAnne(Film f,int nvAnnee) {
        if (contientFilm(f)) {
            f.setDateSortie(nvAnnee);
            return DAO_film.modify(f, 3);
        } else return false;
    }
    public static boolean modifierLangue(Film f,String lang) {
        if (contientFilm(f)) {
            f.setLangue(lang);
            return DAO_film.modify(f, 4);
        } else return false;
    }
    public static boolean modifierPays(Film f,String pays) {
        if (contientFilm(f)) {
            f.setPaysOrigine(pays);
            return DAO_film.modify(f, 5);
        } else return false;
    }
    public static boolean modifierGenre(Film f,String genre) {
        if (contientFilm(f)) {
            f.setGenre(genre);
            return DAO_film.modify(f, 6);
        } else return false;
    }




    public static boolean supprimerFilm(Film f){
        if(contientFilm(f))
            return DAO_film.deleteFilm(f);
        else return false;
    }

}
