package ui;


import edu.vanier.DistanceCalculator.controllers.distanceFXMLController;
import edu.vanier.DistanceCalculator.controllers.nearbyFXMLController;
import edu.vanier.DistanceCalculator.tests.Driver;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NearbyStage extends Stage {
    public NearbyStage() {
        initComponents();
        //initModality(Modality.APPLICATION_MODAL);

    }
    private void initComponents(){
        //Create new stage object
        Stage nearbyStage = new Stage();
        FXMLLoader loader = new FXMLLoader(Driver.class.getResource("/fxml/nearbyLayout.fxml"));
        loader.setController(new nearbyFXMLController());
        try {
            Parent root = (Parent) loader.load();

            //Creates an FX scene
            Scene scene = new Scene(root, 600, 460);
            //Set the scene to the stage
            nearbyStage.setScene(scene);
            nearbyStage.setTitle("Nearby postal codes");
            nearbyStage.setAlwaysOnTop(true);
            nearbyStage.show();




        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

}
