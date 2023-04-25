package com.example.Controller;

import com.example.Entities.Produit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private HBox favoriscontainer;
    List<Produit >recentlyPlay ;
    List<Produit>favoris ;
    @FXML
    private HBox recentlyplayedcontainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyPlay= new ArrayList<>(getRecently());
        favoris= new ArrayList<>(getFavoris());


        try {
            for (Produit produit : recentlyPlay) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("film.fxml"));

                VBox vbox = fxmlLoader.load();
                ProduitController produitController = fxmlLoader.getController();
                produitController.setData(produit);

                recentlyplayedcontainer.getChildren().add(vbox);

            }
            for (Produit produit : favoris) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("film.fxml"));

                VBox vbox = fxmlLoader.load();
                ProduitController produitController = fxmlLoader.getController();
                produitController.setData(produit);

                favoriscontainer.getChildren().add(vbox);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private List<Produit> getRecently() {
        List<Produit> ls = new ArrayList<>();

        Produit prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");

        ls.add(prod);
        prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");;

        ls.add(prod);
        prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");

        ls.add(prod);
        prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");

        ls.add(prod);
        return ls;


    }
    public List<Produit>getFavoris(){
        List<Produit> ls = new ArrayList<>();

        Produit prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");
        ls.add(prod);

        prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");

        ls.add(prod);
        prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");

        ls.add(prod);
        prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");

        ls.add(prod);
        prod = new Produit("esm film ","tess",2022,"arabe","tunisie ","/sample/gfd.jpg");

        ls.add(prod);


        return ls;
    }








}
