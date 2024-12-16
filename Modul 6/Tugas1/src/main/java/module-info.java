module org.example.tugas1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.tugas1 to javafx.fxml;
    exports org.example.tugas1;
}