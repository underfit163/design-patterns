package com.example.templatemethod;

import javafx.scene.layout.Pane;

public interface MyShape {
    Runnable start(Pane canvas, int canvasWidth, int canvasHeight, int speed, double deltaX, double deltaY);
}
