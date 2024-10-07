package edu.vanier.DistanceCalculator.controllers;

import edu.vanier.DistanceCalculator.models.PostalCode;
import edu.vanier.DistanceCalculator.tests.Driver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;

public class nearbyFXMLController {
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private TextField originBox;

    @FXML
    private TextArea textArea;
    @FXML
    private Button findBtn;
    public void initialize(){
        System.out.println("Initializing the nearby postal codes class controller...");
        String csvPath = String.valueOf(Driver.class.getResource("/data/postalcodes.csv")).substring(6);
        StringBuilder fin = new StringBuilder();
        choiceBox.getItems().add(5.0);
        choiceBox.getItems().add(10.0);
        choiceBox.getItems().add(25.0);
        choiceBox.getItems().add(50.0);
        choiceBox.getItems().add(100.0);

        findBtn.setOnAction(event -> {
            String origin = "";
            double radius = (double) choiceBox.getValue();
            PostalCodeController PCC = new PostalCodeController(csvPath);
            if(originBox.getText()!=null) {
                 origin = originBox.getText();
            }
            else {
            //throw error about null text
                handleWarning2();
            }
            try {
                PostalCode from = PCC.parse(csvPath).get(origin);
                HashMap<PostalCode, Double> nearbyCodes = PCC.nearbyLocations(from, radius, PCC.parse(csvPath));
                //Set keys = nearbyCodes.keySet();
                List<String> res = new ArrayList<String>();
                nearbyCodes.forEach((key, val) -> {
                    res.add((String.valueOf(key.getId())) + "," + String.valueOf(val) + "\n");
                });

                System.out.println(res);
                for(int i = 0; i<res.size(); i++){
                    fin.append(res.get(i));
                }
                textArea.setText(fin.toString());



            } catch (NullPointerException exception){
                handleWarning2();
            }
            //Calculates distance from origin to all points in database. If a point falls within radius, it is added

        });


    }



    private void handleWarning(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Postal codes within radius");
        alert.setTitle("No postal codes found");
        alert.setContentText("No postal codes were found within the selected radius. Please try again.");
        alert.show();
    }
    private void handleWarning2(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Invalid postal code format");
        alert.setTitle("Postal code format error");
        alert.setContentText("Invalid postal code format. Please try again.");
        alert.show();
    }
}








