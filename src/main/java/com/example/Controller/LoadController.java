package com.example.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadController implements Initializable {
    @FXML
    private WebView webView;
    @FXML
    private TextField textField;

    private WebEngine engine;
    private WebHistory history;
    private String homePage;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        engine = webView.getEngine();
        homePage = "www.youtube.com";
        textField.setText(homePage);
        loadPage();
    }
    public void loadPage() {
        engine.load("https://"+textField.getText());}
    public void refreshPage(ActionEvent actionEvent) {	engine.reload();}

    public void displayHistory(ActionEvent actionEvent) {history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        for(WebHistory.Entry entry : entries) {
            System.out.println(entry.getUrl()+" "+entry.getLastVisitedDate());
        }
    }

    public void back(ActionEvent actionEvent) {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);

        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void forward(ActionEvent actionEvent) {history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);

        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }
}

