module com.example.soundbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.soundbox to javafx.fxml;
    exports com.example.soundbox;
    exports ViewSoundBox;
    opens ViewSoundBox to javafx.fxml;
    exports ApplicationSoundBox.PeopleSoundbox;
    opens ApplicationSoundBox.PeopleSoundbox to javafx.fxml;
    exports ControllerSoundBox;
    opens ControllerSoundBox to javafx.fxml;
}