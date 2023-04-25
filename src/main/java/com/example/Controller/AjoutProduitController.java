package com.example.Controller;
import com.example.Entities.Film;
import com.example.Entities.Serie;
import com.example.Service.ServiceFilm;
import com.example.Service.ServiceSerie;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AjoutProduitController implements Initializable{
    @FXML
    private TextField anneSortieF;

    @FXML
    private Tab anneSortieS;

    @FXML
    private TextField anneeSortieS;

    @FXML
    private Button btnCommitF;

    @FXML
    private Button btnCommitS;

    @FXML
    private ComboBox comboboxF;

    @FXML
    private ComboBox comboboxS;

    @FXML
    private TextField dureeF;

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
    private TabPane tabPane;

    @FXML
    private TextField titrefilm;

    @FXML
    private TextField titreserie;

    @FXML
    void ajoutfilm(ActionEvent event) {
        ServiceFilm.ajouterFilm(new Film(this.titrefilm.getText(),this.producteurF.getText(),Integer.valueOf(this.anneSortieF.getText()),this.langueF.getText(),this.paysF.getText(),Integer.valueOf(this.dureeF.getText())));

    }

    @FXML
    void ajoutserie(ActionEvent event) {
        ServiceSerie.ajouterSerie(new Serie(this.titreserie.getText(),this.producteurS.getText(),Integer.valueOf(this.anneSortieS.getText()),this.langueS.getText(),this.paysS.getText()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.comboboxF.setItems(FXCollections.observableArrayList("comedie","dramatique","policier","action","historique","science_fiction").sorted());

        this.comboboxS.setItems(FXCollections.observableArrayList("comedie","dramatique","policier","action","historique","science_fiction").sorted());

    }}