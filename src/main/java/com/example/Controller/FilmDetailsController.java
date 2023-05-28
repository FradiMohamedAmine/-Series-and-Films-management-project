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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class FilmDetailsController {
    @FXML
    private Label resultsavis;
    @FXML
    private Label resultscore;
    @FXML
    private Label pays;
    @FXML
    private HBox hscore;
    @FXML
    private VBox avis;
    @FXML
    private Label vues;
    @FXML
    private Label genre;
    @FXML
    private TextField sc;

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
        boolean res =ServiceAvis.ajouterAvisFilm(new AvisProduit(new Utislisateur(p.getNomprenom(), p.getCompte()), namef1.getText(), textAvis.getText()));
        if(res)
            this.resultsavis.setText("Merci");
        else {
            ServiceAvis.modifierAvisFilm(new AvisProduit(new Utislisateur(p.getNomprenom(), p.getCompte()), namef1.getText(), textAvis.getText()));
            this.resultsavis.setText("Verifiez!!");
        }
        this.setData(f);
    }
    public boolean verifierscore(String s){
        try {
            double score = Double.parseDouble(s);
            return score >= 0 && score <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @FXML
    public void ajouterScore() throws IOException {
        Film f = ServiceFilm.afficherFilm(namef1.getText());
        Personne p = LoginController.p;
        if(verifierscore(sc.getText())) {
            ServiceFilm.ajouterScore(f, Integer.valueOf(sc.getText()));
            this.resultscore.setText("Merci");
        }
        else
            this.resultscore.setText("Verifiez!!");
        this.setData(f);
    }

    public void setData(Film f) throws IOException {
        this.namef1.setText(f.getTitre());
        this.pays.setText(f.getPaysOrigine());
        this.genre.setText(f.getGenre());
        this.producteur.setText(f.getProducteur());
        this.vues.setText(String.valueOf(f.getVues()));
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
            this.hscore.setVisible(false);


        }
    }
}