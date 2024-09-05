package edu.vanier.Class1;
import edu.vanier.ui.OptionStage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javax.swing.text.html.Option;

/**
 * This is a JavaFX project template to be used for creating GUI applications.
 * JavaFX 20.0.2 is already linked to this project in the build.gradle file.
 * @link: https://openjfx.io/javadoc/22/
 * @see: Build Scripts/build.gradle
 * @author Frostybee.
 */
public class MainApp extends Application{

    public static void main(String[] args) {
        System.out.println("Hello there!");
        
//To launch the JFX component of the application, we use LAUNCH
        launch(args);
    }
    @Override
    public void init(){
        System.out.println("Initialization in progress...");
    }

    public void stop(){
        System.out.println("Shutting down application...");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Starting application...");
//At first we must create a scene graph and pass it to the scene
    Group root= new Group();
    //1a. We can now add UI controls to the scene graph
    Button btnSave = new Button("Options");
    root.getChildren().add(btnSave);
    btnSave.setOnAction((event) -> {
        System.out.println("Opening new stage");
        OptionStage stageOptions = new OptionStage(primaryStage, "Options Window");
        stageOptions.show();

    });
    
//Creates an FX scene
    Scene scene = new Scene(root, 300, 300);
//Set the scene to the stage
    primaryStage.setScene(scene);
//Can also set title
    primaryStage.setTitle("JFX TEST");
//Can force top layer
    primaryStage.setAlwaysOnTop(true);
//We must explicitly ask it to show
    primaryStage.show();
        
    }
}
