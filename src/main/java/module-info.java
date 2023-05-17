module com.example.courseanswering1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires rt;


    opens com.example.courseanswering to javafx.fxml;
    exports com.example.courseanswering;
    exports com.example.courseanswering.Controller;
    opens com.example.courseanswering.Controller to javafx.fxml;
}