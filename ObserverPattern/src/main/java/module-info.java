module com.example.observerpattern {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.observerpattern to javafx.fxml;
    exports com.example.observerpattern;
}