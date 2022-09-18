module com.tay.trafficlight {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.tay.trafficlight to javafx.fxml;
    exports com.tay.trafficlight;
}