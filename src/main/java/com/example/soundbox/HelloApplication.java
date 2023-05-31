package com.example.soundbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("SoundBox limited");
        stage.setScene(scene);
        stage.show();

        FXMLLoader adminLoader;
        adminLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        Scene adminScene = new Scene(adminLoader.load(), 800, 600);
        stage.setTitle("SoundBox limited");
        stage.setScene(adminScene);
        stage.show();
    }
    public HelloApplication(){

    }

    public static void main(String[] args) {
        launch();
    }
}