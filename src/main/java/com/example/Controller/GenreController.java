package com.example.Controller;

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
    private Button btn_next1;
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
        if(event.getSource() == btn_next) {
            Parent helloViewParent = FXMLLoader.load(getClass().getResource("/javanet/kindaDone/hello_view.fxml"));
            Scene helloViewScene = new Scene(helloViewParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(helloViewScene);
            window.show();
        } else if(event.getSource() == btn_next1) {
            Parent loginParent = FXMLLoader.load(getClass().getResource("/javanet/kindaDone/login_view.fxml"));
            Scene loginScene = new Scene(loginParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
        }
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
        } else {
            filmTypes.remove(filmType);
        }
    }

}