package com.example.DAO;


import com.example.Entities.Compte;
import com.example.Entities.Film;
import com.example.Entities.Utislisateur;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_utilisateur {
    private static Connection conn = ConxDB.getInstance();
    public static List<Utislisateur> findAll(){//retourner tous les utilisateurs
        System.out.println("Cnx is "+conn);
        Statement stmt = null;
        ResultSet rs = null;

        List<Utislisateur> utilisateurList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PERSONNE WHERE TYPE='utilisateur'";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String nomComplet = rs.getString(1);
                String mail= rs.getString(3);
                String mdp= rs.getString(4);
               Utislisateur user =new Utislisateur(nomComplet,new Compte(mail,mdp,"utilisateur"));
               utilisateurList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return utilisateurList;
    }



    public static  boolean insererUtilisateur(Utislisateur U) {//inserer un utilisateur à partir d'un objet utilisateur
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO NETFLIX.PERSONNE(MAIL,MDP,NOMCOMPLET,TYPE) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(1, U.compte.getMail());
            pstmt.setString(2, U.compte.getMdp());
            pstmt.setString(3, U.getNomprenom());
            pstmt.setString(4, "utilisateur");


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




    public static  boolean supprimerUtilisateur(Utislisateur U) {//supprimer un utilisateur à partir d'un objet utilisateur
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE  FROM NETFLIX.PERSONNE WHERE TYPE=?  AND MAIL=? AND MDP=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setString(2, U.compte.getMail());
            pstmt.setString(3, U.compte.getMdp());

            pstmt.setString(1, "utilisateur");


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
