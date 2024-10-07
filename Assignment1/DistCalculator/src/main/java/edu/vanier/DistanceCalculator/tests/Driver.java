package edu.vanier.DistanceCalculator.tests;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import edu.vanier.DistanceCalculator.controllers.DriverFXMLController;
import edu.vanier.DistanceCalculator.controllers.PostalCodeController;
import edu.vanier.DistanceCalculator.models.PostalCode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.*;
import static javafx.application.Application.*;



public class Driver extends Application {

    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Welcome! How would you like to proceed? ");
        String csvPath = String.valueOf(Driver.class.getResource("/data/postalcodes.csv")).substring(6);

        //Double radius = 35.0;
        PostalCodeController PCC = new PostalCodeController(csvPath);
       // String from = "H4G";
       // testNearbyLocations(PCC, from, csvPath, radius);
        launch(args);
        /*
        System.out.println("1 - Calculate distance between two canadian postal codes ");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                PostalCodeController PCC = new PostalCodeController(csvPath);
                testParse(PCC, csvPath);
                System.out.println("Input origin postal code: ");
                String origin = input.next();
                testDistanceTo(PCC, origin, csvPath);
            case 2:*/
        }




  static void testParse(PostalCodeController PCC, String csvPath)  {
      HashMap<String, PostalCode> codeMap = PCC.parse(csvPath);
      System.out.println("Successfully parsed CSV file. Detected entries: " + codeMap.size() + " of 1619");

 }

 static void testDistanceTo(PostalCodeController PCC, String from, String csvPath){
        Scanner input = new Scanner(System.in);
     System.out.println("Input destination postal code: ");
     String destination = input.next();
     PostalCode originPC = PCC.parse(csvPath).get(from);
     PostalCode destPC = PCC.parse(csvPath).get(destination);
     double distance = PCC.distanceTo(originPC, destPC);
     System.out.println("Distance between postal code " + from + " to " + destination + " is: " + distance + " m.");






 }
 static void testNearbyLocations(PostalCodeController PCC, String from, String csvPath, double radius){
    PostalCode originPC = PCC.parse(csvPath).get(from);
    PCC.nearbyLocations(originPC, radius, PCC.parse(csvPath));

 }

    public void start(Stage primaryStage) throws Exception {

        //FXML Step 1: load fxml document from the FXML file
        FXMLLoader loader = new FXMLLoader(Driver.class.getResource("/fxml/mainLayout.fxml"));
        //FXML Step 2: Set the FXML Java controller
        loader.setController(new DriverFXMLController());
        //FXML Step 3: Retrieve root node from the loaded hierarchy
        Parent root = (Parent) loader.load();


        //Creates an FX scene
        Scene scene = new Scene(root, 600, 460);
//Set the scene to the stage
        primaryStage.setScene(scene);
//Can also set title
        primaryStage.setTitle("Postal Code Tool 2024");
//Can force top layer
        primaryStage.setAlwaysOnTop(false);
//We must explicitly ask it to show
        primaryStage.show();



    }
}




