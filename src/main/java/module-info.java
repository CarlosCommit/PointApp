module com.example.pointapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires commons.dbcp2;
    requires java.sql;
    opens com.myapp.pointapp to javafx.fxml;
    exports com.myapp.pointapp;
}