package com.example.templatemethod;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square implements MyShape{
    @Override
    public Runnable start(Pane canvas, int canvasWidth, int canvasHeight, int speed, double deltaX, double deltaY) {
        Rectangle square = new Rectangle(40, 40, Color.YELLOW);
        square.relocate(canvasWidth - 5, canvasHeight - 5);

        canvas.getChildren().add(square);

        new TimelineCreator(square, canvasWidth, canvasHeight, speed, deltaX, deltaY);

        return null;
    }
}
