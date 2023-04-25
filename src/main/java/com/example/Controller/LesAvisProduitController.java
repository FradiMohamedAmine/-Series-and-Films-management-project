package com.example.Controller;

import com.example.Entities.AvisProduit;
import com.example.Service.ServiceAvis;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class LesAvisProduitController {
    @FXML
    public VBox VboxAv;

    @FXML
    private Button btnout;

    @FXML
    private Label nameP;



    @FXML
    public ScrollPane scrollFilmRomantic;
    public void initTable(String titre,List<AvisProduit> l) {
    nameP.setText(titre);
    try {

        for(AvisProduit a : l){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/AvisProduit.fxml"));
            Node node = loader.load();
            // Set the data of the corresponding StudentItemController
            AvisProduitController avisproduitcontroller = loader.getController();
            avisproduitcontroller.setData(a);
            System.out.println("++++++++++++++++++");

            VboxAv.getChildren().add(node);
        }

    }catch (IOException e) {
        throw new RuntimeException(e);
    } ;

    }
}
