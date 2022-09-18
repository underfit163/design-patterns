package com.tay.trafficlight;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Car {
    private Image carImage = new Image(String.valueOf(getClass().getResource("carBlack.jpg")), 100, 100, false, true);
    private ImageView imageView = new ImageView(carImage);
    private Timeline carTimeline = new Timeline();

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageCar(Image carImage) {
        this.carImage = carImage;
        imageView.setImage(carImage);
    }

    public Timeline getCarTimeline() {
        return carTimeline;
    }

    /*public Runnable roadCar(Pane road, Line stopLine, Light light) {
        road.getChildren().add(imageView);
        imageView.setX(imageView.getX() - carImage.getWidth());
        Runnable r = () -> {
            while (true) {
                while (imageView.getX() < road.getWidth() - carImage.getWidth()) {
                    while (stopLine.getLayoutX() == (imageView.getX() + carImage.getWidth() / 2) && light.isStopLight()) {
                        imageView.setX(imageView.getX());
                    }
                    imageView.setX(imageView.getX() + 1);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                imageView.setX(0 - carImage.getWidth());
            }
        };
        return r;
    }*/


    public void roadCarT(Pane road, Line stopLine, Light light) {
        road.getChildren().add(imageView);
        imageView.setX(imageView.getX() - carImage.getWidth());
        carTimeline.getKeyFrames().addAll(new KeyFrame(Duration.seconds(2),
                        actionEvent -> {
                            if (stopLine.getLayoutX() == (imageView.getX() + carImage.getWidth() / 2) && light.isStopLight()) {
                                carTimeline.pause();
                            }
                        }, new KeyValue(imageView.xProperty(), stopLine.getLayoutX() - carImage.getWidth()/2)),
                new KeyFrame(Duration.millis(3000), new KeyValue(imageView.xProperty(), road.getWidth())));
        carTimeline.setCycleCount(Timeline.INDEFINITE);
        carTimeline.play();
    }
}
