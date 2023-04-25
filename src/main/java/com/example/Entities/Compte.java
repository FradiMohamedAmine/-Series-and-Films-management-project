package com.example.Entities;

import java.util.Objects;

public  class Compte {
    private String mail;
    private String mdp;
    private String type;

    public Compte(String mail, String mdp, String type) {
        this.mail = mail;
        this.mdp = mdp;
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compte compte)) return false;
        return getMail().equals(compte.getMail()) && getMdp().equals(compte.getMdp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMail(), getMdp());
    }

    @Override
    public String toString() {
        return "Compte{" +
                "mail='" + mail + '\'' +
                ", mdp='" + mdp + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
