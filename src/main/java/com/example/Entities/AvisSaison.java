package com.example.Entities;

import java.util.Objects;

public class AvisSaison {
    private Utislisateur utilisateur;
    private String nomProduit;
    private String avis;
    private int numSaison;

    public AvisSaison(Utislisateur utilisateur, String nomProduit, String avis, int numSaison) {
        this.utilisateur = utilisateur;
        this.nomProduit = nomProduit;
        this.avis = avis;
        this.numSaison = numSaison;
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

    @Override
    public String toString() {
        return "AvisSaison{" +
                "utilisateur=" + utilisateur +
                ", nomProduit='" + nomProduit + '\'' +
                ", avis='" + avis + '\'' +
                ", numSaison=" + numSaison +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvisSaison that)) return false;
        return getNumSaison() == that.getNumSaison() && getUtilisateur().getNomprenom().equals(that.getUtilisateur().getNomprenom())  && Objects.equals(getNomProduit(), that.getNomProduit()) && Objects.equals(getAvis(), that.getAvis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUtilisateur().getNomprenom(), getNomProduit(), getAvis(), getNumSaison());
    }
}
