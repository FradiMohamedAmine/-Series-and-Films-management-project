package com.example.Service;

import com.example.DAO.DAO_favoris;
import com.example.Entities.*;

import java.util.List;
import java.util.Map;

import static com.example.DAO.DAO_favoris.*;

public class ServiceFavoris {

    public  boolean ajouterFilmFavorisDunUtilisateur(Film f , String nomUtilisateur){
        if(contientProduitFavorisParutilisateur(f,nomUtilisateur))
            return insererProduitFavorisDunUtilisateur(f.getTitre(),nomUtilisateur);
        else
            System.out.println("Deja existe");
        return false ;
    }

    public  boolean ajouterSerieFavorisDunUtilisateur(Serie s , String nomUtilisateur){
        if(contientProduitFavorisParutilisateur(s,nomUtilisateur))
            return insererProduitFavorisDunUtilisateur(s.getTitre(),nomUtilisateur);
        return false ;
    }
    public  boolean ajouterActeurFavorisDunUtilisateur(Acteur a , String nomUtilisateur){
        if(contientActeurFavorisParutilisateur(a,nomUtilisateur))
            return insererProduitFavorisDunUtilisateur(a.getNomprenom(),nomUtilisateur);
        return false ;
    }    public  boolean ajouterGenreFavorisDunUtilisateur(Genre g , String nomUtilisateur){
        if(contientGenreFavorisParutilisateur(g,nomUtilisateur))
            return insererGenreFavorisDunUtilisateur(g.toString(),nomUtilisateur);
        return false ;
    }







    public boolean contientProduitFavorisParutilisateur(Produit p ,  String nomUtilisateur){
        return ((List<Produit>) DAO_favoris.findProduitFavoriePersonne(nomUtilisateur)).stream().filter(x->(x.getTitre().equals(p.getTitre()))).anyMatch(y->true);
    }
    public boolean contientActeurFavorisParutilisateur(Acteur a ,  String nomUtilisateur){
        return  DAO_favoris.findActeurFavoriePersonne(nomUtilisateur).stream().filter(x->(x.getNomprenom().equals(a.getNomprenom()))).anyMatch(y->true);
    }
    public boolean contientGenreFavorisParutilisateur(Genre g ,  String nomUtilisateur){
        return DAO_favoris.findGenreFavoriePersonne(nomUtilisateur).stream().filter(x->(x.equals(g))).anyMatch(y->true);
    }




   /* public Map<> afficherTousProduitsFavorisAvecUtilisateur(){
        return DAO_favoris.;
    }*/
    public List<? super Produit> afficherProduitsFavorisDunUtilisateur(String nomUtilisateur){
        return DAO_favoris.findProduitFavoriePersonne(nomUtilisateur);
    }
    public List<Film> afficherFilmFavorisDunUtilisateur(String nomUtilisateur){
        return DAO_favoris.findFilmsFavoriePersonne(nomUtilisateur);
    }
    public List<Serie> afficherSerieFavorisDunUtilisateur(String nomUtilisateur){
        return DAO_favoris.findSeriesFavoriePersonne(nomUtilisateur);
    }

    public List<Acteur> afficherActeursFavorisDunUtilisateur(String nomUtilisateur){
        return DAO_favoris.findActeurFavoriePersonne(nomUtilisateur);
    }
    public List<Genre> afficherGenreFavorisDunUtilisateur(String nomUtilisateur){
        return DAO_favoris.findGenreFavoriePersonne(nomUtilisateur);
    }







    public  boolean supprimerFilmFavorisDunUtilisateur(Film f , String nomUtilisateur){
        if(contientProduitFavorisParutilisateur(f,nomUtilisateur))
            return supprimerProduitFavorisDunUtilisateur(f.getTitre(),nomUtilisateur);
        return false ;
    }
    public  boolean supprimerSerieFavorisDunUtilisateur(Serie s , String nomUtilisateur){
        if(contientProduitFavorisParutilisateur(s,nomUtilisateur))
            return supprimerProduitFavorisDunUtilisateur(s.getTitre(),nomUtilisateur);
        return false;
    }

    public  boolean supprimerActeurFavorisDunUtilisateur(Acteur a , String nomUtilisateur){
        if(contientActeurFavorisParutilisateur(a,nomUtilisateur))
            return DAO_favoris.supprimerActeurFavorisDunUtilisateur(a.getNomprenom(),nomUtilisateur);
        return false;
    }
    public  boolean supprimerGenreFavorisDunUtilisateur(Genre g , String nomUtilisateur){
        if(contientGenreFavorisParutilisateur(g,nomUtilisateur))
            return DAO_favoris.supprimerGenreFavorisDunUtilisateur(g.toString(),nomUtilisateur);
        return false;
    }


}
