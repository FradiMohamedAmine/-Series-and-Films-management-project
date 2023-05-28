package com.example.Controller;

import com.example.Entities.Genre;
import com.example.Service.ServiceFavoris;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
public class GenreController {
    @FXML
    private Button btn_next;


    @FXML
    private CheckBox check_Sci;

    @FXML
    private CheckBox check_action;

    @FXML
    private CheckBox check_comedie;

    @FXML
    private CheckBox check_dramatique;

    @FXML
    private CheckBox check_historique;

    @FXML
    private CheckBox check_policier;

    @FXML
    private CheckBox check_romantique;

    private ArrayList<String> filmTypes = new ArrayList<>();
    @FXML
    void handleButtonAction(ActionEvent event) throws IOException, IOException {
        Parent helloViewParent = FXMLLoader.load(getClass().getResource("/javanet/kindaDone/login.fxml"));
        Scene helloViewScene = new Scene(helloViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(helloViewScene);
        window.show();
    }
    public void initialize() {
        // Add event listeners to all checkboxes
        check_Sci.setOnAction(event -> handleCheckbox(check_Sci, "Science Fiction"));
        check_action.setOnAction(event -> handleCheckbox(check_action, "Action"));
        check_comedie.setOnAction(event -> handleCheckbox(check_comedie, "Comedy"));
        check_dramatique.setOnAction(event -> handleCheckbox(check_dramatique, "Drama"));
        check_historique.setOnAction(event -> handleCheckbox(check_historique, "Historical"));
        check_policier.setOnAction(event -> handleCheckbox(check_policier, "Crime"));
        check_romantique.setOnAction(event -> handleCheckbox(check_romantique, "Romance"));
    }
    private void handleCheckbox(CheckBox checkbox, String filmType) {
        if (checkbox.isSelected()) {
            filmTypes.add(filmType);
            ServiceFavoris sf =new ServiceFavoris();
            switch(filmType){
                case "Science Fiction":sf.ajouterGenreFavorisDunUtilisateur(Genre.science_fiction, LoginController.u.getNomprenom());
                case "Action":sf.ajouterGenreFavorisDunUtilisateur(Genre.science_fiction, LoginController.u.getNomprenom());
                case "Comedy":sf.ajouterGenreFavorisDunUtilisateur(Genre.comedie, LoginController.u.getNomprenom());
                case "Drama":sf.ajouterGenreFavorisDunUtilisateur(Genre.dramatique, LoginController.u.getNomprenom());
                case "Historical":sf.ajouterGenreFavorisDunUtilisateur(Genre.historique, LoginController.u.getNomprenom());
                case "Crime":sf.ajouterGenreFavorisDunUtilisateur(Genre.policier, LoginController.u.getNomprenom());
                case "Romance":sf.ajouterGenreFavorisDunUtilisateur(Genre.policier, LoginController.u.getNomprenom());
            }

        } else {
            filmTypes.remove(filmType);
        }
    }
}
