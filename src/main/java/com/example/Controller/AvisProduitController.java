package com.example.Controller;

import com.example.Entities.AvisProduit;
import com.example.Entities.Serie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AvisProduitController {
    @FXML
    private Label preview;

    @FXML
    private Label username;
    public void setData(AvisProduit a) throws FileNotFoundException {
        username.setText(a.getUtilisateur().getNomprenom());
        preview.setText(a.getAvis());
    }
}
