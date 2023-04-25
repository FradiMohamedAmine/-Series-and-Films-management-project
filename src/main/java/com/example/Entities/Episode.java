package com.example.Entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Episode {
    private String nomSerie;
    private int numeroSaison;
    private int numeroEpisode;
    private String resume;
    private LocalDate dateDiff ;
    private int vues;
    private int scoreMoy;


    public Episode(String nomSerie, int numeroSaison, int numeroEpisode, String resume, LocalDate dateDiff, int vues, int scoreMoy) {
        this.nomSerie = nomSerie;
        this.numeroSaison = numeroSaison;
        this.numeroEpisode = numeroEpisode;
        this.resume = resume;
        this.dateDiff = dateDiff;
        this.vues = vues;
        this.scoreMoy = scoreMoy;
    }

    public Episode(String nomSerie, int numeroSaison, int numeroEpisode) {
        this.nomSerie = nomSerie;
        this.numeroSaison = numeroSaison;
        this.numeroEpisode = numeroEpisode;
    }

    public Episode(String nomSerie, int numeroSaison, int numeroEpisode, String resume) {
        this.nomSerie = nomSerie;
        this.numeroSaison = numeroSaison;
        this.numeroEpisode = numeroEpisode;
        this.resume = resume;
    }

    public String getNomSerie() {
        return nomSerie;
    }

    public void setNomSerie(String nomSerie) {
        this.nomSerie = nomSerie;
    }

    public int getNumeroSaison() {
        return numeroSaison;
    }

    public void setNumeroSaison(int numeroSaison) {
        this.numeroSaison = numeroSaison;
    }

    public int getNumeroEpisode() {
        return numeroEpisode;
    }

    public void setNumeroEpisode(int numeroEpisode) {
        this.numeroEpisode = numeroEpisode;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getVues() {
        return vues;
    }

    public void setVues(int vues) {
        this.vues = vues;
    }





    public LocalDate getDateDiff() {
        return dateDiff;
    }

    public void setDateDiff(LocalDate dateDiff) {
        this.dateDiff = dateDiff;
    }



    public int getScoreMoy() {
        return scoreMoy;
    }

    public void setScoreMoy(int scoreMoy) {
        this.scoreMoy = scoreMoy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Episode episode)) return false;
        return (this.numeroEpisode == episode.getNumeroEpisode()  && this.getNumeroSaison()==episode.getNumeroSaison() && this.getNomSerie().equals(episode.getNomSerie()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroEpisode);
    }

    @Override
    public String toString() {
        return "Episode{" +
                "nomSerie='" + nomSerie + '\'' +
                ", numeroSaison=" + numeroSaison +
                ", numeroEpisode=" + numeroEpisode +
                ", resume='" + resume + '\'' +
                ", dateDiff=" + dateDiff +
                ", vues=" + vues +
                ", scoreMoy=" + scoreMoy +

                '}';
    }
}
