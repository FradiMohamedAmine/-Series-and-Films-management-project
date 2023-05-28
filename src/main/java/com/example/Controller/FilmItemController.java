package com.example.Controller;
import com.example.Entities.*;
import com.example.Service.ServiceFavoris;
import com.example.Service.ServiceFilm;
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
import java.sql.SQLException;

public class FilmItemController {
    @FXML
    private VBox Vboxprinci;
    @FXML
    private Button btnDetails;

    @FXML
    private Button btnFavoris;

    @FXML
    private Button btnPlay;

    @FXML
    private ImageView img;

    @FXML
    private Label namef;

    public void setData(Film f) throws FileNotFoundException {
        if (f.getCover() != null) {
            InputStream stream = new FileInputStream(f.getCover());
            Image image = new Image(stream);
            img.setImage(image);
        }
        this.namef.setText(f.getTitre());
        if(!LoginController.p.getCompte().getType().equals("utilisateur")) {
            this.btnPlay.setVisible(false);
            this.btnFavoris.setVisible(false);
        }
    }
    @FXML public void ajoutVu() throws SQLException {
        Film f = ServiceFilm.afficherFilm(namef.getText());
        ServiceFilm.ajouterVu(f);
    }
    @FXML public void ajoutFavoris(){
        Film f = ServiceFilm.afficherFilm(namef.getText());
        Utislisateur u= new Utislisateur("Ali Lahbib",new Compte("mail","mdp","utilisateur"));
        ServiceFavoris sF = new ServiceFavoris();
        sF.ajouterFilmFavorisDunUtilisateur(f,u.nomprenom);
    }
    @FXML
    public void afficherDetailsFilm() throws IOException {
        Film f= ServiceFilm.afficherFilm(namef.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film_details.fxml"));
        System.out.println(loader.getLocation());
        Node node = loader.load();
        // Set the data of the corresponding SerieDetailsController
        FilmDetailsController filmdetailsController = loader.getController();
        filmdetailsController.setData(f);
        Vboxprinci.getChildren().add(node);

    }


}

