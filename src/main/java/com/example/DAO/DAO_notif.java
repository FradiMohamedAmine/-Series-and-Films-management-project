package com.example.DAO;

import com.example.Entities.*;
import com.example.utils.ConxDB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DAO_notif {
    private static Connection conn = ConxDB.getInstance();

    public static List<Notification> findAll(String user){
        System.out.println("Cnx is "+conn);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Notification> notificationsList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM NETFLIX.NOTIF where UTILISATEUR=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);

            pstmt.setString(1, user);
            rs=pstmt.executeQuery();


            while (rs.next()) {
                int id = rs.getInt(1);
                String utilisateur = rs.getString(2);
                String message = rs.getString(3);
                LocalDate date = rs.getDate(4).toLocalDate();
                Notification notification = new Notification(id,DAO_utilisateur.findAll().stream().filter(x->x.getNomprenom().equals(utilisateur)).collect(Collectors.toList()).get(0) , message ,date);
                notificationsList.add(notification);
            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return notificationsList;
    }


    public static  boolean insererNotification(Notification notification) {
    int notifId = 0;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

        try {
        String sql = "INSERT INTO NETFLIX.NOTIF(UTILISATEUR,MESSAGE) VALUES (?,?,?)";

        pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, notification.getUtislisateur().getNomprenom() );
        pstmt.setString(2, notification.getMessage());
        LocalDate localDate = LocalDate.now();
        pstmt.setDate(3, java.sql.Date.valueOf(localDate));



        pstmt.executeUpdate();

        rs = pstmt.getGeneratedKeys();

        if(rs.next()) {
            notifId = rs.getInt(1);
            return  true ;
        }
    }catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
		return false;
}


    public static  boolean deleteNotification(Notification n) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM NETFLIX.NOTIF where ID_NOTIFICATION=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("coonexion is---------------------- " + conn);
            pstmt.setInt(1, n.getId());



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
