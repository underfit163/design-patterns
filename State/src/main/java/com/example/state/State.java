package com.example.state;

import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public interface State {
    void handle(ImageView imageView) throws FileNotFoundException;
}
