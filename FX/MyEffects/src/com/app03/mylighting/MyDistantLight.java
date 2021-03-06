/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app03.mylighting;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyDistantLight extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Light.Distant distant = new Light.Distant();
        distant.setAzimuth(45);
        distant.setElevation(90);
       
        Lighting lighting = new Lighting(distant);
        lighting.setSurfaceScale(5);
        
        Text text = new Text(150, 150, "This is text");
        text.setFont(Font.font("Verbana", FontWeight.BOLD, 40));
        text.setEffect(lighting);
        root.getChildren().add(text);
        //root.setEffect(shadow);

        Rectangle rectangle = new Rectangle(10, 10, 100, 100);
        rectangle.setFill(Color.GREEN);
        rectangle.setEffect(lighting);
        root.getChildren().add(rectangle);

        Rectangle rectangle2 = new Rectangle(120, 10, 100, 100);
        rectangle2.setFill(Color.GREEN);
        root.getChildren().add(rectangle2);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
