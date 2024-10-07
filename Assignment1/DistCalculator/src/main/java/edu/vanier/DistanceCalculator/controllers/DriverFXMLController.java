package edu.vanier.DistanceCalculator.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import ui.DistanceStage;
import ui.NearbyStage;

public class DriverFXMLController {

    @FXML
    private Button btnDistance;
    @FXML
    private Button btnNearby;

    @FXML
    public void initialize(){
        System.out.println("Initializing the Driver class controller...");
        btnDistance.setOnAction(event -> {
            //Add a click event to the confirm button
            System.out.println("Selected distance calculation option...");
            //Opens new window for user input
            DistanceStage distanceStage = new DistanceStage();
        btnNearby.setOnAction(event1 -> {
            //Add a click event to the confirm button
            System.out.println("Selected nearby calculation option...");
            //Opens new window for user input
            NearbyStage nearbyStage = new NearbyStage();
        });

        });
    }
    //Other way of declaring event




}
