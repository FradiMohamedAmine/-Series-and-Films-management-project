package com.example.DAO;

import com.example.Entities.Acteur;
import com.example.Entities.Compte;
import com.example.Entities.Producteur;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_producteur {
    private static Connection conn = ConxDB.getInstance();
    public static List<Producteur> findAll(){//retourner tous les producteurs
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;

        List<Producteur> producteurList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PERSONNE WHERE TYPE='producteur'";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String nomComplet = rs.getString(1);
                String mail= rs.getString(3);
                String mdp= rs.getString(4);
                Producteur p =new Producteur(nomComplet,new Compte(mail,mdp,"producteur"));
                producteurList.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  producteurList;
    }


    public static  boolean insererProducteur(Producteur p) {//inserer un producteur à partir d'un objet producteur
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.PERSONNE(MAIL,MDP,NOMCOMPLET,TYPE) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, p.compte.getMail());
            pstmt.setString(2, p.compte.getMdp());
            pstmt.setString(3, p.getNomprenom());
            pstmt.setString(4, "producteur");


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




    public static  boolean supprimerProducteur(Producteur p) {//supprimer un producteur à partir d'un objet producteur
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM  NETFLIX.PERSONNE WHERE TYPE=? AND MAIL=? AND MDP=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(2, p.compte.getMail());
            pstmt.setString(3, p.compte.getMdp());

            pstmt.setString(1, "producteur");


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
