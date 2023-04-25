package com.example.DAO;

import com.example.Entities.Saison;
import com.example.Entities.Serie;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Serie {
    private static Connection conn = ConxDB.getInstance();

    public static List<Serie> findAll() {//retourner tous les series
        System.out.println("Cnx is " + conn);
        Statement stmt = null;
        ResultSet rs = null;

        List<Serie> serieList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE TYPEPRODUIT='serie'";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomSerie = rs.getString(1);
                int anneSortie = rs.getInt(3);
                String langue = rs.getString(4);
                String paysOrigine = rs.getString(5);
                String genre = rs.getString(6);
                int score = rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                Serie serie = new Serie(nomSerie, nomRealisateur, anneSortie, langue, paysOrigine);
                serie.setGenre(genre);
                serie.setScoreMoy(score);
                List<Saison> ls = DAO_Saison.findBySerie(serie.getTitre());
                serie.setSaisons(ls);
                serieList.add(serie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serieList;
    }
    public static List<Serie> findByAnnee(int annee) {//retourner tous les saisons d'une serie
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Serie> serieList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE ANNESORTIE >= ? AND TYPEPRODUIT='serie'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, annee);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomSerie = rs.getString(1);
                int anneSortie = rs.getInt(3);
                String langue = rs.getString(4);
                String paysOrigine = rs.getString(5);
                String genre = rs.getString(6);
                int score = rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                Serie serie = new Serie(nomSerie, nomRealisateur, anneSortie, langue, paysOrigine);
                serie.setGenre(genre);
                serie.setScoreMoy(score);
                serie.setCover(rs.getString(10));
                List<Saison> ls = DAO_Saison.findBySerie(serie.getTitre());
                serie.setSaisons(ls);
                serieList.add(serie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serieList;
    }
    public static List<Serie> findByProducteur(String producteur) {//retourner tous les saisons d'une serie
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Serie> serieList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE REALISATEUR = ? AND TYPEPRODUIT='serie'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, producteur);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomSerie = rs.getString(1);
                int anneSortie = rs.getInt(3);
                String langue = rs.getString(4);
                String paysOrigine = rs.getString(5);
                String genre = rs.getString(6);
                int score = rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                Serie serie = new Serie(nomSerie, nomRealisateur, anneSortie, langue, paysOrigine);
                serie.setGenre(genre);
                serie.setScoreMoy(score);
                serie.setCover(rs.getString(10));
                List<Saison> ls = DAO_Saison.findBySerie(serie.getTitre());
                serie.setSaisons(ls);
                serieList.add(serie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serieList;
    }
    public static List<Serie> findByLangue(String Langue) {//retourner tous les saisons d'une serie
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Serie> serieList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE LANGUE = ? AND TYPEPRODUIT='serie'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Langue);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomSerie = rs.getString(1);
                int anneSortie = rs.getInt(3);
                String langue = rs.getString(4);
                String paysOrigine = rs.getString(5);
                String genre = rs.getString(6);
                int score = rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                Serie serie = new Serie(nomSerie, nomRealisateur, anneSortie, langue, paysOrigine);
                serie.setGenre(genre);
                serie.setScoreMoy(score);
                serie.setCover(rs.getString(10));
                List<Saison> ls = DAO_Saison.findBySerie(serie.getTitre());
                serie.setSaisons(ls);
                serieList.add(serie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serieList;
    }
    public static List<Serie> findByPays(String Pays) {//retourner tous les saisons d'une serie
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Serie> serieList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE PAYSORIGINE = ? AND TYPEPRODUIT='serie'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Pays);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomSerie = rs.getString(1);
                int anneSortie = rs.getInt(3);
                String langue = rs.getString(4);
                String paysOrigine = rs.getString(5);
                String genre = rs.getString(6);
                int score = rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                Serie serie = new Serie(nomSerie, nomRealisateur, anneSortie, langue, paysOrigine);
                serie.setGenre(genre);
                serie.setScoreMoy(score);
                serie.setCover(rs.getString(10));
                List<Saison> ls = DAO_Saison.findBySerie(serie.getTitre());
                serie.setSaisons(ls);
                serieList.add(serie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serieList;
    }
    public static List<Serie> findByGenre(String Genre) {//retourner tous les saisons d'une serie
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Serie> serieList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PRODUIT WHERE GENRE = ? AND TYPEPRODUIT='serie'";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Genre);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nomRealisateur = rs.getString(2);
                String nomSerie = rs.getString(1);
                int anneSortie = rs.getInt(3);
                String langue = rs.getString(4);
                String paysOrigine = rs.getString(5);
                String genre = rs.getString(6);
                int score = rs.getInt(7);
                String cover = rs.getString(9);
                int vues = rs.getInt(10);
                Serie serie = new Serie(nomSerie, nomRealisateur, anneSortie, langue, paysOrigine);
                serie.setGenre(genre);
                serie.setScoreMoy(score);
                serie.setCover(rs.getString(10));
                serie.setSaisons(DAO_Saison.findBySerie(serie.getTitre()));
                List<Saison> ls = DAO_Saison.findBySerie(serie.getTitre());
                serie.setSaisons(ls);
                serieList.add(serie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serieList;
    }



    public static boolean insererSerie(Serie s) {//inserer une Serie à partir d'un objet serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.PRODUIT(TITRE,REALISATEUR,ANNESORTIE,LANGUE,PAYSORIGINE,GENRE,TYPEPRODUIT) VALUES (?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, s.getTitre());
            pstmt.setString(2, s.getProducteur());
            pstmt.setInt(3, s.getDateSortie());
            pstmt.setString(4, s.getLangue());
            pstmt.setString(5, s.getPaysOrigine());
            pstmt.setString(6, s.getGenre());
            pstmt.setString(7, "serie");
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next())
                return true;
            else return false;


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean AjouterCover(String nomSerie,String producteur, String url) {//Ajouter un cover a une serie donnée
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE NETFLIX.PRODUIT SET COVER=?  WHERE TITRE =? AND TYPEPRODUIT='serie' AND REALISATEUR=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, url);
            pstmt.setString(2, nomSerie);
            pstmt.setString(3,producteur);


            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next())
                return true;
            else return false;


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static boolean ajouterScore(Serie s, int score){
        System.out.println("Cnx is "+conn);

        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {

            String SQL = "UPDATE NETFLIX.PRODUIT SET SCORE=? WHERE TITRE =? AND REALISATEUR=? TYPEPRODUIT ='serie'";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            if(s.getScoreMoy()!=0)
                pstmt.setInt(1, (s.getScoreMoy()+score)/2);
            else
                pstmt.setInt(1, score);


            pstmt.setString(2, s.getTitre());
            pstmt.setString(3, (s.getProducteur()));

            rs= pstmt.executeQuery();



            return rs.next() ;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }




    public static boolean modify(Serie s,int numChangement){
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            if(numChangement==3) {//Annee sortie
                String SQL = "UPDATE NETFLIX.PRODUIT SET ANNESORTIE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='serie'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, s.getDateSortie());
            }
            if(numChangement==4) {//Langue
                String SQL = "UPDATE NETFLIX.PRODUIT SET LANGUE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='serie'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, s.getLangue());
            }
            else  if(numChangement==5) {//pays origine
                String SQL = "UPDATE NETFLIX.PRODUIT SET PAYSORIGINE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='serie'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, s.getPaysOrigine());
            }
            else  if(numChangement==6) {// genre
                String SQL = "UPDATE NETFLIX.PRODUIT SET GENRE=? WHERE TITRE =? AND REALISATEUR=? AND TYPEPRODUIT ='serie'";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, s.getGenre());
            }

            pstmt.setString(2, s.getTitre());
            pstmt.setString(3, (s.getProducteur()));
            rs= pstmt.executeQuery();
            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }





    public static boolean deleteSerie(Serie s){
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "DELETE FROM NETFLIX.PRODUIT WHERE TITRE =?  AND REALISATEUR=? AND TYPEPRODUIT =?" ;
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getTitre());
            pstmt.setString(2, s.getProducteur());
            pstmt.setString(3,"serie");
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



