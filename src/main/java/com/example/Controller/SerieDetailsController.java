package com.example.Controller;

import com.example.Entities.*;
import com.example.Service.ServiceAvis;
import com.example.Service.ServiceSerie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class SerieDetailsController {
    @FXML
    private Label resultavis;
    @FXML
    private Label pays;
    @FXML
    private Label resultscore;

    @FXML
    private VBox avis;
    @FXML
    private Label genre;
    @FXML
    private HBox hscore;
    @FXML
    private Label nbreSaisons;

    @FXML
    private Label score;
    @FXML
    private Label namef;
    @FXML
    private Label note;
    @FXML
    private ComboBox numSaison;
    @FXML
    private Label producteur;
    @FXML
    private Button btnAvis;
    @FXML
    private TextField textAvis;
    @FXML
    private TextField sc;
    @FXML
    public void ajouterAvis() throws IOException {
        Serie s = ServiceSerie.afficherSerie(namef.getText());
        Personne p = LoginController.p;
        boolean res=ServiceAvis.ajouterAvisFilm(new AvisProduit(new Utislisateur(p.getNomprenom(), p.getCompte()), namef.getText(), textAvis.getText()));
        this.setData(s);
        if(res)
            this.resultavis.setText("Merci");
        else {
            this.resultavis.setText("Verifiez!!");
            ServiceAvis.modifierAvisSerie(new AvisProduit(new Utislisateur(p.getNomprenom(), p.getCompte()), namef.getText(), textAvis.getText()));
        }
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
        Serie s = ServiceSerie.afficherSerie(namef.getText());
        Personne p = LoginController.p;
        if(verifierscore(sc.getText())) {
            ServiceSerie.ajouterScore(s, Integer.valueOf(sc.getText()));
            resultscore.setText("Merci");

        }
        else resultscore.setText("Verifiez!!");
        this.setData(s);
    }
    public void setData(Serie s) throws IOException {
        this.nbreSaisons.setText(String.valueOf(s.getSaisons().size()));
        this.pays.setText(s.getPaysOrigine());
        this.namef.setText(s.getTitre());
        this.genre.setText(s.getGenre());
        this.producteur.setText(s.getProducteur());

        /*for (int i=0;i<s.getSaisons().size();i++)
            numSaison.getItems().add(String.valueOf(i+1));*/
        List<AvisProduit> l = ServiceAvis.afiicherTousAvisSerie(s);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/LesAvisProduit.fxml"));
        Node node = loader.load();
        // Set the data of the corresponding StudentItemController
        LesAvisProduitController lesAvisProduitController = loader.getController();
        lesAvisProduitController.initTable(s.getTitre(),l);
        avis.getChildren().add(node);
        if (!LoginController.p.getCompte().getType().equals("utilisateur")) {
            this.btnAvis.setVisible(false);
            this.btnAvis.setVisible(false);
            this.textAvis.setVisible(false);
            this.hscore.setVisible(false);

        }
    }
}
