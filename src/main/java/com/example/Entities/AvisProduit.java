package com.example.Entities;

public class AvisProduit {

    private Utislisateur utilisateur;
    private String nomProduit;
    private String avis;

    public AvisProduit(Utislisateur utilisateur,String nomProduit, String avis) {
        this.utilisateur = utilisateur;
        this.nomProduit=nomProduit;
        this.avis = avis;
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
}
