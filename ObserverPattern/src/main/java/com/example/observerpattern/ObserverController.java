package com.example.observerpattern;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ObserverController {
    @FXML
    public ImageView leftEye;
    public ImageView rightEye;
    public ImageView nose;
    public ImageView mouth;

    private boolean lE, rE, n, m;

    public void onLeftEyeClicked(MouseEvent mouseEvent) throws FileNotFoundException {
        if (lE) {
            lE = false;
            leftEye.setImage(new Image(new FileInputStream("src/main/resources/com/example/observerpattern/leye-open.png")));
        } else {
            lE = true;
            leftEye.setImage(new Image(new FileInputStream("src/main/resources/com/example/observerpattern/leye-closed.png")));
        }
    }

    public void onRightEyeClicked(MouseEvent mouseEvent) throws FileNotFoundException {
        if (rE) {
            rE = false;
            rightEye.setImage(new Image(new FileInputStream("src/main/resources/com/example/observerpattern/reye-open.png")));
        } else {
            rE = true;
            rightEye.setImage(new Image(new FileInputStream("src/main/resources/com/example/observerpattern/reye-closed.png")));
        }
    }

    public void onNoseClicked(MouseEvent mouseEvent) throws FileNotFoundException {
        if (n) {
            n = false;
            nose.setImage(new Image(new FileInputStream("src/main/resources/com/example/observerpattern/nose-normal.png")));
        } else {
            n = true;
            nose.setImage(new Image(new FileInputStream("src/main/resources/com/example/observerpattern/nose-red.png")));
        }
    }

    public void onMouthClicked(MouseEvent mouseEvent) throws FileNotFoundException {
        if (m) {
            m = false;
            mouth.setImage(new Image(new FileInputStream("src/main/resources/com/example/observerpattern/mouth-normal.jpg")));
        } else {
            m = true;
            mouth.setImage(new Image(new FileInputStream("src/main/resources/com/example/observerpattern/mouth-smile.jpg")));
        }
    }
}