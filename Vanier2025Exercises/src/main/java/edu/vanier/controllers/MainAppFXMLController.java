package edu.vanier.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class MainAppFXMLController {
    @FXML
    //for each element, this must be declared with exactly the same name in the controller:
    private Button btnConfirm;
    @FXML
    private Button btnWarning;
    @FXML
    private Button btnError;


    @FXML
    public void initialize(){
        System.out.println("Initializing the MainApp controller...");
        btnConfirm.setOnAction(event -> {
            //Add a click event to the confirm button
            System.out.println("Confirmation in progress...");
        });
        btnWarning.setOnAction(this::handleWarning);
    }
    //Other way of declaring event
    private void handleWarning(Event event){
        System.out.println("Showing warning...");
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("AMONG US CREDIT CARD ALERT");
        alert.setTitle("AMOGUS ERROR");
        alert.setContentText("You must insert credit card number immediately to satisfy the amogus gods");
        alert.show();
    }


}
