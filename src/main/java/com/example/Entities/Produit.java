package com.example.Entities;

import java.util.List;
import java.util.Objects;

public class Produit {
    protected  String titre;
    protected String producteur;
    protected int dateSortie;
    protected String langue;
    protected String paysOrigine;
    protected List<Integer> scores;
    protected List<String> avis;
    protected String cover ;
    protected String genre;
    protected int scoreMoy;

    public Produit(String titre, String producteur, int dateSortie, String langue, String paysOrigine,String cover) {
        this.titre = titre;
        this.producteur = producteur;
        this.dateSortie = dateSortie;
        this.langue = langue;
        this.paysOrigine = paysOrigine;
        this.cover=cover;

    }
    public Produit(String titre, String producteur, int dateSortie, String langue, String paysOrigine) {
        this.titre = titre;
        this.producteur = producteur;
        this.dateSortie = dateSortie;
        this.langue = langue;
        this.paysOrigine = paysOrigine;


    }

    public Produit() {

    }

    public List<Integer> getScores() {
        return scores;
    }

    public int getScoreMoy() {
        return scoreMoy;
    }

    public void setScoreMoy(int scoreMoy) {
        this.scoreMoy = scoreMoy;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "titre='" + titre + '\'' +
                ", producteur='" + producteur + '\'' +
                ", dateSortie=" + dateSortie +
                ", langue='" + langue + '\'' +
                ", paysOrigine='" + paysOrigine + '\'' +
                ", cover='" + cover + '\'' +
                ", genre='" + genre + '\'' +
                ", scoreMoy=" + scoreMoy +
                '}';
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getProducteur() {
        return this.producteur;
    }

    public void setProducteur(String producteur) {
        this.producteur = producteur;
    }

    public int getDateSortie() {
        return this.dateSortie;
    }

    public void setDateSortie(int dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getLangue() {
        return this.langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getPaysOrigine() {
        return this.paysOrigine;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getCover() {
        return cover ;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }


}