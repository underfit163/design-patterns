package com.tay.trafficlight;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class TrafficController {
    public Circle redLight;
    public Circle yellowLight;
    public Circle greenLight;
    public Pane roadPane;
    public Line stopLine;
    public Button startButton;

    private Light light;
    private Car car;

    public void startCar(ActionEvent actionEvent) {
        carRoad();
        startButton.setDisable(true);
    }

    public void carRoad() {
        if (light == null) {
            car = new Car();
            light = new Light(redLight, yellowLight, greenLight);
            light.changeLight(0, 3, car);
        }
        car.roadCarT(roadPane, stopLine, light);
    }
}
