package com.example.Entities;
import java.util.List;
import java.time.LocalDate;
import java.util.Objects;

public class Saison {

   private  int numeroSaison;
   private  String resume;
   private int nbrEpisodes;
   private String nomSerie;
    public List<Episode> episodes;
   private LocalDate dateSortie;
    private int scoreMoy;
    public List<String> avis;



    public Saison(String nomSerie,int numeroSaison,String resume, LocalDate dateSortie) {
        this.numeroSaison = numeroSaison;
        this.resume = resume;

        this.nomSerie = nomSerie;
        this.dateSortie = dateSortie;
    }

    public Saison(int numeroSaison, String nomSerie) {
        this.numeroSaison = numeroSaison;
        this.nomSerie = nomSerie;
    }

    public Saison() {
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getNbrEpisodes() {
        return nbrEpisodes;
    }

    public void setNbrEpisodes(int nbrEpisodes) {
        this.nbrEpisodes = nbrEpisodes;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public int getScoreMoy() {
        return scoreMoy;
    }

    public void setScoreMoy(int scoreMoy) {
        this.scoreMoy = scoreMoy;
    }

    public List<String> getAvis() {
        return avis;
    }

    public void setAvis(List<String> avis) {
        this.avis = avis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Saison saison)) return false;
        return getNumeroSaison() == saison.getNumeroSaison() && getNbrEpisodes() == saison.getNbrEpisodes();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroSaison(), getNbrEpisodes());
    }

    @Override
    public String toString() {
        return "Saison{" +
                "numeroSaison=" + numeroSaison +
                ", resume='" + resume + '\'' +
                ", nomSerie='" + nomSerie + '\'' +
                ", dateSortie=" + dateSortie +
                '}';
    }
}
