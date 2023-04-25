package com.example.Entities;

import java.time.LocalDate;
import java.util.Objects;

public class Notification {
    private int id;
    private Utislisateur utislisateur;
    private  String message ;
    private LocalDate date_de_mise ;


    public Notification(Utislisateur utislisateur, String message) {
        this.utislisateur = utislisateur;
        this.message = message;
    }

    public Notification(int id, Utislisateur u, String message, LocalDate date_de_mise ) {
        this.id = id;
        this.utislisateur = u;
        this.message = message;
        this.date_de_mise = date_de_mise ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utislisateur getUtislisateur() {
        return utislisateur;
    }

    public void setUtislisateur(Utislisateur utislisateur) {
        this.utislisateur = utislisateur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate_de_mise() {
        return date_de_mise;
    }

    public void setDate_de_mise(LocalDate date_de_mise) {
        this.date_de_mise = date_de_mise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id == that.id && Objects.equals(utislisateur, that.utislisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, utislisateur);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", utislisateur=" + utislisateur +
                ", message='" + message + '\'' +
                ", date_de_mise=" + date_de_mise +
                '}';
    }
}
