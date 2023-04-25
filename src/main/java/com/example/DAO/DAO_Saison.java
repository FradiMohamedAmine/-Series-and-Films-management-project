package com.example.DAO;

import com.example.Entities.Episode;
import com.example.Entities.Saison;
import com.example.utils.ConxDB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAO_Saison {
    private static Connection conn = ConxDB.getInstance();
    public static List<Saison> findAll(){//retourner tous les saisons de tous les series
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;

        List<Saison> saisonsList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.SAISONS";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int numeroSaison = rs.getInt(2);
                String nomSerie= rs.getString(1);
                String resume = rs.getString(4);
                LocalDate dateSortie =rs.getDate(3).toLocalDate();
                Saison saison = new Saison(nomSerie,numeroSaison,resume,dateSortie);
                saison.setScoreMoy(rs.getInt(5));
                saison.setEpisodes(DAO_Episode.findBySaison(nomSerie,numeroSaison));
                saisonsList.add(saison);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return saisonsList;
    }
    public static List<Saison> findBySerie(String titrSerie){//retourner tous les saisons d'une serie
        System.out.println("Cnx is "+conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Saison> saisonsList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.SAISONS WHERE TITRESERIE = ?";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, titrSerie);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int numeroSaison = rs.getInt(2);
                String nomSerie= rs.getString(1);
                String resume = rs.getString(4);
                LocalDate dateSortie =rs.getDate(3).toLocalDate();
                Saison saison = new Saison(nomSerie,numeroSaison,resume,dateSortie);
                saison.setEpisodes(DAO_Episode.findBySaison(nomSerie,numeroSaison));
                saisonsList.add(saison);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return saisonsList;
    }
    public static List<Saison> findByDateSortie(LocalDate DS){//retourner tous les saisons qui vont etre sortie apres une date donne en parametre
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int yy=   (DS.getYear());
        int mm=DS.getMonth().getValue();
        int dd=  (DS.getDayOfMonth());
        List<Saison> saisonsList = new ArrayList<>();
        String SQL = "SELECT * FROM NETFLIX.SAISONS WHERE DATESORTIE>=?";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setDate(1, Date.valueOf(LocalDate.of(yy,mm,dd)));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int numeroSaison = rs.getInt(2);
                String nomSerie= rs.getString(1);
                String resume = rs.getString(4);
                LocalDate dateSortie =rs.getDate(3).toLocalDate();
                Saison saison = new Saison(nomSerie,numeroSaison,resume,dateSortie);
                saison.setEpisodes(DAO_Episode.findBySaison(nomSerie,numeroSaison));
                saisonsList.add(saison);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return saisonsList;
    }



    public static  boolean insererSaison(Saison s) {//inserer une saison à partir d'un objet saison
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.SAISONS(TITRESERIE,NUMEROSAISON,DATESORTIE,RESUME,SCORE) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, s.getNomSerie());
            pstmt.setInt(2, s.getNumeroSaison());
            pstmt.setDate(3, Date.valueOf(s.getDateSortie()));
            pstmt.setString(4, s.getResume());
            pstmt.setInt(5,0);

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
    public static boolean ajouterScore(Saison s,int score){
        System.out.println("Cnx is "+conn);

        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {

            String SQL = "UPDATE NETFLIX.SAISONS SET SCORE=? WHERE TITRESERIE =? AND NUMEROSAISON =? ";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            int sc =s.getScoreMoy();
            if(sc==0)
                pstmt.setInt(1, sc);
            else
                pstmt.setInt(1, (score+sc)/2);


            pstmt.setString(2, s.getNomSerie());
            pstmt.setInt(3, (s.getNumeroSaison()));

            rs= pstmt.executeQuery();



            return rs.next() ;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }






    public static boolean modify(Saison s,int numChangement){
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            if(numChangement==3) {
                String SQL = "UPDATE NETFLIX.SAISONS SET RESUME=? WHERE TITRESERIE =? AND NUMEROSAISON =?";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, s.getResume());

            }
            pstmt.setString(2, s.getNomSerie());
            pstmt.setInt(3, (s.getNumeroSaison()));

            rs= pstmt.executeQuery();



            return rs.next() ;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }





    public static boolean deleteSaison (Saison s){
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "DELETE FROM NETFLIX.SAISONS WHERE TITRESERIE =? AND NUMEROSAISON =?" ;
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getNomSerie());
            pstmt.setString(2, Integer.toString(s.getNumeroSaison()));
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
