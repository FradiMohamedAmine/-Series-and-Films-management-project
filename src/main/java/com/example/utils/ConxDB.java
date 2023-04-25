package com.example.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConxDB {
    private static Connection connexion;

    private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USER = "NETFLIX";
    private final String PASS = "password";

    private ConxDB() throws SQLException{

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("1");
            //e.printStackTrace();
        }

        connexion= DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println(connexion);
    }

    public static Connection getInstance(){
        if (connexion == null)
            try {
                new ConxDB();
            }catch(Exception e){
                System.out.println("--"+e.getMessage());
            }
        return connexion;
    }
}
