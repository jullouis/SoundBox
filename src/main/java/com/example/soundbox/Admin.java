package com.example.soundbox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    @FXML
    protected void addSong() throws IOException {
        FileWriter writer = new FileWriter("songs_db.csv",true);
        writer.append(adminName.getText());
        writer.append(adminYear.getText());
        writer.append(adminMainInterpreter.getText());
        writer.append(adminDuration.getText());
        writer.append(adminFeat.getText());
        writer.append(adminAlbum.getText());
        writer.append(adminPicture.getText());
        writer.append(adminMP3.getText());
        writer.close();
    }
    @FXML
    protected void deleteSong() throws IOException {
        FileWriter writer =  new FileWriter("songs_db.csv",true);
        adminName.setText("");
        adminYear.setText("");
        adminMainInterpreter.setText("");
        adminDuration.setText("");
        adminFeat.setText("");
        adminAlbum.setText("");
        adminPicture.setText("");
        adminMP3.setText("");
        writer.close();
    }
    @FXML
    protected void modSong() {
    }
}
