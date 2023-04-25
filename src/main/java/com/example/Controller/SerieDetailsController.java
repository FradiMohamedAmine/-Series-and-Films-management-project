package com.example.Controller;

import com.example.Entities.AvisProduit;
import com.example.Entities.Serie;
import com.example.Service.ServiceAvis;
import com.example.Service.ServiceSerie;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SerieDetailsController {

    @FXML
    private VBox avis;
    @FXML
    private Label genre;

    @FXML
    private Label nbreSaisons;
    @FXML
    private ImageView img1;

    @FXML
    private Label namef;
    @FXML
    private Label note;
    @FXML
    private ComboBox numSaison;
    @FXML
    private Label producteur;
    public void setData(Serie s) throws IOException {
        if (s.getCover() != null) {
            InputStream stream = new FileInputStream(s.getCover());
            Image image = new Image(stream);
            img1.setImage(image);
        }
        this.nbreSaisons.setText(String.valueOf(s.getSaisons().size()));
        this.namef.setText(s.getTitre());
        this.note.setText(String.valueOf(s.getScoreMoy()));
        this.genre.setText(s.getGenre());
        this.producteur.setText(s.getProducteur());

        for (int i=0;i<s.getSaisons().size();i++)
            numSaison.getItems().add(String.valueOf(i+1));
        List<AvisProduit> l = ServiceAvis.afiicherTousAvisSerie(s);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/LesAvisProduit.fxml"));
        Node node = loader.load();
        // Set the data of the corresponding StudentItemController
                LesAvisProduitController lesAvisProduitController = loader.getController();

                lesAvisProduitController.initTable(s.getTitre(),l);
        avis.getChildren().add(node);
    }
}
