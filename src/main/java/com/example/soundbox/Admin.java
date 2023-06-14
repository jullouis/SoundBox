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
import static java.awt.Toolkit.resources;

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
    public TextField adminSearch;

    /**
     * This method is for choosing pics files from our disk for the song in the interface.
     */
    @FXML
    protected void ChooserPics() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(src/main/resources/pics);
        if (file != null) {
            Image img = new Image(file.toURI().toString());
            adminPicture.setImage(img);
        }
    }

    /**
     * This method is for choosing the MP3 files from our disk for the song in the interface.
     */
    @FXML
    protected void ChooserSongs() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image img = new Image(file.toURI().toString());
            adminMP3.setImage(img);
        }
    }

    /**
     * This method is used to add the sounds in the lists and in the csv files with all the criteria fields filled.
     */
    @FXML
    protected void addSong() throws IOException {
        FileWriter writer = new FileWriter("data/database/songs_db.csv", true);
        writer.append("\n");
        writer.append("song");
        writer.append(";");
        writer.append(adminName.getText());
        HelloApplication.nameList.add(adminName.getText());
        writer.append(";");
        writer.append(adminAlbum.getText());
        HelloApplication.albumList.add(adminAlbum.getText());
        writer.append(";");
        writer.append(adminYear.getText());
        HelloApplication.yearList.add(adminYear.getText());
        writer.append(";");
        writer.append(adminMainInterpreter.getText());
        HelloApplication.mainInterpreterList.add(adminMainInterpreter.getText());
        writer.append(";");
        writer.append(adminPicture.getImage().getUrl());
        HelloApplication.coverUrlList.add(adminPicture.getImage().getUrl());
        writer.append(";");
        writer.append(adminDuration.getText());
        HelloApplication.durationList.add(adminDuration.getText());
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        //writer.append(adminMP3.getImage().getUrl());   --> we didn't use it
        writer.close();
    }

    /**
     * This method is used to delete the sounds in the lists and in the csv files.
     */
    @FXML
    protected void deleteSong() throws IOException {
        String Value = adminName.getText();
        int index = nameList.indexOf(Value);
        FileWriter writer = new FileWriter("data/database/songs_db.csv", false);
        nameList.remove(index);
        albumList.remove(index);
        yearList.remove(index);
        mainInterpreterList.remove(index);
        coverUrlList.remove(index);
        durationList.remove(index);
        adminName.clear();
        adminDuration.clear();
        adminYear.clear();
        adminMainInterpreter.clear();
        adminAlbum.clear();
        //adminMP3.setImage(null);
        adminPicture.setImage(null);
        int i = 0;
        while (i < nameList.size()){
            writer.append("song");
            writer.append(";");
            writer.append(nameList.get(i));
            writer.append(";");
            writer.append(albumList.get(i));
            writer.append(";");
            writer.append(yearList.get(i));
            writer.append(";");
            writer.append(mainInterpreterList.get(i));
            writer.append(";");
            writer.append(coverUrlList.get(i));
            writer.append(";");
            writer.append(durationList.get(i));
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");//MP3
            writer.append("\n");
            i ++;
        }
        writer.close();
    }

    /**
     * This method is used to modify the sound criteria in the lists and in the csv files.
     */
    @FXML
    protected void modSong() throws IOException {
        String Value = adminName.getText();
        int index = HelloApplication.nameList.indexOf(Value);
        FileWriter writer = new FileWriter("data/database/songs_db.csv", false);
        HelloApplication.albumList.set(index,adminAlbum.getText());
        HelloApplication.yearList.set(index,adminYear.getText());
        HelloApplication.mainInterpreterList.set(index,adminMainInterpreter.getText());
        HelloApplication.coverUrlList.set(index,adminPicture.getImage().getUrl());
        HelloApplication.durationList.set(index,adminDuration.getText());
        int i = 0;
        while (i < nameList.size()){
            writer.append("song");
            writer.append(";");
            writer.append(HelloApplication.nameList.get(i));
            writer.append(";");
            writer.append(HelloApplication.albumList.get(i));
            writer.append(";");
            writer.append(HelloApplication.yearList.get(i));
            writer.append(";");
            writer.append(HelloApplication.mainInterpreterList.get(i));
            writer.append(";");
            writer.append(HelloApplication.coverUrlList.get(i));
            writer.append(";");
            writer.append(HelloApplication.durationList.get(i));
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");//MP3
            writer.append("\n");
            i++;
        }
        writer.close();
    }

    /**
     * This method is for switch to scene.
     */
    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is used to search the song in the list.
     */
    @FXML
    public void search(){
        String searchName = adminSearch.getText();
        int index = nameList.indexOf(searchName);
        if (index != -1) {
            adminName.setText(nameList.get(index));

            adminYear.setText(yearList.get(index));
            adminMainInterpreter.setText(mainInterpreterList.get(index));
            adminDuration.setText(durationList.get(index));
            adminAlbum.setText(albumList.get(index));
            //adminPicture.setImage(coverUrlList.get(index));
        } else {
            adminSearch.setText("Le nom existe pas");
        }
    }
}

