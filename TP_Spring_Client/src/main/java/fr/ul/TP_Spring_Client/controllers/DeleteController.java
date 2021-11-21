package fr.ul.TP_Spring_Client.controllers;

import fr.ul.TP_Spring_Client.ClientApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteController {

    @FXML private TextField id;

    @FXML
    protected void onCancelClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    protected void onDeleteClick() throws IOException {
        URL url = new URL("http://localhost:8080/film/"+id.getText());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        try {
            con.getInputStream();
        } catch (Exception e) {
            //WARNING : READER DISCRETION ADVISED
            id.setText("Ce Film n'existe pas.");
        }
    }
}
