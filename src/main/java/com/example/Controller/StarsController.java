package com.example.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.controlsfx.control.Rating;
//import org.controlsfx.control.Rating;

import java.net.URL;
import java.util.ResourceBundle;

public class StarsController implements Initializable {


   @FXML
    private Rating rating;

    @FXML
    private Label score;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   rating.ratingProperty().addListener((observable, oldValue, newValue) -> score.setText("Rating : " + newValue.toString()));
    }
}
