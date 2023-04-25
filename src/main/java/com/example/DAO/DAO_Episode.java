package com.example.DAO;

import com.example.Entities.Episode;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Episode {
    private static Connection conn = ConxDB.getInstance();
    public static List<Episode> findAll(){//retourner tous les episodes de tous les series
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;

        List<Episode> episodeList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.EPISODES";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int numeroSaison = rs.getInt(2);
                String nomSerie= rs.getString(1);
                int numeroEpisode = rs.getInt(3);
                String resume = rs.getString(4);
                Episode episode = new Episode(nomSerie,numeroSaison,numeroEpisode,resume);
                episode.setScoreMoy(rs.getInt(5));
                episode.setVues(rs.getInt(6));
                episode.setDateDiff(rs.getDate(7).toLocalDate());
                episodeList.add(episode);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return episodeList;
    }

        public static List<Episode> findBySaison(String titreSerie,int numSaison){//retourner tous les episodes d'un saison du serie
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        List<Episode> episodeList = new ArrayList<>();
        try {
        String SQL = "SELECT * FROM NETFLIX.EPISODES WHERE TITRESERIE =? AND NUMEROSAISON =?";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, titreSerie);
            pstmt.setInt(2, (numSaison));
           rs= pstmt.executeQuery();


            while (rs.next()) {
                int numeroSaison = rs.getInt(2);
                String nomSerie= rs.getString(1);
                int numeroEpisode = rs.getInt(3);
                String resume = rs.getString(4);
                Episode episode = new Episode(nomSerie,numeroSaison,numeroEpisode,resume);
                episode.setScoreMoy(rs.getInt(5));
                episode.setVues(rs.getInt(6));
                episode.setDateDiff(rs.getDate(7).toLocalDate());

                episodeList.add(episode);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return episodeList;
    }





    public static  boolean insererEpisode(Episode e) {//inserer une episode à partir d'un objet episode
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.EPISODES(TITRESERIE,NUMEROSAISON,NUMEROEPISODE,RESUME,VUES,SCORE,DATEDIFF) VALUES (?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, e.getNomSerie());
            pstmt.setInt(2, e.getNumeroSaison());
            pstmt.setInt(3, e.getNumeroEpisode());
            pstmt.setString(4, e.getResume());
            pstmt.setInt(5, 0);
            pstmt.setInt(6,0);
            pstmt.setDate(7, Date.valueOf(e.getDateDiff()));
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
    public static  boolean AjouterVu(String nomSerie,int numSerie,int numEpisode) {//Ajouter une vu a une episode donnée
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE NETFLIX.EPISODES SET VUES=VUES+1  WHERE TITRESERIE =? AND NUMEROSAISON =? AND NUMEROEPISODE =? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, nomSerie);
            pstmt.setInt(2, numSerie);
            pstmt.setInt(3, numEpisode);

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
    public static boolean ajouterScore(Episode e,int score){
        System.out.println("Cnx is "+conn);

        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {

            String SQL = "UPDATE NETFLIX.EPISODES SET SCORE=? WHERE TITRESERIE =? AND NUMEROSAISON =? AND NUMEROEPISODE =? ";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            if(e.getScoreMoy()!=0)
                pstmt.setInt(1, (e.getScoreMoy()+score)/2);
            else
                pstmt.setInt(1, score);


            pstmt.setString(2, e.getNomSerie());
            pstmt.setInt(3, (e.getNumeroSaison()));
            pstmt.setInt(4, (e.getNumeroEpisode()));
            rs= pstmt.executeQuery();



            return rs.next() ;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }



    public static boolean modify(Episode e,int numChangement){

        System.out.println("Cnx is "+conn);

        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            if(numChangement==3) {
                String SQL = "UPDATE NETFLIX.EPISODES SET RESUME=? WHERE TITRESERIE =? AND NUMEROSAISON =? AND NUMEROEPISODE =? ";
                pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

                pstmt.setString(1, e.getResume());

            }
            pstmt.setString(2, e.getNomSerie());
            pstmt.setInt(3, (e.getNumeroSaison()));
            pstmt.setInt(4, (e.getNumeroEpisode()));
            rs= pstmt.executeQuery();



                return rs.next() ;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }






    public static boolean deleteEpisode(String titreSerie,int numSaison,int numEpisode){
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "DELETE FROM NETFLIX.EPISODES WHERE TITRESERIE =? AND NUMEROSAISON =? AND NUMEROEPISODE =? " ;
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, titreSerie);
            pstmt.setString(2, Integer.toString(numSaison));
            pstmt.setString(3, Integer.toString(numEpisode));

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
