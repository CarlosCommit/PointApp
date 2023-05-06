module com.example.pointapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.myapp.pointapp to javafx.fxml;
    exports com.myapp.pointapp;
}