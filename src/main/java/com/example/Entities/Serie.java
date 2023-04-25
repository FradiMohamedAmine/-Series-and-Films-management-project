package com.example.Entities;

import java.util.List;

public class Serie extends Produit{
    private List<Saison>saisons;
    private int nbrSaison;


    public Serie(String titre, String realisateur, int dateSortie, String langue, String paysOrigine,String cover) {
        super(titre, realisateur, dateSortie, langue, paysOrigine,cover);
    }
    public Serie(String titre, String realisateur, int dateSortie, String langue, String paysOrigine) {
        super(titre, realisateur, dateSortie, langue, paysOrigine);
    }
    public Serie(){
        super();
    };
    public Serie(String titre){
        super();
        this.titre=titre;
    };

    public int getNbrSaison() {
        return nbrSaison;
    }

    public void setNbrSaison(int nbrSaison) {
        this.nbrSaison = nbrSaison;
    }

    public List<Saison> getSaisons() {
        return saisons;
    }

    public void setSaisons(List<Saison> saisons) {
        this.saisons = saisons;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "titre='" + titre + '\'' +
                ", producteur='" + producteur + '\'' +
                ", dateSortie=" + dateSortie +
                ", langue='" + langue + '\'' +
                ", paysOrigine='" + paysOrigine + '\'' +
                ", genre='" + genre + '\'' +
                ", scoreMoy=" + scoreMoy +
                '}';
    }
}
