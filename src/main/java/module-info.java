module com.example.soundbox {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.jngroup.soundbox to javafx.fxml;
    exports com.jngroup.soundbox;
}