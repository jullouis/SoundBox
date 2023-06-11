package com.example.soundbox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.soundbox.HelloApplication.*;

public class Admin extends HelloController {
    @FXML
    public TextField adminName;
    public TextField adminYear;
    public TextField adminMainInterpreter;
    public TextField adminDuration;
    public TextField adminAlbum;
    public ImageView adminPicture;
    public ImageView adminMP3;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void ChooserPics() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image img = new Image(file.toURI().toString());
            adminPicture.setImage(img);
        }
    }
    @FXML
    protected void ChooserSongs() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image img = new Image(file.toURI().toString());
            adminMP3.setImage(img);
        }
    }
    @FXML
    protected void addSong() throws IOException {
        FileWriter writer = new FileWriter("data/database/songs_db.csv", true);
        writer.append("\n");
        writer.append("song");
        writer.append(";");
        writer.append(adminName.getText());
        //HelloApplication.nameList.add(adminName.getText());
        writer.append(";");
        writer.append(adminAlbum.getText());
        //HelloApplication.albumList.add(adminAlbum.getText());
        writer.append(";");
        writer.append(adminYear.getText());
        //HelloApplication.yearList.add(adminYear.getText());
        writer.append(";");
        writer.append(adminMainInterpreter.getText());
        //HelloApplication.mainInterpreterList.add(adminMainInterpreter.getText());
        writer.append(";");
        writer.append(adminPicture.getImage().getUrl());
        //HelloApplication.coverUrlList.add(adminPicture.getImage().getUrl());
        writer.append(";");
        writer.append(adminDuration.getText());
        //HelloApplication.durationList.add(adminDuration.getText());
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append(adminMP3.getImage().getUrl());
        writer.close();


    }
    @FXML
    protected void deleteSong() throws IOException {
        FileWriter writer = new FileWriter("data/database/songs_db.csv", false);
        writer.append("");
        HelloApplication.nameList.remove(index);
        HelloApplication.albumList.remove(index);
        HelloApplication.yearList.remove(index);
        HelloApplication.mainInterpreterList.remove(index);
        HelloApplication.coverUrlList.remove(index);
        HelloApplication.durationList.remove(index);
        writer.close();
        FileWriter writer1 = new FileWriter("data/database/songs_db.csv", true);
        int i = -1;
        while (i<= nameList.size()){
            i ++;
            writer1.append("song");
            writer1.append(";");
            writer1.append(HelloApplication.nameList.get(i));
            writer1.append(";");
            writer1.append(HelloApplication.albumList.get(i));
            writer1.append(";");
            writer1.append(HelloApplication.yearList.get(i));
            writer1.append(";");
            writer1.append(HelloApplication.mainInterpreterList.get(i));
            writer1.append(";");
            writer1.append(HelloApplication.coverUrlList.get(i);
            writer1.append(";");
            writer1.append(HelloApplication.durationList.get(i));
            writer1.append(";");
            writer1.append("");
            writer1.append(";");
            writer1.append("");
            writer1.append(";");
            writer1.append("");
            writer1.append(";");
            writer1.append("adminMP3");
            writer1.append("\n");
            writer1.close();
        }
    }
    @FXML
    protected void modSong() throws IOException {
        FileWriter writer = new FileWriter("data/database/songs_db.csv", false);
        writer.append("");
        HelloApplication.nameList.set(index,adminName.getText());
        HelloApplication.albumList.set(index,adminAlbum.getText());
        HelloApplication.yearList.set(index,adminYear);
        HelloApplication.mainInterpreterList.set(index,adminMainInterpreter);
        HelloApplication.coverUrlList.set(index,adminPicture);
        HelloApplication.durationList.set(index,adminDuration);
        writer.close();
        FileWriter writer1 = new FileWriter("data/database/songs_db.csv", true);
        int i = -1;
        while (i<= nameList.size()){
            i++;
            writer1.append("song");
            writer1.append(";");
            writer1.append(HelloApplication.nameList.get(i));
            writer1.append(";");
            writer1.append(HelloApplication.albumList.get(i));
            writer1.append(";");
            writer1.append(HelloApplication.yearList.get(i));
            writer1.append(";");
            writer1.append(HelloApplication.mainInterpreterList.get(i));
            writer1.append(";");
            writer1.append(HelloApplication.coverUrlList.get(i);
            writer1.append(";");
            writer1.append(HelloApplication.durationList.get(i));
            writer1.append(";");
            writer1.append("");
            writer1.append(";");
            writer1.append("");
            writer1.append(";");
            writer1.append("");
            writer1.append(";");
            writer1.append("adminMP3");
            writer1.append("\n");
            writer1.close();
        }

    }

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

