package com.example.Entities;

import java.util.Map;

public class Acteur extends Personne{

    private Map<String,String> participation;

    public Acteur(String nomprenom, Compte compte) {
        super(nomprenom, compte);
        this.nomprenom = nomprenom;
        this.compte = compte;
    }

    public Map<String,String> getParticipation() {
        return participation;
    }

    public void setParticipation(Map<String,String> participation) {
        this.participation = participation;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "nomprenom='" + nomprenom + '\'' +
                ", compte=" + compte +
                '}';
    }
}
