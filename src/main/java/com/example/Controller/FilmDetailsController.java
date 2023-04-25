package com.example.Controller;

import com.example.Entities.Film;
import com.example.Entities.Serie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FilmDetailsController {

    @FXML
    private Label genre;

    @FXML
    private ImageView img;

    @FXML
    private Label namef;

    @FXML
    private Label note;

    @FXML
    private Label producteur;
    public void setData(Film f){
        this.namef.setText(f.getTitre());
        this.note.setText(String.valueOf(f.getScoreMoy()));
        this.genre.setText(f.getGenre());
        this.producteur.setText(f.getProducteur());
    }
}
