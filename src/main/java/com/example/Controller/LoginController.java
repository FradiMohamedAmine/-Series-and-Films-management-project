package com.example.Controller;
import com.example.DAO.DAO_Compte;
import com.example.Entities.*;
import com.example.Projetjava.HelloApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static com.example.Service.ServiceCompte.ajouterCompte;

//N E W A C C O U N T
public class LoginController implements Initializable {
    public static Personne p;
    public static Utislisateur u;
    @FXML
    private VBox vboxsignup;
    @FXML
    private Button btnsignin;

    @FXML
    private Button btnup;

    @FXML
    private ComboBox<String> combox;
// grg
    /**
     * *
     */
    @FXML
    private Hyperlink link;

    @FXML
    private Hyperlink linkfgtpswd;

    @FXML
    private ImageView logo;

    @FXML
    private  TextField mail;

    @FXML
    private TextField mail1;

    @FXML
    private PasswordField password;

    @FXML
    private  PasswordField pswd;

    @FXML
    private Tab signin;

    @FXML
    private Tab signup;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField username;



    @FXML
    void checkin(ActionEvent event) {
//nsit hedhom winhom
    }

    @FXML
    public void handleUtilisateur() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/kindaDone/hello-view.fxml"));
        Parent loginRoot = loader.load();
        Scene currentScene =btnsignin.getScene();
        currentScene.setRoot(loginRoot);
    }
    public void handleProducteur() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/kindaDone/hello-view-producteurtest.fxml"));
        Parent loginRoot = loader.load();
        Scene currentScene =btnsignin.getScene();
        currentScene.setRoot(loginRoot);
    }


    @FXML
    void fgtpassword(ActionEvent event) throws IOException {
        HelloApplication.setRoot("");//interface ll fgt password , feha ll email  new password
    }

    @FXML
    void gotosignin(ActionEvent event) throws IOException {
        HelloApplication.setRoot("login-view");
    }

    @FXML
    public void signUp(ActionEvent event) throws IOException, SQLException {
        String usernam = username.getText();
        String email = mail1.getText();
        String passwrd = password.getText();
        String type = (String) combox.getValue(); // howa suggested eno naml cast
        //ferghin walle
        if (usernam.isEmpty() || email.isEmpty() || passwrd.isEmpty() || combox.getValue() == null ) {
            showAlert("Please fill in all fields.");
            return;
        }
        // check if email is valid
        if (!isValidEmail(email)) {
            showAlert("Please enter a valid email address.");
            return;
        }
        // check if password is strong enough
        if (!isStrongPassword(passwrd)) {
            showAlert("Please enter a strong password.");
            return;
        }
        if(combox.getValue()==null){
            showAlert("please select an type from the box ");
            return ; }

        // save user information to database or file

        Compte newC = new Compte(email,passwrd ,type);
        Personne newUser = new Personne(usernam,newC);
        if(ajouterCompte(newUser)) {
            showAlert("Account created successfully.");
            this.u=new Utislisateur(usernam,new Compte(email,passwrd,"utilisateur"));
        }
        else showAlert("Account non created .");
        // clear text fields after sign up
        username.clear();
        mail1.clear();
        password.clear();
         /*if(combox.getValue()=="utilisateur") {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/javanet/kindaDone/genre.fxml"));
             GenreController gr =loader.getController();
             Node node = loader.load();
             vboxsignup.getChildren().clear();
             vboxsignup.getChildren().add(node);
         }*/
        gotosignin(event);
    }

    private boolean isValidEmail(String email) {
        // use regular expression to check if email is valid
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean isStrongPassword(String password) {
        // password must be at least 8 characters long and contain a mix of upper and lower case letters, numbers, and symbols
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        return pattern.matcher(password).matches();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setLogo();
        redirectToLoginView();
        combox.setItems(FXCollections.observableArrayList("producteur","utilisateur"));

    }

   /* private void setLogo() {
        logo.setImage(new Image(LOGO, 200, 500, true, true));
    }*/

    @FXML
    private void redirectToLoginView() {
        link.setOnMouseClicked(ev -> {
            tabPane.getSelectionModel().select(0);
        });
    }

    @FXML
    public void switchInterfaces() throws SQLException, IOException {
        Personne personne =connecter();
        if (personne==null)
            HelloApplication.setRoot("login-view");//**** on remplace par l'inerface pour le signup
        else
            switch (personne.getCompte().getType()) {

                case "utilisateur": {
                    handleUtilisateur();
                    // Utislisateur u = new Utislisateur(personne.getNomprenom(),personne.getCompte());
                    // com.example.projetjavanerflix.App.setRoot("+++++");//+++++on remplace par les interface utilisateur

                }
                case "producteur": {
                    handleProducteur();
                }
                Producteur pr = new Producteur(personne.getNomprenom(), personne.getCompte());
                // com.example.projetjavanerflix.App.setRoot("+++++");//+++++on remplace par les interface producteur
                // showAlert(p.toString());}
            }


    }
    @FXML
    private  Personne connecter() throws SQLException, IOException {

        Personne personne=DAO_Compte.get(mail.getText(),pswd.getText());
        p=personne;

        return personne;

    }
    @FXML
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("A  L  E  R  T ");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void dragged(MouseEvent mouseEvent) {
    }


}