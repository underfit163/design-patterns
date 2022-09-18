package com.example.templatemethod;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class TimelineCreator {
    public TimelineCreator(Shape shape, int canvasWidth, int canvasHeight, int speed, double deltaX, double deltaY) {
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(speed),
                new EventHandler<>() {

                    double dx = deltaX;
                    double dy = deltaY;

                    @Override
                    public void handle(ActionEvent t) {
                        shape.setLayoutX(shape.getLayoutX() + dx);
                        shape.setLayoutY(shape.getLayoutY() + dy);

                        if (shape.getLayoutX() <= 0 || shape.getLayoutX() >= canvasWidth) {
                            dx = -dx;
                        }

                        if (shape.getLayoutY() >= canvasHeight || shape.getLayoutY() <= 0) {
                            dy = -dy;
                        }
                    }
                }));

        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
    }
}
