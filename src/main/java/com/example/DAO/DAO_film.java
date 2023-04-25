package com.example.DAO;

import com.example.Entities.Film;
import com.example.Entities.Saison;
import com.example.Entities.Serie;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_film {
    private static Connection conn = ConxDB.getInstance();

    public static List<Film> findAll(){//retourner tous les films
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;

        List<Film> filmList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE TYPEPRODUIT='film'";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomFilm= rs.getString(1);
                int anneSortie=rs.getInt(3);
                String langue= rs.getString(4);
                String paysOrigine= rs.getString(5);
                String genre= rs.getString(6);
                int score =rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                int duree=rs.getInt(11);
                Film film = new Film(nomFilm,nomRealisateur,anneSortie,langue,paysOrigine,duree);
                film.setGenre(genre);
                film.setVues(vues);
                film.setCover(cover);
                filmList.add(film);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }
    public static List<Film> findByAnnee(int annee) {//retourner tous les films apres cette date
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Film> filmList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE ANNESORTIE >= ? AND TYPEPRODUIT='film'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, annee);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomFilm= rs.getString(1);
                int anneSortie=rs.getInt(3);
                String langue= rs.getString(4);
                String paysOrigine= rs.getString(5);
                String genre= rs.getString(6);
                int score =rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                int duree=rs.getInt(11);
                Film film = new Film(nomFilm,nomRealisateur,anneSortie,langue,paysOrigine,duree);
                film.setGenre(genre);
                film.setVues(vues);
                filmList.add(film);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }
    public static List<Film> findByProducteur(String producteur) {//retourner tous les films apres cette date
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Film> filmList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE REALISATEUR= ? AND TYPEPRODUIT='film'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, producteur);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomFilm= rs.getString(1);
                int anneSortie=rs.getInt(3);
                String langue= rs.getString(4);
                String paysOrigine= rs.getString(5);
                String genre= rs.getString(6);
                int score =rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                int duree=rs.getInt(11);
                Film film = new Film(nomFilm,nomRealisateur,anneSortie,langue,paysOrigine,duree);
                film.setGenre(genre);
                film.setVues(vues);
                filmList.add(film);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }
    public static List<Film> findByLangue(String Langue) {//retourner tous les films apres cette date
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Film> filmList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE LANGUE = ? AND TYPEPRODUIT='film'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Langue);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomFilm= rs.getString(1);
                int anneSortie=rs.getInt(3);
                String langue= rs.getString(4);
                String paysOrigine= rs.getString(5);
                String genre= rs.getString(6);
                int score =rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                int duree=rs.getInt(11);
                Film film = new Film(nomFilm,nomRealisateur,anneSortie,langue,paysOrigine,duree);
                film.setGenre(genre);
                film.setVues(vues);
                filmList.add(film);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }
    public static List<Film> findByPays(String Pays) {//retourner tous les films apres cette date
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Film> filmList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE PAYSORIGINE = ? AND TYPEPRODUIT='film'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Pays );
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomFilm= rs.getString(1);
                int anneSortie=rs.getInt(3);
                String langue= rs.getString(4);
                String paysOrigine= rs.getString(5);
                String genre= rs.getString(6);
                int score =rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                int duree=rs.getInt(11);
                Film film = new Film(nomFilm,nomRealisateur,anneSortie,langue,paysOrigine,duree);
                film.setGenre(genre);
                film.setVues(vues);
                filmList.add(film);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }
    public static List<Film> findByGenre(String Genre) {//retourner tous les films apres cette date
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Film> filmList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE GENRE = ? AND TYPEPRODUIT='film'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Genre );
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomFilm= rs.getString(1);
                int anneSortie=rs.getInt(3);
                String langue= rs.getString(4);
                String paysOrigine= rs.getString(5);
                String genre= rs.getString(6);
                int score =rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                int duree=rs.getInt(11);
                Film film = new Film(nomFilm,nomRealisateur,anneSortie,langue,paysOrigine,duree);
                film.setGenre(genre);
                film.setVues(vues);
                filmList.add(film);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }




    public static  boolean AjouterVu(String nomFilm , String producteur) {//Ajouter une vu a une episode donnée
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE NETFLIX.PRODUIT SET VUES=VUES+1  WHERE TITRE =? AND TYPEPRODUIT='film' AND REALISATEUR=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, nomFilm);
            pstmt.setString(2,producteur);


            pstmt.executeUpdate();

            // 4- Recupérer l'Id généré par le SGBD
            rs = pstmt.getGeneratedKeys();
            if (rs.next())
                return true;
            else return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static  boolean AjouterCover(String nomFilm,String producteur,String url) {//Ajouter un Cover a un film donné
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE NETFLIX.PRODUIT SET COVER=?  WHERE TITRE =? AND TYPEPRODUIT='film' AND REALISATEUR=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, url);
            pstmt.setString(2, nomFilm);
            pstmt.setString(3,producteur);


            pstmt.executeUpdate();

            // 4- Recupérer l'Id généré par le SGBD
            rs = pstmt.getGeneratedKeys();
            if (rs.next())
                return true;
            else return false;


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static boolean insererFilm(Film f) {//inserer un Film à partir d'un objet Film
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.PRODUIT(TITRE,REALISATEUR,ANNESORTIE,LANGUE,PAYSORIGINE,GENRE,TYPEPRODUIT,SCORE,VUES,DUREEFILM) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, f.getTitre());
            pstmt.setString(2, f.getProducteur());
            pstmt.setInt(3, f.getDateSortie());
            pstmt.setString(4, f.getLangue());
            pstmt.setString(5, f.getPaysOrigine());
            pstmt.setString(6, f.getGenre());
            pstmt.setString(7, "film");
            pstmt.setInt(8,0);
            pstmt.setInt(9,0);
            pstmt.setInt(10,f.getDuree());
            pstmt.executeUpdate();

            // 4- Recupérer l'Id généré par le SGBD
            rs = pstmt.getGeneratedKeys();
            if (rs.next())
                return true;
            else return false;


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static boolean ajouterScore(Film f, int score){
        System.out.println("Cnx is "+conn);

        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {

            String SQL = "UPDATE NETFLIX.PRODUIT SET SCORE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='film'";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            if(f.getScoreMoy()!=0)
                pstmt.setInt(1, (f.getScoreMoy()+score)/2);
            else
                pstmt.setInt(1, score);


            pstmt.setString(2, f.getTitre());
            pstmt.setString(3, (f.getProducteur()));

            rs= pstmt.executeQuery();



            return rs.next() ;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }



    public static boolean modify(Film f,int numChangement){
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            if(numChangement==3) {//Annee sortie
                String SQL = "UPDATE NETFLIX.PRODUIT SET ANNESORTIE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='film'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, f.getDateSortie());
            }
            if(numChangement==4) {//Langue
                String SQL = "UPDATE NETFLIX.PRODUIT SET LANGUE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='film'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, f.getLangue());
            }
            else  if(numChangement==5) {//pays origine
                String SQL = "UPDATE NETFLIX.PRODUIT SET PAYSORIGINE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='film'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, f.getPaysOrigine());
            }
            else  if(numChangement==6) {// genre
                String SQL = "UPDATE NETFLIX.PRODUIT SET GENRE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='film'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, f.getGenre());
            }
            else  if(numChangement==11) {// duree
                String SQL = "UPDATE NETFLIX.PRODUIT SET DUREEFILM=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='film'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, f.getDuree());
            }
            pstmt.setString(2, f.getTitre());
            pstmt.setString(3, f.getProducteur());
            rs= pstmt.executeQuery();
            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public static boolean deleteFilm(Film f){
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "DELETE FROM NETFLIX.PRODUIT WHERE TITRE =?  AND REALISATEUR=? AND TYPEPRODUIT =?" ;
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, f.getTitre());
            pstmt.setString(2, f.getProducteur());
            pstmt.setString(3,"film");
            rs= pstmt.executeQuery();
            if (rs.next()) {
                return true ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}