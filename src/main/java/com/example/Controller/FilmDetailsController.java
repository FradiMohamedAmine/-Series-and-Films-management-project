package com.example.Controller;

import com.example.Entities.*;
import com.example.Service.ServiceAvis;
import com.example.Service.ServiceFilm;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FilmDetailsController {
    @FXML
    private VBox avis;
    @FXML
    private Label score;
    @FXML
    private Label genre;

    @FXML
    private ImageView img1;

    @FXML
    private Label namef1;


    @FXML
    private Button btnAvis;
    @FXML
    private TextField textAvis;

    @FXML
    private Label producteur;

    @FXML
    public void ajouterAvis() throws IOException {
        Film f = ServiceFilm.afficherFilm(namef1.getText());
        Personne p = LoginController.p;
        ServiceAvis.ajouterAvisFilm(new AvisProduit(new Utislisateur(p.getNomprenom(), p.getCompte()), namef1.getText(), textAvis.getText()));
        this.setData(f);
    }


    public void setData(Film f) throws IOException {
        if (f.getCover() != null) {
            InputStream stream = new FileInputStream(f.getCover());
            Image image = new Image(stream);
            img1.setImage(image);
        }
        this.namef1.setText(f.getTitre());
        this.genre.setText(f.getGenre());
        this.producteur.setText(f.getProducteur());
        this.score.setText(String.valueOf(f.getScoreMoy()));
        List<AvisProduit> l = ServiceAvis.afiicherTousAvisFilm(f);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/LesAvisProduit.fxml"));
        Node node = loader.load();
        LesAvisProduitController lesAvisProduitController = loader.getController();
        lesAvisProduitController.initTable(f.getTitre(), l);
        avis.getChildren().add(node);
        if (!LoginController.p.getCompte().getType().equals("utilisateur")) {
            this.btnAvis.setVisible(false);
            this.btnAvis.setVisible(false);
            this.textAvis.setVisible(false);

        }
    }
}