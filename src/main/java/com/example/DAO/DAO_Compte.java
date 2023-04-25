package com.example.DAO;

import com.example.Entities.*;
import com.example.utils.ConxDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DAO_Compte {
    private static Connection conn = ConxDB.getInstance();

    public static boolean modifyUserName(String mail, String MotDePasse,String neauveauNom){
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "UPDATE NETFLIX.PERSONNE SET NOMCOMPLET=? where MAIL=? AND MDP=? ";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, neauveauNom);
            pstmt.setString(2, mail);
            pstmt.setString(3, MotDePasse);
            rs= pstmt.executeQuery();
            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static boolean modifyPassword(String mail, String ancienMotDePasse,String nouveauMotDePasse){
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String SQL = "UPDATE NETFLIX.PERSONNE SET MDP=? where MAIL=? AND MDP=? ";
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nouveauMotDePasse);
            pstmt.setString(2, mail);
            pstmt.setString(3, ancienMotDePasse);
            rs= pstmt.executeQuery();
            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }





    public static Personne get(String mailAdresse, String motdepasse) throws SQLException {
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<?super Personne> personneList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PERSONNE WHERE MAIL=? AND MDP=?";
        pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, mailAdresse);
        pstmt.setString(2, motdepasse);
        rs=pstmt.executeQuery();


        while (rs.next()) {
            String nomComplet = rs.getString(1);
            String mail= rs.getString(3);
            String mdp= rs.getString(4);
            String type=rs.getString(2);
            Personne p=new Personne(nomComplet,new Compte(mail,mdp,type));
            return p;
        }
        return null;

    }
    public static List<?super Personne> getAll() throws SQLException {
        System.out.println("Cnx is " + conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<? super Personne> personneList = new ArrayList<>();

        String SQL = "SELECT * FROM NETFLIX.PERSONNE";
        pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

        rs = pstmt.executeQuery();


        while (rs.next()) {
            String nomComplet = rs.getString(1);
            String mail = rs.getString(3);
            String mdp = rs.getString(4);
            String type = rs.getString(2);


            switch (type) {
                case "acteur": {
                    Acteur a = new Acteur(nomComplet, new Compte(mail,mdp,"acteur"));
                    personneList.add(a);
                }

                case "utilisateur": {

                    Utislisateur u = new Utislisateur(nomComplet, new Compte(mail,mdp,"utilisateur"));
                    personneList.add(u);
                }
                case "producteur": {
                    Producteur pr = new Producteur(nomComplet, new Compte(mail,mdp,"producteur"));
                    personneList.add(pr);
                }
            }
        }
        return personneList.stream().distinct().toList();
    }





}

