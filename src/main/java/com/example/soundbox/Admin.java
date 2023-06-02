package com.example.soundbox;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Admin extends HelloController {
    @FXML
    public Label adminFonction;

    @FXML
    protected void addSong() {
        adminFonction.setText("La musique est ajoutée");
    }
    @FXML
    protected void deleteSong() {
        adminFonction.setText("La musique est supprimée");
    }
    @FXML
    protected void modSong() {
        adminFonction.setText("La musique est modifiée");
    }
}
