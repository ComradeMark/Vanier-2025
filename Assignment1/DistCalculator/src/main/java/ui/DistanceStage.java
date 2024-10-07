package ui;

import edu.vanier.DistanceCalculator.controllers.DriverFXMLController;
import edu.vanier.DistanceCalculator.controllers.distanceFXMLController;
import edu.vanier.DistanceCalculator.tests.Driver;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DistanceStage extends Stage{
    public DistanceStage() {
        initComponents();
        initModality(Modality.APPLICATION_MODAL);

    }
    private void initComponents(){
        //Create new stage object
        Stage distanceStage = new Stage();
        FXMLLoader loader = new FXMLLoader(Driver.class.getResource("/fxml/distanceLayout.fxml"));
        loader.setController(new distanceFXMLController());
        try {
            Parent root = (Parent) loader.load();

            //Creates an FX scene
            Scene scene = new Scene(root, 600, 460);
            //Set the scene to the stage
            distanceStage.setScene(scene);
            distanceStage.setTitle("Distance between two postal codes");
            distanceStage.setAlwaysOnTop(true);
            distanceStage.show();




        }
  catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

}
