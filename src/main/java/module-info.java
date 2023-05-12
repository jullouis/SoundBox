module com.example.soundbox {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.soundbox to javafx.fxml;
    exports com.example.soundbox;
}