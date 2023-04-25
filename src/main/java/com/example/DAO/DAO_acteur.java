package com.example.DAO;

import com.example.Entities.*;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_acteur {
    private static Connection conn = ConxDB.getInstance();
    public static List<Acteur> findAll(){//retourner tous les acteurs
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;

        List<Acteur> acteurList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PERSONNE WHERE TYPE='acteur'";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String nomComplet = rs.getString(1);
                String mail= rs.getString(3);
                String mdp= rs.getString(4);
                Acteur a =new Acteur(nomComplet,new Compte(mail,mdp,"acteur"));
                acteurList.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return acteurList;
    }
    public static Boolean findParticipation(String nomActeur , String nomProduit){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM NETFLIX.PARTICIPATION where NOMACTEUR=? and NOMPRODUIT=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, nomActeur);
            pstmt.setString(2,nomProduit);
            rs=pstmt.executeQuery();


            if (rs.next())
                return true;

            else
            return false;



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }


    public static  boolean insererActeur(Acteur a) {//inserer un acteur à partir d'un objet acteur
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.PERSONNE(MAIL,MDP,NOMCOMPLET,TYPE) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, a.compte.getMail());
            pstmt.setString(2, a.compte.getMdp());
            pstmt.setString(3, a.getNomprenom());
            pstmt.setString(4, "acteur");


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

    public static  boolean insererParticipation(Acteur a,Produit p,String role) {//inserer un acteur à partir d'un objet acteur
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.PARTICIPATION(NOMACTEUR,NOMPRODUIT,ROLE) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, a.getNomprenom());
            pstmt.setString(2, p.getTitre());
            pstmt.setString(3, role);


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


    public static boolean modifierParticipation(String nomprenom,String nomProduit,String nouveauRole){
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "UPDATE NETFLIX.PARTICIPATION SET ROLE=? where NOMACTEUR=? and NOMPRODUIT=? ";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nouveauRole);
            pstmt.setString(2, nomprenom);
            pstmt.setString(3, nomProduit);
            rs= pstmt.executeQuery();
            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;





    }







    public static  boolean supprimerActeur(Acteur a) {//supprimer un acteur à partir d'un objet acteur
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM  NETFLIX.PERSONNE WHERE TYPE=? AND MAIL=? AND MDP=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(2, a.compte.getMail());
            pstmt.setString(3, a.compte.getMdp());

            pstmt.setString(1, "acteur");


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

    public static  boolean supprimerParticipation(String nomprenom,String nomProduit) {//supprimer un acteur à partir d'un objet acteur
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM  NETFLIX.PARTICIPATION WHERE NOMACTEUR=? and NOMPRODUIT=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, nomprenom);
            pstmt.setString(2, nomProduit);



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
}