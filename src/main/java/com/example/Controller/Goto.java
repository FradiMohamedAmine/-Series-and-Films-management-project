package com.example.Controller;

import com.example.DAO.DAO_Serie;
import com.example.DAO.DAO_film;
import com.example.Entities.Film;
import com.example.Entities.Serie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.Rating ;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Goto implements Initializable {
    @FXML
    private AnchorPane FilmAct;

    @FXML
    private AnchorPane FilmCom;

    @FXML
    private AnchorPane FilmDrama;

    @FXML
    private AnchorPane FilmHis;

    @FXML
    private AnchorPane FilmPol;

    @FXML
    private AnchorPane FilmRom;

    @FXML
    private AnchorPane FilmScFi;

    @FXML
    private AnchorPane SerieAction;

    @FXML
    private AnchorPane SerieCom;

    @FXML
    private AnchorPane SerieDrama;

    @FXML
    private AnchorPane SerieHis;

    @FXML
    private AnchorPane SeriePol;

    @FXML
    private AnchorPane SerieRom;

    @FXML
    private AnchorPane SerieScFi;

    @FXML
    private VBox VboxToChange;

    @FXML
    private AnchorPane firstPic;
    @FXML
    private Label username;
    @FXML
    private HBox hBoxScrollFilmScFi;
    @FXML
    private HBox hBoxScrollSerieScFi;
    @FXML
    private ScrollPane scrollFilmScienceFiction;
    @FXML
    private ScrollPane scrollSerieScienceFiction;
    @FXML
    private ScrollPane scrollSeriePolicier;
    @FXML
    private ScrollPane scrollFilmPolicier;
    @FXML
    private HBox hBoxScrollSeriePol;
    @FXML
    private HBox hBoxScrollFilmPoli;

    @FXML
    private ScrollPane scrollSerieHistorique;
    @FXML
    private ScrollPane scrollFilmHistorique;
    @FXML
    private HBox hBoxScrollSerieHis;
    @FXML
    private HBox hBoxScrollFilmHis;
    @FXML
    private ScrollPane scrollSerieDramatique;
    @FXML
    private ScrollPane scrollFilmDramatique;
    @FXML
    private HBox hBoxScrollSerieDrama;
    @FXML
    private HBox hBoxScrollFilmDrama;
    @FXML
    private HBox hBoxScrollSerieComedie;
    @FXML
    private HBox hBoxScrollFilmCom;
    @FXML
    private ScrollPane scrollSerieComedie;

    @FXML
    private ScrollPane scrollFilmComedie;
    @FXML
    private HBox hBoxScrollFilmAction;
    @FXML
    private HBox hBoxScrollSerieAction;
    @FXML
    private ScrollPane scrollFilmAction;
    @FXML
    private ScrollPane scrollSerieAction;
    @FXML
    private ScrollPane scrollSerieRomantic;
    @FXML
    private HBox hBoxScrollSerieRom;
    @FXML
    private ScrollPane scrollFilmRomantic;


    @FXML
    private HBox hBoxScrollFilmRom;

    @FXML
    private Button out;
    @FXML
    private Rating rating;

    @FXML
    private Label ratinglabel;
    @FXML
    public void AfficherSeries(){
        VboxToChange.getChildren().clear();
        VboxToChange.getChildren().add(SerieAction);
        VboxToChange.getChildren().add(SerieScFi);
        VboxToChange.getChildren().add(SerieCom);
        VboxToChange.getChildren().add(SerieDrama);
        VboxToChange.getChildren().add(SerieHis);
        VboxToChange.getChildren().add(SeriePol);
        VboxToChange.getChildren().add(SerieRom);
    }
    @FXML
    public void AfficherFilm(){
        VboxToChange.getChildren().clear();
        VboxToChange.getChildren().add(FilmAct);
        VboxToChange.getChildren().add(FilmScFi);
        VboxToChange.getChildren().add(FilmCom);
        VboxToChange.getChildren().add(FilmDrama);
        VboxToChange.getChildren().add(FilmHis);
        VboxToChange.getChildren().add(FilmPol);
        VboxToChange.getChildren().add(FilmRom);
    }
    //tekhdm
    @FXML
    public void handle() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/kindaDone/login-view.fxml"));
        Parent loginRoot = loader.load();
        Scene currentScene =out.getScene();
        currentScene.setRoot(loginRoot);
    }
    @FXML
    public void handle2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/kindaDone/hello-view.fxml"));
        Parent loginRoot = loader.load();
        Scene currentScene =out.getScene();
        currentScene.setRoot(loginRoot);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       this.username.setText(LoginController.p.getNomprenom());
        scrollFilmRomantic.setFitToWidth(true);
        addCardToScrollPaneFilmsRom(FXCollections.observableArrayList(DAO_film.findAll()));
        scrollSerieRomantic.setFitToWidth(true);
        addCardToScrollPaneSeriesRom(FXCollections.observableArrayList(DAO_Serie.findAll()));
        scrollSerieAction.setFitToWidth(true);
        addCardToScrollPaneSeriesAction(FXCollections.observableArrayList(DAO_Serie.findAll()));
        scrollFilmAction.setFitToWidth(true);
        addCardToScrollPaneFilmsAction(FXCollections.observableArrayList(DAO_film.findAll()));
        scrollFilmComedie.setFitToWidth(true);
        addCardToScrollPaneFilmsCom(FXCollections.observableArrayList(DAO_film.findAll()));
        scrollSerieComedie.setFitToWidth(true);
        addCardToScrollPaneSeriesComedie(FXCollections.observableArrayList(DAO_Serie.findAll()));
        scrollSerieDramatique.setFitToWidth(true);
        addCardToScrollPaneSeriesDrama(FXCollections.observableArrayList(DAO_Serie.findAll()));
        scrollFilmDramatique.setFitToWidth(true);
        addCardToScrollPaneFilmsDrama(FXCollections.observableArrayList(DAO_film.findAll()));
        scrollSerieHistorique.setFitToWidth(true);
        addCardToScrollPaneSeriesHis(FXCollections.observableArrayList(DAO_Serie.findAll()));
        scrollFilmHistorique.setFitToWidth(true);
        addCardToScrollPaneFilmsHis(FXCollections.observableArrayList(DAO_film.findAll()));
        scrollSeriePolicier.setFitToWidth(true);
        addCardToScrollPaneSeriesPol(FXCollections.observableArrayList(DAO_Serie.findAll()));
        scrollFilmPolicier.setFitToWidth(true);
        addCardToScrollPaneFilmsPol(FXCollections.observableArrayList(DAO_film.findAll()));
        scrollSerieScienceFiction.setFitToWidth(true);
        addCardToScrollPaneSeriesScFi(FXCollections.observableArrayList(DAO_Serie.findAll()));
        scrollFilmScienceFiction.setFitToWidth(true);
        addCardToScrollPaneFilmsScFi(FXCollections.observableArrayList(DAO_film.findAll()));

        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film.fxml"));
        String nomInterface="film";
        try {
            v.getChildren().add(new FXMLLoader(getClass().getResource("/javanet/"+nomInterface+".fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
    public void addCardToScrollPaneFilmsRom(ObservableList<Film> films) {
        try {
            for (Film f : films) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                FilmItemController studentItemController = loader.getController();
                studentItemController.setData(f);

                // Add the StudentItem to the VBox
                hBoxScrollFilmRom.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneSeriesRom(ObservableList<Serie> series) {
        try {
            for (Serie s : series) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/serie.fxml"));
                Node node = loader.load();
              /*  FileChooser fc=new FileChooser();
                fc.showOpenDialog(null).getPath();
            File f =new File("C:\\Users\\alila\\OneDrive\\Bureau\\alilahbib\\Main.jpg");
                Files.copy(fc.showOpenDialog(null).getPath(),"src/ressources/copy.jpg");*/
                // Set the data of the corresponding StudentItemController
                SerieItemController studentItemController = loader.getController();
                studentItemController.setData(s);

                // Add the StudentItem to the VBox
                hBoxScrollSerieRom.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneSeriesAction(ObservableList<Serie> series) {
        try {
            for (Serie s : series) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/serie.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                SerieItemController studentItemController = loader.getController();
                studentItemController.setData(s);

                // Add the StudentItem to the VBox
                hBoxScrollSerieAction.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneFilmsAction(ObservableList<Film> films) {
        try {
            for (Film f : films) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                FilmItemController studentItemController = loader.getController();
                studentItemController.setData(f);

                // Add the StudentItem to the VBox
                hBoxScrollFilmAction.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneFilmsCom(ObservableList<Film> films) {
        try {
            for (Film f : films) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                FilmItemController studentItemController = loader.getController();
                studentItemController.setData(f);

                // Add the StudentItem to the VBox
                hBoxScrollFilmCom.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneSeriesComedie(ObservableList<Serie> series) {
        try {
            for (Serie s : series) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/serie.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                SerieItemController studentItemController = loader.getController();
                studentItemController.setData(s);

                // Add the StudentItem to the VBox
                hBoxScrollSerieComedie.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneFilmsDrama(ObservableList<Film> films) {
        try {
            for (Film f : films) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                FilmItemController studentItemController = loader.getController();
                studentItemController.setData(f);

                // Add the StudentItem to the VBox
                hBoxScrollFilmDrama.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneSeriesDrama(ObservableList<Serie> series) {
        try {
            for (Serie s : series) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/serie.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                SerieItemController studentItemController = loader.getController();
                studentItemController.setData(s);

                // Add the StudentItem to the VBox
                hBoxScrollSerieDrama.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneFilmsHis(ObservableList<Film> films) {
        try {
            for (Film f : films) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                FilmItemController studentItemController = loader.getController();
                studentItemController.setData(f);

                // Add the StudentItem to the VBox
                hBoxScrollFilmHis.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneSeriesHis(ObservableList<Serie> series) {
        try {
            for (Serie s : series) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/serie.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                SerieItemController studentItemController = loader.getController();
                studentItemController.setData(s);

                // Add the StudentItem to the VBox
                hBoxScrollSerieHis.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneFilmsPol(ObservableList<Film> films) {
        try {
            for (Film f : films) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                FilmItemController studentItemController = loader.getController();
                studentItemController.setData(f);

                // Add the StudentItem to the VBox
                hBoxScrollFilmPoli.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneSeriesPol(ObservableList<Serie> series) {
        try {
            for (Serie s : series) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/serie.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                SerieItemController studentItemController = loader.getController();
                studentItemController.setData(s);

                // Add the StudentItem to the VBox
                hBoxScrollSeriePol.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneFilmsScFi(ObservableList<Film> films) {
        try {
            for (Film f : films) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/film.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                FilmItemController studentItemController = loader.getController();
                studentItemController.setData(f);

                // Add the StudentItem to the VBox
                hBoxScrollFilmScFi.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCardToScrollPaneSeriesScFi(ObservableList<Serie> series) {
        try {
            for (Serie s : series) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/serie.fxml"));
                Node node = loader.load();

                // Set the data of the corresponding StudentItemController
                SerieItemController studentItemController = loader.getController();
                studentItemController.setData(s);

                // Add the StudentItem to the VBox
                hBoxScrollSerieScFi.getChildren().add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*public  void afficherDetailsSerie(Node node){
        VboxToChange.getChildren().clear();
        VboxToChange.getChildren().add(node);
    }*/

    /*public void deleteNode(int hashcode, String titre) throws SQLException {
        // Remove the Node with the given hashcode from the VBox
        filmVbox.getChildren().removeIf(e -> e.hashCode() == hashcode);

        // Delete the corresponding student from the database
        ServiceFilm.deleteFilm(new Film(titre));

    }*/

/*public void note () {
    rating.ratingProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> ob, Number oldV, Number newV) {
    ratinglabel.setText("Rating :"+newV );
        }
    });

}*/



























}
