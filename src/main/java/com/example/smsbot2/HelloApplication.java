package com.example.smsbot2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    SMS_Blaster stormtrooper = new SMS_Blaster();

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("SMS BLASTER ");
        //FileChooser fileChooser = new FileChooser();
        TextField messageText = new TextField("title text here");

        Button btn = new Button();
        btn.setText("Load File");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("loading the sms blaster");
                stormtrooper.load();
            }
        });

        Button trigger = new Button();
        trigger.setText("Send Message");
        trigger.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("shooting messages ");
                stormtrooper.CSV_parseAndSend();
            }
        });

        Button edit = new Button();
        edit.setText("Set Message");
        edit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("changing message text");
                stormtrooper.setMessage(messageText.getText());
            }
        });


        StackPane root = new StackPane();
        HBox buttonBarPane = new HBox();
        buttonBarPane.setPadding(new Insets(5, 4, 5, 4));
        buttonBarPane.setSpacing(10);
        buttonBarPane.getChildren().addAll(btn,trigger,edit);
        root.setBackground(new Background(new BackgroundFill(Color.valueOf("21252BFF"), CornerRadii.EMPTY,Insets.EMPTY))); //Lightmo
        root.getChildren().add(buttonBarPane);
        root.getChildren().add(messageText);
        primaryStage.setScene(new Scene(root, 350, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}