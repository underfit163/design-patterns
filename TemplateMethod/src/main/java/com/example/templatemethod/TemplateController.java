package com.example.templatemethod;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class TemplateController {

    public Pane canvas;
    public Button ballBtn;
    public Button squareBtn;
    public Button starBtn;

    private static int WIDTH = 800;
    private static int HEIGHT = 700;
    private static int SPEED = 20;
    private static int DX = -4;
    private static int DY = 7;


    @FXML
    private void initialize() {
        ballBtn.setOnAction(e -> {
            Platform.runLater(() -> {
                MyShape ball = new Ball();
                Thread threadBall = new Thread(ball.start(canvas, WIDTH, HEIGHT, SPEED, DX, DY));
                threadBall.start();
            });
        });

        squareBtn.setOnAction(e -> {
            Platform.runLater(() -> {
                MyShape square = new Square();
                Thread threadSquare = new Thread(square.start(canvas, WIDTH, HEIGHT, SPEED, DX, DY));
                threadSquare.start();
            });
        });

        starBtn.setOnAction(e -> {
            Platform.runLater(() -> {
                MyShape star = new Star();
                Thread threadStar = new Thread(star.start(canvas, WIDTH, HEIGHT, SPEED, DX, DY));
                threadStar.start();
            });
        });
    }
}