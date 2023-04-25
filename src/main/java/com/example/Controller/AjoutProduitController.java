package com.example.Controller;

import com.example.Entities.Film;
import com.example.Entities.Serie;
import com.example.Service.ServiceFilm;
import com.example.Service.ServiceSerie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class AjoutProduitController {
    @FXML
    private Button S;

    @FXML
    private TextField anneSortieF;

    @FXML
    private TextField anneSortieS;

    @FXML
    private Button btnCommitS;

    @FXML
    private ComboBox<?> comboboxF;

    @FXML
    private ComboBox<?> comboboxS;

    @FXML
    private TextField langueF;

    @FXML
    private TextField langueS;

    @FXML
    private TextField paysF;

    @FXML
    private TextField paysS;

    @FXML
    private TextField producteurF;

    @FXML
    private TextField producteurS;
    @FXML
    private TextField dureeF;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField titreserie;

    @FXML
    private TextField titrefilm;


    @FXML
    void ajoutfilm(ActionEvent event) {
        ServiceFilm.ajouterFilm(new Film(this.titrefilm.getText(),this.producteurF.getText(),Integer.valueOf(this.anneSortieF.getText()),this.langueF.getText(),this.paysF.getText(),Integer.valueOf(this.dureeF.getText())));

    }

    @FXML
    void ajoutserie(ActionEvent event) {
        ServiceSerie.ajouterSerie(new Serie(this.titreserie.getText(),this.producteurS.getText(),Integer.valueOf(this.anneSortieS.getText()),this.langueS.getText(),this.paysS.getText()));

    }

}


