package com.example.Controller;
import com.example.Entities.Compte;
import com.example.Entities.Film;
import com.example.Entities.Utislisateur;
import com.example.Service.ServiceFavoris;
import com.example.Service.ServiceFilm;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.Provider;
import java.sql.SQLException;

public class FilmItemController {
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
    }

    public void ajoutVu() throws SQLException {
        Film f = ServiceFilm.afficherFilm(namef.getText());
        ServiceFilm.ajouterVu(f);
    }
    public void ajoutFavoris(){
        Film f = ServiceFilm.afficherFilm(namef.getText());
        Utislisateur u= new Utislisateur("Ali Lahbib",new Compte("mail","mdp","utilisateur"));
        ServiceFavoris sF = new ServiceFavoris();
        sF.ajouterFilmFavorisDunUtilisateur(f,u.nomprenom);
    }


}

