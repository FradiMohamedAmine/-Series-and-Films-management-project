package com.example.Entities;

public class Film extends Produit{
    private int duree;
    private int vues;
    public Film(String titre, String realisateur, int dateSortie, String langue, String paysOrigine, int duree,String cover) {
        super(titre, realisateur, dateSortie, langue, paysOrigine,cover);
        this.duree = duree;
    }
    public Film(String titre, String realisateur, int dateSortie, String langue, String paysOrigine, int duree) {
        super(titre, realisateur, dateSortie, langue, paysOrigine);
        this.duree = duree;
    }
    public Film(){
        super();
    }
    public Film(String titre){
        super();
        this.titre=titre;
    }



    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getVues() {
        return vues;
    }

    public void setVues(int vues) {
        this.vues = vues;
    }
}