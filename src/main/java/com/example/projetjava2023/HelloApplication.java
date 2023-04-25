package com.example.projetjava2023;


import com.example.Controller.LoadController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;


public class HelloApplication extends Application {
    private static Scene scene;

  /*   @Override
   public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("login-view"));
        stage.setScene(scene);
        stage.show();
    }**/

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/javanet/kindaDone/"+ fxml+".fxml"));
            return fxmlLoader.load();
        }catch (IOException e){
            System.out.println("------------"+e.getMessage()+"--------------");
        }
        return null;
    }
    double x, y =0;

    @Override
    public void start(Stage stage) throws IOException {
        URL fxmlURL = getClass().getResource("/javanet/kindaDone/hello-view-producteurtest.fxml");
        Parent root = FXMLLoader.load(fxmlURL);
        Scene scene = new Scene(root,1500,1000);
        scene.setFill(Color.TRANSPARENT );
        stage.setResizable(false);
        stage.setTitle("T  E  S   T !");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMouseDragged(event -> {
            x=event.getSceneX();
            y= event.getSceneY();});

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX()-x);
            stage.setY(event.getScreenY()-y);

        });


        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();



//tekhdmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm



    }
}