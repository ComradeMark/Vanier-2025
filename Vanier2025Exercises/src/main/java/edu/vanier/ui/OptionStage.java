package edu.vanier.ui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OptionStage extends Stage {

    public OptionStage(Stage owner, String title) {
        this.setTitle(title);
        initOwner(owner);
        initComponents();
        //Makes stage a modal window, forcing user interaction before exit is possible
        initModality(Modality.APPLICATION_MODAL);

    }
    private void initComponents(){
        //Create new stage object
        Stage optionsStage = new Stage();

        //Create a scenegraph for options window
        HBox optionsRoot = new HBox();
        Button btnClose = new Button("Close");
        Button btnSave = new Button("Save");
        btnClose.setOnAction((event) ->{
            close();
        });

        optionsRoot.getChildren().addAll(btnClose, btnSave);
        //Set scenegraph on scene
        Scene optionsScene = new Scene(optionsRoot, 200, 200);
        //Set scene on stage
        setScene(optionsScene);
    }

}
