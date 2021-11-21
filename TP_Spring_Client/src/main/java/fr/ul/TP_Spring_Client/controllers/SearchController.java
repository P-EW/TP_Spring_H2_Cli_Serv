package fr.ul.TP_Spring_Client.controllers;

import fr.ul.TP_Spring_Client.ClientApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchController {

    @FXML private TextField search;
    @FXML private TextArea response;


    @FXML
    protected void onCancelClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    protected void onSearchClick() throws IOException {
        URL url = new URL("http://localhost:8080/films/");

        String input = search.getText().trim();
        if(input.length() != 0){
            if(input.matches("^[0-9]*$")){
                // id case
                url = new URL("http://localhost:8080/film/"+input);
            }
            else {
                // title case
                url = new URL("http://localhost:8080/films/"+input.replaceAll(" ","%20"));
            }
        }

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("accept", "application/json");

        InputStream inputStream = con.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
        response.setText(mapper.readTree(new String(inputStream.readAllBytes())).toPrettyString());
    }
}
