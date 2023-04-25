package com.example.DAO;

import com.example.Entities.*;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.DAO.DAO_acteur.findAll;

public class DAO_favoris {
    private static Connection conn = ConxDB.getInstance();
    public static List<? super Produit> findProduitFavoriePersonne(String nomUtilisateur){//retourner tous les produits préferés d'un utilisateur donne en paramtre
        System.out.println("Cnx is "+conn);
        PreparedStatement pstmt ;
        ResultSet rs ;

        List<? super Produit> produitList= new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.FAVORIS where NOMCOMPLET=?";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nomUtilisateur);
            rs=pstmt.executeQuery();


             while (rs.next()) {

                String nomComplet = rs.getString(1);
                String nomProduit= rs.getString(2);
                 System.out.println(nomProduit);
                if(DAO_Serie.findAll().stream().filter(x->(x.getTitre().equals(nomProduit))).anyMatch(x->true)) {
                        for (Serie serie : DAO_Serie.findAll())
                        {
                            if (serie.getTitre().equals(nomProduit))
                                produitList.add(serie);
                        }
                }else{
                    for (Film film : DAO_film.findAll())
                    {
                        if (film.getTitre().equals(nomProduit)){
                            produitList.add(film);
                        }
                    }

                }
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return produitList;
    }
    public static List<Film> findFilmsFavoriePersonne(String nomUtilisateur){//retourner tous les produits préferés d'un utilisateur donne en paramtre
        System.out.println("Cnx is "+conn);
        PreparedStatement pstmt ;
        ResultSet rs ;

        List<Film> filmList= new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.FAVORIS where NOMCOMPLET=?";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nomUtilisateur);
            rs=pstmt.executeQuery();


            while (rs.next()) {

                String nomComplet = rs.getString(1);
                String nomProduit= rs.getString(2);
                System.out.println(nomProduit);
                if(DAO_film.findAll().stream().filter(x->(x.getTitre().equals(nomProduit))).anyMatch(x->true)) {
                    for (Film film : DAO_film.findAll())
                    {
                        if (film.getTitre().equals(nomProduit)){
                            filmList.add(film);
                        }
                    }

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }
    public static List<Serie> findSeriesFavoriePersonne(String nomUtilisateur){//retourner tous les produits préferés d'un utilisateur donne en paramtre
        System.out.println("Cnx is "+conn);
        PreparedStatement pstmt ;
        ResultSet rs ;

        List<Serie> seriesList= new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.FAVORIS where NOMCOMPLET=? ";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nomUtilisateur);
            rs=pstmt.executeQuery();


            while (rs.next()) {

                String nomComplet = rs.getString(1);
                String nomProduit= rs.getString(2);
                System.out.println(nomProduit);
                if(DAO_Serie.findAll().stream().filter(x->(x.getTitre().equals(nomProduit))).anyMatch(x->true)) {
                    for (Serie serie : DAO_Serie.findAll())
                    {
                        if (serie.getTitre().equals(nomProduit))
                            seriesList.add(serie);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return seriesList;
    }
    public static List<Acteur> findActeurFavoriePersonne(String nomUtilisateur){//retourner tous les acteurs préferés d'un utilisateur donne en paramtre
        System.out.println("Cnx is "+conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Acteur> LA =new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.ACTEURFAVORIS WHERE NOMCOMPLET=?";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            rs=pstmt.executeQuery();


            while (rs.next()) {
                String nomComplet = rs.getString(1);
                String nomActeur= rs.getString(2);
                LA =findAll().stream().filter(x->x.getNomprenom()==nomActeur).toList();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return LA;
    }
    public static List<Genre> findGenreFavoriePersonne(String nomUtilisateur) {//retourner tous les genres préferés d'un utilisateur donne en paramtre
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Genre> LG = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.GENREFAVORIS WHERE NOMCOMPLET=?";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nomUtilisateur);
            rs=pstmt.executeQuery();


            while (rs.next()) {
                String nomComplet = rs.getString(1);
                String genre= rs.getString(2);
                Genre genrefav = Genre.valueOf(genre);
                LG.add(genrefav);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return LG;
    }
    public static List<Utislisateur> findFavorieProduit(String nomProduit){//retourner tous les utilisateur qui preferent un produit donne en parametre
        System.out.println("Cnx is "+conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Utislisateur> utilisateurList= new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.FAVORIS WHERE NOMPRODUIT=?";
        try {
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nomProduit);
            rs = pstmt.executeQuery(SQL);

            while (rs.next()) {
                String nomComplet = rs.getString(1);
                nomProduit= rs.getString(2);
                List<Utislisateur> LS = DAO_utilisateur.findAll();
                utilisateurList= LS.stream().filter(x->x.getNomprenom().equals(nomComplet)).toList();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return utilisateurList;
    }
    // ====> A quoi ça sert ???






    public static boolean insererProduitFavorisDunUtilisateur(String nomProduit ,  String nomUtilisateur) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.FAVORIS(NOMCOMPLET,NOMPRODUIT) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, nomUtilisateur);
            pstmt.setString(2,nomProduit);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next())
                return true;
            else
                return false;


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static boolean insererActeurFavorisDunUtilisateur(String nomActeur ,  String nomUtilisateur) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.ACTEURFAVORIS(NOMCOMPLET,NOMACTEUR) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, nomUtilisateur);
            pstmt.setString(2,nomActeur);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next())
                return true;
            else
                return false;


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    public static boolean insererGenreFavorisDunUtilisateur(String genre ,  String nomUtilisateur) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.GENREFAVORIS(NOMCOMPLET,NOMGENRE) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, nomUtilisateur);
            pstmt.setString(2,genre);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next())
                return true;
            else
                return false;


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }









    public static boolean supprimerProduitFavorisDunUtilisateur(String nomProduit,  String nomUtilisateur) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "DELETE FROM NETFLIX.FAVORIS WHERE NOMCOMPLET =?  AND NOMPRODUIT=?";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nomUtilisateur);
            pstmt.setString(2, nomProduit);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static boolean supprimerActeurFavorisDunUtilisateur(String nomActeur,  String nomUtilisateur) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "DELETE FROM NETFLIX.ACTEURFAVORIS WHERE NOMCOMPLET =?  AND NOMACTEUR=?";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nomUtilisateur);
            pstmt.setString(2, nomActeur);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static boolean supprimerGenreFavorisDunUtilisateur(String genre,  String nomUtilisateur) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "DELETE FROM NETFLIX.GENREFAVORIS WHERE NOMCOMPLET =?  AND NOMGENRE=?";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nomUtilisateur);
            pstmt.setString(2, genre);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}