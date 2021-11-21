module fr.ul.TP_Spring_Client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.json;
    requires com.fasterxml.jackson.databind;

    opens fr.ul.TP_Spring_Client to javafx.fxml;
    exports fr.ul.TP_Spring_Client;
    exports fr.ul.TP_Spring_Client.controllers;
    opens fr.ul.TP_Spring_Client.controllers to javafx.fxml;
}
