package com.tay.trafficlight;

import javafx.animation.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Light {
    private Circle red;
    private Circle yellow;
    private Circle green;
    private Timeline lightTimeline = new Timeline();
    private boolean stopLight = true;

    public Light() {
    }

    public Light(Circle red, Circle yellow, Circle green) {
        this.red = red;
        this.yellow = yellow;
        this.green = green;
    }

    public boolean isStopLight() {
        return stopLight;
    }

    public Circle getRed() {
        return red;
    }

    public void setRed(Circle red) {
        this.red = red;
    }

    public Circle getYellow() {
        return yellow;
    }

    public void setYellow(Circle yellow) {
        this.yellow = yellow;
    }

    public Circle getGreen() {
        return green;
    }

    public void setGreen(Circle green) {
        this.green = green;
    }

    public void changeColorLightOnRed() {
        stopLight = true;
        red.setFill(Color.RED);
        yellow.setFill(Color.BLACK);
        green.setFill(Color.BLACK);
    }

    public void changeColorLightOnYellow() {
        stopLight = false;
        red.setFill(Color.BLACK);
        yellow.setFill(Color.YELLOW);
        green.setFill(Color.BLACK);
    }

    public void changeColorLightOnGreen() {
        stopLight = false;
        red.setFill(Color.BLACK);
        yellow.setFill(Color.BLACK);
        green.setFill(Color.GREEN);
    }

    public void changeLight(double secStart, double duration, Car car) {
        lightTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(secStart += duration),
                actionEvent -> {changeColorLightOnYellow(); car.getCarTimeline().play();}));
        lightTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(secStart += duration),
                actionEvent -> {changeColorLightOnGreen();}));
        lightTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(secStart + duration),
                actionEvent -> {changeColorLightOnRed();}));
        lightTimeline.setCycleCount(Timeline.INDEFINITE);
        lightTimeline.play();
    }


}
