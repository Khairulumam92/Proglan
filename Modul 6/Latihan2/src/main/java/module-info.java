module org.example.latihan2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.latihan2 to javafx.fxml;
    exports org.example.latihan2;
}