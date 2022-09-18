module com.example.mvcchart {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.example.mvcchart to javafx.fxml;
    exports com.example.mvcchart;
    exports com.example.mvcchart.model;
    opens com.example.mvcchart.model to javafx.fxml;
}