package com.example.Entities;

import java.util.List;

public class Producteur extends Personne {
    public List<String> products;

    public Producteur(String nomprenom, Compte compte) {
        super(nomprenom, compte);
        this.nomprenom = nomprenom;
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Producteur{" +
                "nomprenom='" + nomprenom + '\'' +
                ", compte=" + compte +
                '}';
    }
}
