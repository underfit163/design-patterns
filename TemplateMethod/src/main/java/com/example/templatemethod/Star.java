package com.example.templatemethod;

import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Star implements MyShape {
    @Override
    public Runnable start(Pane canvas, int canvasWidth, int canvasHeight, int speed, double deltaX, double deltaY) {
        Path star = new Path();

        //Звезда
        MoveTo moveTo = new MoveTo(10, 7);
        LineTo line1 = new LineTo(32, 16);
        LineTo line2 = new LineTo(12, 23);
        LineTo line3 = new LineTo(23, 5);
        LineTo line4 = new LineTo(26, 25);
        LineTo line5 = new LineTo(10, 7);

        star.getElements().add(moveTo);
        star.getElements().addAll(line1, line2, line3, line4, line5);

        star.relocate(canvasWidth - 5, canvasHeight - 5);

        canvas.getChildren().add(star);

        new TimelineCreator(star, canvasWidth, canvasHeight, speed, deltaX, deltaY);
        return null;
    }
}
