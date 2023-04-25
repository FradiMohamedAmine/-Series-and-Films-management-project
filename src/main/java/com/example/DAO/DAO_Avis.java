package com.example.DAO;

import com.example.Entities.*;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Avis {
    private static Connection conn = ConxDB.getInstance();

    public static  boolean insererAvisSerie(AvisProduit av) {//inserer un avis d'un utilisateur a une serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.AVISPRODUIT(NOMUTILISATEUR,NOMPRODUIT,AVIS,TYPE) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, av.getUtilisateur().getNomprenom());
            pstmt.setString(2, av.getNomProduit());
            pstmt.setString(3, av.getAvis());
            pstmt.setString(4, "serie");
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
                return true;


        } catch (SQLException ex) {
            return false;
        }

    }
    public static  boolean insererAvisFilm(AvisProduit av) {//inserer un avis d'un utilisateur a une serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.AVISPRODUIT(NOMUTILISATEUR,NOMPRODUIT,AVIS,TYPE) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, av.getUtilisateur().getNomprenom());
            pstmt.setString(2, av.getNomProduit());
            pstmt.setString(3, av.getAvis());
            pstmt.setString(4, "film");
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;


        } catch (SQLException ex) {
            return false;
        }
    }
    public static  boolean insererAvisSaison(AvisSaison av) {//inserer un avis d'un utilisateur a une saison
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.AVISSAISON(NOMUTILISATEUR,NOMPRODUIT,AVIS,NUMEROSAISON) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, av.getUtilisateur().getNomprenom());
            pstmt.setString(2, av.getNomProduit());
            pstmt.setString(3, av.getAvis());
            pstmt.setInt(4, av.getNumSaison());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public static  boolean insererAvisEpisode(AvisEpisode av) {//inserer un avis d'un utilisateur a une episode
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.AVISEPISODE(NOMUTILISATEUR,NOMPRODUIT,AVIS,NUMEROSAISON,NUMEROEPISODE) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, av.getUtilisateur().getNomprenom());
            pstmt.setString(2, av.getNomProduit());
            pstmt.setString(3, av.getAvis());
            pstmt.setInt(4,av.getNumSaison());
            pstmt.setInt(5,av.getNumEpisode());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }











    public static List<AvisProduit> afiicherTousAvisSerie(Serie s) {//aaficher tous les avis d'une serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AvisProduit> liste = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NETFLIX.AVISPRODUIT WHERE NOMPRODUIT=? AND TYPE=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getTitre());
            pstmt.setString(2, "serie");
            rs = pstmt.executeQuery();
            // 4- Recupérer l'Id généré par le SGBD

            while (rs.next()) {
                String avis = rs.getString(3);
                String utilisateur = rs.getString(1);
                Utislisateur u=DAO_utilisateur.findAll().stream().filter(x->x.getNomprenom().equals(utilisateur)).toList().get(0);
                liste.add(new AvisProduit(u,s.getTitre(),avis));
            }
            return liste;
        } catch (SQLException ex) {
            return liste;
        }
    }
    public static List<AvisSaison> afiicherTousAvisSaison(Saison s) {//aaficher tous les avis d'une saison
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AvisSaison> liste = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NETFLIX.AVISSAISON WHERE NOMPRODUIT=? AND NUMEROSAISON=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getNomSerie());
            pstmt.setInt(2, s.getNumeroSaison());
            rs = pstmt.executeQuery();
            // 4- Recupérer l'Id généré par le SGBD

            while (rs.next()) {
                String avis = rs.getString(3);
                String utilisateur = rs.getString(1);
                Utislisateur u=DAO_utilisateur.findAll().stream().filter(x->x.getNomprenom().equals(utilisateur)).toList().get(0);
                liste.add(new AvisSaison(u,s.getNomSerie(),avis,s.getNumeroSaison()));
            }
            return liste;
        } catch (SQLException ex) {
            return liste;
        }
    }
    public static List<AvisEpisode> afiicherTousAvisEpisode(Episode e) {//aaficher tous les avis d'une episode
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AvisEpisode> liste = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NETFLIX.AVISEPISODE WHERE NOMPRODUIT=? AND NUMEROSAISON=? AND NUMEROEPISODE=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, e.getNomSerie());
            pstmt.setInt(2, e.getNumeroSaison());
            pstmt.setInt(3,e.getNumeroEpisode());
            rs = pstmt.executeQuery();
            // 4- Recupérer l'Id généré par le SGBD

            while (rs.next()) {
                String avis = rs.getString(3);
                String utilisateur = rs.getString(1);
                Utislisateur u=DAO_utilisateur.findAll().stream().filter(x->x.getNomprenom().equals(utilisateur)).toList().get(0);
                liste.add(new AvisEpisode(u,e.getNomSerie(),avis,e.getNumeroSaison(),e.getNumeroEpisode()));
            }
            return liste;
        } catch (SQLException ex) {
            return liste;
        }
    }
    public static List<AvisProduit> afiicherTousAvisFilm(Film f) {//aaficher tous les avis d'une serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AvisProduit> liste = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NETFLIX.AVISPRODUIT WHERE NOMPRODUIT=? AND TYPE=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, f.getTitre());
            pstmt.setString(2, "film");
            rs = pstmt.executeQuery();
            // 4- Recupérer l'Id généré par le SGBD

            while (rs.next()) {
                String avis = rs.getString(3);
                String utilisateur = rs.getString(1);
                Utislisateur u=DAO_utilisateur.findAll().stream().filter(x->x.getNomprenom().equals(utilisateur)).toList().get(0);
                liste.add(new AvisProduit(u,f.getTitre(),avis));
            }
            return liste;
        } catch (SQLException ex) {
            return liste;
        }
    }






    public static  boolean modifyAvisFilm(AvisProduit av) {//modifier un avis d'un utilisateur a une serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE NETFLIX.AVISPRODUIT SET AVIS=? WHERE NOMUTILISATEUR=? AND NOMPRODUIT=? AND TYPE=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(2, av.getUtilisateur().getNomprenom());
            pstmt.setString(3, av.getNomProduit());
            pstmt.setString(1, av.getAvis());
            pstmt.setString(4, "film");
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static  boolean modifyAvisEpisode(AvisEpisode av) {//modifier un avis d'un utilisateur a une episode
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE NETFLIX.AVISEPISODE SET AVIS=? WHERE NOMUTILISATEUR=? AND NOMPRODUIT=? AND NUMEROSAISON=? AND NUMEROEPISODE=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(2, av.getUtilisateur().getNomprenom());
            pstmt.setString(3, av.getNomProduit());
            pstmt.setString(1, av.getAvis());
            pstmt.setInt(4,av.getNumSaison());
            pstmt.setInt(5,av.getNumEpisode());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static  boolean modifyAvisSaison(AvisSaison av) {//modifier un avis d'un utilisateur a une saison
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE NETFLIX.AVISSAISON SET AVIS=? WHERE NOMUTILISATEUR=? AND NOMPRODUIT=? AND NUMEROSAISON=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(2, av.getUtilisateur().getNomprenom());
            pstmt.setString(3, av.getNomProduit());
            pstmt.setString(1, av.getAvis());
            pstmt.setInt(4,av.getNumSaison());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static  boolean modifyAvisSerie(AvisProduit av) {//modifier un avis d'un utilisateur a une serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE NETFLIX.AVISPRODUIT SET AVIS=? WHERE NOMUTILISATEUR=? AND NOMPRODUIT=? AND TYPE=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(2, av.getUtilisateur().getNomprenom());
            pstmt.setString(3, av.getNomProduit());
            pstmt.setString(1, av.getAvis());
            pstmt.setString(4, "serie");
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }








    public static  boolean supprimerAvisSerie(AvisProduit av) {//supprimer un avis d'un utilisateur a une serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM NETFLIX.AVISPRODUIT WHERE WHERE NOMUTILISATEUR=? AND NOMPRODUIT=? AND TYPE=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, av.getUtilisateur().getNomprenom());
            pstmt.setString(2, av.getNomProduit());
            pstmt.setString(3, "serie");
            pstmt.executeUpdate();

            // 4- Recupérer l'Id généré par le SGBD
            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public static  boolean supprimerAvisSaison(AvisSaison av) {//supprimer un avis d'un utilisateur a une saison
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM NETFLIX.AVISSAISON WHERE NOMUTILISATEUR=? AND NOMPRODUIT=? AND NUMEROSAISON=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, av.getUtilisateur().getNomprenom());
            pstmt.setString(2, av.getNomProduit());
            pstmt.setInt(3, av.getNumSaison());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public static  boolean supprimerAvisFilm(AvisProduit av) {//supprimer un avis d'un utilisateur a une serie
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM NETFLIX.AVISPRODUIT WHERE WHERE NOMUTILISATEUR=? AND NOMPRODUIT=? AND TYPE=? ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, av.getUtilisateur().getNomprenom());
            pstmt.setString(2, av.getNomProduit());
            pstmt.setString(3, "film");
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public static  boolean supprimerAvisEpisode(AvisEpisode av) {//supprimer un avis d'un utilisateur a une episode
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM NETFLIX.AVISEPISODE WHERE NOMUTILISATEUR=? AND NOMPRODUIT=? AND NUMEROSAISON=? AND NUMEROEPISODE=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, av.getUtilisateur().getNomprenom());
            pstmt.setString(2, av.getNomProduit());
            pstmt.setInt(3, av.getNumSaison());
            pstmt.setInt(4, av.getNumEpisode());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
