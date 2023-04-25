package com.example.Entities;

import java.util.Objects;

public class Personne {
    public String nomprenom;
    public Compte compte;

    public Personne(String nomprenom, Compte compte) {
        this.nomprenom = nomprenom;
        this.compte = compte;
    }

    public String getNomprenom() {
        return nomprenom;
    }

    public void setNomprenom(String nomprenom) {
        this.nomprenom = nomprenom;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne personne)) return false;
        return getNomprenom().equals(personne.getNomprenom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomprenom());
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nomprenom='" + nomprenom + '\'' +
                ", compte=" + compte.toString() +
                '}';
    }
}
