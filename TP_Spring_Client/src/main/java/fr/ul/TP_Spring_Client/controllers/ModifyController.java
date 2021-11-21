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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class ModifyController {

    @FXML private TextField id;
    @FXML private TextField titre;
    @FXML private TextField synopsis;

    @FXML private TextField search;


    @FXML
    protected void onCancelClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    protected void onSearchClick() throws IOException {
        URL url = new URL("http://localhost:8080/film/"+search.getText());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("accept", "application/json");

        InputStream inputStream = con.getInputStream();

        try {
            JSONObject jsonObject = new JSONObject(new String(inputStream.readAllBytes()));

            id.setText(jsonObject.getInt("id")+"");
            titre.setText(jsonObject.getString("title"));
            synopsis.setText(jsonObject.getString("synopsis"));
        } catch (Exception e) {
            //WARNING : READER DISCRETION ADVISED
            id.setText("Ce Film n'existe pas.");
        }
    }

    @FXML
    protected void onModifierClick() throws IOException {

        StringBuilder jsonInputString = new StringBuilder();
        jsonInputString.append("{ \"id\":\""+id.getText());
        jsonInputString.append("\", \"title\":\""+titre.getText());
        jsonInputString.append("\", \"synopsis\":\""+synopsis.getText()+"\" }");

        URL url = new URL("http://localhost:8080/film");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.toString().getBytes();
            os.write(input, 0, input.length);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        con.getInputStream();
    }
}
