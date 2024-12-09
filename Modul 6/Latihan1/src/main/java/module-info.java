module org.example.latihan1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.latihan1 to javafx.fxml;
    exports org.example.latihan1;
}