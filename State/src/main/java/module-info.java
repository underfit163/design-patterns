module com.example.state {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.state to javafx.fxml;
    exports com.example.state;
}