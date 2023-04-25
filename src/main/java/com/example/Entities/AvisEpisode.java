package com.example.Entities;

import java.util.Objects;

public class AvisEpisode {
    private Utislisateur utilisateur;
    private String nomProduit;
    private String avis;
    private int numSaison;
    private int numEpisode;

    public AvisEpisode(Utislisateur utilisateur, String nomProduit, String avis, int numSaison, int numEpisode) {
        this.utilisateur = utilisateur;
        this.nomProduit = nomProduit;
        this.avis = avis;
        this.numSaison = numSaison;
        this.numEpisode = numEpisode;
    }

    public Utislisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utislisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public int getNumSaison() {
        return numSaison;
    }

    public void setNumSaison(int numSaison) {
        this.numSaison = numSaison;
    }

    public int getNumEpisode() {
        return numEpisode;
    }

    public void setNumEpisode(int numEpisode) {
        this.numEpisode = numEpisode;
    }

    @Override
    public String toString() {
        return "AvisEpisode{" +
                "utilisateur=" + utilisateur +
                ", nomProduit='" + nomProduit + '\'' +
                ", avis='" + avis + '\'' +
                ", numSaison=" + numSaison +
                ", numEpisode=" + numEpisode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvisEpisode that)) return false;
        return getNumSaison() == that.getNumSaison() && getNumEpisode() == that.getNumEpisode() && Objects.equals(getUtilisateur().getNomprenom(), that.getUtilisateur().getNomprenom()) && Objects.equals(getNomProduit(), that.getNomProduit()) && Objects.equals(getAvis(), that.getAvis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUtilisateur(), getNomProduit(), getAvis(), getNumSaison(), getNumEpisode());
    }
}
