package edu.vanier.template;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.security.Key;

public class MainApp extends Application {

    public static void main(String[] args) {
        System.out.println("Hello there!");
        launch(args);
    }
    //Must be declared as a class-wide member to be visible in stop method
    Timeline timelineAnimation;
    Circle circle;
    Rectangle rectangle;
    double rectPos = 200;
    double multiplier = 0.015f;
    double radius = 30.0f;
    @Override
    public void start(Stage primaryStage) throws Exception {
        circle = new Circle(70, 70, 70, Color.BLUE);
        rectangle = new Rectangle(60, 40, Color.ORANGE);
        rectangle.setX(rectPos);
        rectangle.setY(300);
        circle.setRadius(radius);


        //Create a timeline animation
        EventHandler<ActionEvent> onFinished = this::handleOnFinished;
        //KeyFrame kf = new KeyFrame(Duration.millis(20), onFinished);
        timelineAnimation = new Timeline();
        //Keyframe for updating properties of
        //the blue circle
        KeyFrame kf1 = new KeyFrame(
                Duration.millis(500),
                onFinished,
                new KeyValue(circle.centerXProperty(), 375.0d),
                new KeyValue(circle.centerYProperty(), 180.0d),
                new KeyValue(rectangle.yProperty(), rectPos+2));
        KeyFrame kf2 = new KeyFrame(
                Duration.millis(1000),
                new KeyValue(rectangle.arcHeightProperty(), 30.0d),
                new KeyValue(rectangle.arcWidthProperty(), 10.0d),
                new KeyValue(rectangle.xProperty(), 350),
                new KeyValue(rectangle.scaleXProperty(), 2.0d, Interpolator.EASE_IN),
                new KeyValue(rectangle.fillProperty(), Color.CRIMSON),
                new KeyValue(rectangle.fillProperty(), Color.BLUE),
                new KeyValue(rectangle.fillProperty(), Color.ORANGE),
                new KeyValue(rectangle.rotateProperty(), 7203.3d));



        //timelineAnimation.getKeyFrames().add(kf);
        timelineAnimation.getKeyFrames().addAll(kf1, kf2);
        //Configure animation settings
        timelineAnimation.setAutoReverse(false);
        timelineAnimation.setCycleCount(Animation.INDEFINITE);
        timelineAnimation.play();


        //1 - Create scene graph which contains a pane that contains a circle/rectangle node
        Pane root = new Pane();
        root.getChildren().addAll(circle, rectangle);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(false);
    }
    @Override
    public void stop(){
        //Perform teardown tasks
        //Stop running animations
         if(timelineAnimation!=null){
             timelineAnimation.stop();
         }

    }
    private void handleOnFinished(ActionEvent event){
        //Update multiple node properties
        //Scale, translate the circle
        double x = circle.getCenterX();
        double y = circle.getCenterY();
       double x1 = rectangle.getX();
       double y1 = rectangle.getY();
       if(x1 >= 150){
           rectangle.setFill(Color.CRIMSON);
       }
       if(y1 < 500){
           rectangle.setFill(Color.CORAL);
       }
        //Execute some logic
        System.out.println("Handling the end of keyframe cycle...");
    }
}
