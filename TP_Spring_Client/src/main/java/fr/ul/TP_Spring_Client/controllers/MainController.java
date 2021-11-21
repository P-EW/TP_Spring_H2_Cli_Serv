package fr.ul.TP_Spring_Client.controllers;

import fr.ul.TP_Spring_Client.ClientApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    protected void onAddClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("add-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    protected void onModifyClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("modify-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    protected void onSearchClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    protected void onDeleteClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("delete-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}