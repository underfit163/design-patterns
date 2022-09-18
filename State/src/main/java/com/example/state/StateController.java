package com.example.state;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class StateController {

    public Button sleepBtn;
    public Button happyBtn;
    public Button sadBtn;
    public ImageView imageView;

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void onSleepButtonClick(ActionEvent actionEvent) throws FileNotFoundException {
        setState(new SleepState());
        state.handle(imageView);
    }

    public void onHappyButtonClick(ActionEvent actionEvent) throws FileNotFoundException {
        setState(new HappyState());
        state.handle(imageView);
    }

    public void onSadButtonClick(ActionEvent actionEvent) throws FileNotFoundException {
        setState(new SadState());
        state.handle(imageView);
    }
}