module com.example.templatemethod {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.templatemethod to javafx.fxml;
    exports com.example.templatemethod;
}