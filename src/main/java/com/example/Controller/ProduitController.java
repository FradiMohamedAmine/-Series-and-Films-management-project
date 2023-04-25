package com.example.Controller;

import com.example.Entities.Produit;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;

public class ProduitController {

    @FXML
    private  ImageView img;

    @FXML
    private  Label namef;


    public void setData(Produit p){
        Image image= new Image(getClass().getResourceAsStream(p.getCover()));
        img.setImage(image);
        namef.setText(p.getTitre());

    }
}
