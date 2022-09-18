package com.example.templatemethod;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball implements MyShape {
    private static final int RADIUS = 15;

    @Override
    public Runnable start(Pane canvas, int canvasWidth, int canvasHeight, int speed, double deltaX, double deltaY) {

        Circle ball = new Circle(RADIUS, Color.CADETBLUE);
        ball.relocate(canvasWidth - RADIUS * 2, canvasHeight - RADIUS * 2);

        canvas.getChildren().add(ball);

        new TimelineCreator(ball, canvasWidth, canvasHeight, speed, deltaX, deltaY);

        return null;
    }
}
