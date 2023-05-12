package com.jngroup.soundbox;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SoundBoxController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application! Et jsute un test");
    }
}