package com.example.Controller;

import com.example.Entities.Compte;
import com.example.Entities.Serie;
import com.example.Entities.Utislisateur;
import com.example.Service.ServiceFavoris;
import com.example.Service.ServiceSerie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SerieItemController {
    @FXML
    private VBox Vboxprinci;
    @FXML
    private Button btnFavoris;


    @FXML
    private ImageView img;
    @FXML
    private Button btnDetails;

    @FXML
    private Label namef;
    @FXML
    public void setData(Serie s) throws FileNotFoundException {
        this.namef.setText(s.getTitre());
        if (s.getCover() != null) {
            InputStream stream = new FileInputStream(s.getCover());
            Image image = new Image(stream);
            img.setImage(image);
        }
    }
    public void ajoutFavoris(){
        Serie s = ServiceSerie.afficherSerie(namef.getText());
        Utislisateur u= new Utislisateur("Ali Lahbib",new Compte("mail","mdp","utilisateur"));
        ServiceFavoris sF = new ServiceFavoris();
        sF.ajouterSerieFavorisDunUtilisateur(s,u.nomprenom);
    }
    @FXML
    public void afficherDetailsSerie() throws IOException {
        Serie s=ServiceSerie.afficherSerie(namef.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/serie_details.fxml"));
        System.out.println(loader.getLocation());
        Node node = loader.load();
        // Set the data of the corresponding SerieDetailsController
        SerieDetailsController seriedetailsController = loader.getController();
        seriedetailsController.setData(s);
        Vboxprinci.getChildren().add(node);

    }
}
