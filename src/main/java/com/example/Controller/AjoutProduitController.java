package com.example.Controller;

import com.example.Entities.Film;
import com.example.Entities.Serie;
import com.example.Service.ServiceFilm;
import com.example.Service.ServiceSerie;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AjoutProduitController implements Initializable {
    @FXML
    private TextField anneSortieF;
    @FXML
    private ComboBox<String> comboPays1;

    @FXML
    private TextField anneeSortieS;

    @FXML
    private Button btnCommitF;
    @FXML
    private TextArea subtext;
    @FXML
    private TextArea subtext1;
    FileChooser fileChooser=new FileChooser();
    @FXML
    private Button btnCommitS;

    @FXML
    private ComboBox<String> comboboxF;

    @FXML
    private ComboBox<String> comboboxS;

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
    private Label resultatF;

    @FXML
    private Label resultatS;

    @FXML
    private ComboBox<String> comboPays;
    @FXML
    private TabPane tabPane;

    @FXML
    private TextField titrefilm;

    @FXML
    private TextField titreserie;


    @FXML
    void ajoutfilm(ActionEvent event) {
        Film f =new Film(this.titrefilm.getText(),this.producteurF.getText(),Integer.valueOf(this.anneSortieF.getText()),this.langueF.getText(),this.comboPays.getValue(),Integer.valueOf(this.dureeF.getText()));
        f.setGenre(this.comboboxF.getValue());
        f.setCover(this.subtext.getText());
        boolean resF= ServiceFilm.ajouterFilm(f);
        if(resF){
            this.resultatF.setText("ajout avec succes");
        }
        else this.resultatF.setText("verifier");
    }
    @FXML
    void ajoutserie(ActionEvent event) {
        Serie s=new Serie(this.titreserie.getText(),this.producteurS.getText(),Integer.valueOf(this.anneeSortieS.getText()),this.langueS.getText(),this.comboPays1.getValue());
        s.setGenre(this.comboboxS.getValue());
        s.setCover(this.subtext1.getText());
        boolean resS= ServiceSerie.ajouterSerie(s);
        if(resS){
            this.resultatS.setText("ajout avec succes");
        }
        else this.resultatS.setText("verifier");
    }
    @FXML
    void getText(ActionEvent event) {
        File file=  fileChooser.showOpenDialog(new Stage());
        this.subtext.setText(file.getPath());
    }
    @FXML
    void getText1(ActionEvent event) {
        File file=  fileChooser.showOpenDialog(new Stage());
        this.subtext1.setText(file.getPath());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.comboboxF.setItems(FXCollections.observableArrayList("comedie","romantique","dramatique","policier","action","historique","science_fiction").sorted());
        this.comboboxS.setItems(FXCollections.observableArrayList("comedie","dramatique","romantique","policier","action","historique","science_fiction").sorted());
        this.producteurF.setText(LoginController.p.getNomprenom());
        this.producteurS.setText(LoginController.p.getNomprenom());
        this.producteurF.setDisable(true);
        this.producteurS.setDisable(true);
        this.comboPays.setItems(FXCollections.observableArrayList(Stream.of(Locale.getISOCountries())
                .map(countryCode -> new Locale("", countryCode))
                .map(locale -> locale.getDisplayCountry())
                .sorted()
                .collect(Collectors.toList())));
        this.comboPays1.setItems(FXCollections.observableArrayList(Stream.of(Locale.getISOCountries())
                .map(countryCode -> new Locale("", countryCode))
                .map(locale -> locale.getDisplayCountry())
                .sorted()
                .collect(Collectors.toList())));
        fileChooser.setInitialDirectory(new File("C:\\Users\\alila\\OneDrive\\Bureau"));

    }
}


