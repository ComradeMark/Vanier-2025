package edu.vanier.DistanceCalculator.controllers;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import edu.vanier.DistanceCalculator.models.PostalCode;
import edu.vanier.DistanceCalculator.tests.Driver;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ui.DistanceStage;

public class distanceFXMLController {
    @FXML
    private Button btnCalculate;
    @FXML
    private TextField originCode;
    @FXML
    private TextField destCode;


    @FXML
    public void initialize(){
        System.out.println("Initializing the distance calculator class controller...");
        btnCalculate.setOnAction(event -> {
            //Add a click event to the calculate button
            String csvPath = String.valueOf(Driver.class.getResource("/data/postalcodes.csv")).substring(6);
            PostalCodeController PCC = new PostalCodeController(csvPath);
            String destination = destCode.getText().substring(0, 3).toUpperCase();
            String from = originCode.getText().substring(0, 3).toUpperCase();
            try {
                PostalCode originPC = PCC.parse(csvPath).get(from);
                PostalCode destPC = PCC.parse(csvPath).get(destination);
                double distance = PCC.distanceTo(originPC, destPC);
                handleAnswer(from, destination, distance);
            }
            catch(NullPointerException e){
               handleWarning();
           }






        });
    }
    private void handleAnswer(String from, String destination, double distance){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Distance between two postal codes");
        alert.setTitle("Calculation result");
        alert.setContentText("The distance between postal code " + from + " and postal code " + destination + " is: " + distance + "m" + ", or " + distance/1000 + "km");
        alert.show();
    }
    private void handleWarning(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Distance between two postal codes");
        alert.setTitle("Calculation error");
        alert.setContentText("Incorrect postal code format. Please try again.");
        alert.show();
    }
}
