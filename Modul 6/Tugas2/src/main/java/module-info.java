module org.example.tugas2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.tugas2 to javafx.fxml;
    exports org.example.tugas2;
}