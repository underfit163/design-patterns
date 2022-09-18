package com.example.state;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SadState implements State{
    @Override
    public void handle(ImageView imageView) throws FileNotFoundException {
        imageView.setImage(new Image(new FileInputStream("src/main/resources/com/example/state/sad.jpg")));
    }
}
