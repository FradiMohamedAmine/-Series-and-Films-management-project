package com.example.projetjava2023;


import com.example.Controller.LoadController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/javanet/kindaDone/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMaximized(true);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
       // FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/javanet/kindaDone/load.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/kindaDone/load.fxml"));
        Parent root = loader.load();
        LoadController controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) throws SQLException {
        launch();



//tekhdmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm



    }
}