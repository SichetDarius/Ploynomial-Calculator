module com.example.aaaa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aaaa to javafx.fxml;
    exports com.example.aaaa;
    exports com.example.aaaa.controller;
    opens com.example.aaaa.controller to javafx.fxml;
    opens com.example.aaaa.models to javafx.base;
}