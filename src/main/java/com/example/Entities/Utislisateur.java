package com.example.Entities;

import java.util.List;

public class Utislisateur extends Personne{
    private List<Film> filmsFavoris;
    private  List<Serie> seriesFavoris;
    private  List<Acteur> acteursFavoris ;
    private List<Genre> genresFavoris ;
    public Utislisateur(String nomprenom, Compte compte) {
        super(nomprenom, compte);
        this.nomprenom = nomprenom;
        this.compte = compte;
    }

    public List<Film> getFilmsFavoris() {
        return filmsFavoris;
    }

    public void setFilmsFavoris(List<Film> filmsFavoris) {
        this.filmsFavoris = filmsFavoris;
    }

    public List<Serie> getSeriesFavoris() {
        return seriesFavoris;
    }

    public void setSeriesFavoris(List<Serie> seriesFavoris) {
        this.seriesFavoris = seriesFavoris;
    }

    public List<Acteur> getActeursFavoris() {
        return acteursFavoris;
    }

    public void setActeursFavoris(List<Acteur> acteursFavoris) {
        this.acteursFavoris = acteursFavoris;
    }

    public List<Genre> getGenresFavoris() {
        return genresFavoris;
    }

    public void setGenresFavoris(List<Genre> genresFavoris) {
        this.genresFavoris = genresFavoris;
    }

    @Override
    public String toString() {
        return "Utislisateur{" +
                "nomprenom='" + nomprenom + '\'' +
                ", compte=" + compte +
                '}';
    }
}

