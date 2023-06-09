package com.example.soundbox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Admin extends HelloController {
    @FXML
    public TextField adminName;
    public TextField adminYear;
    public TextField adminMainInterpreter;
    public TextField adminDuration;
    public TextField adminFeat;
    public TextField adminAlbum;
    public Button adminPicture;
    public Button adminMP3;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void addSong() throws IOException {
        FileWriter writer = new FileWriter("data/database/songs_db.csv",true);
        writer.append("\n");
        writer.append("song");
        writer.append(";");
        writer.append(adminName.getText());
        writer.append(";");
        writer.append(adminAlbum.getText());
        writer.append(";");
        writer.append(adminYear.getText());
        writer.append(";");
        writer.append(adminMainInterpreter.getText());
        writer.append(";");
        writer.append(adminPicture.getText());
        writer.append(";");
        writer.append(adminDuration.getText());
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append(adminFeat.getText());
        writer.append(";");
        writer.append(adminMP3.getText());
        writer.close();
    }
    @FXML
    protected void deleteSong() throws IOException {
        FileWriter writer =  new FileWriter("data/database/songs_db.csv",false);
        adminName.setText("");
        adminAlbum.setText("");
        adminYear.setText("");
        adminMainInterpreter.setText("");
        adminPicture.setText("");
        adminDuration.setText("");
        adminFeat.setText("");
        adminMP3.setText("");
        writer.close();
    }
    @FXML
    protected void modSong() {
    }
    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
