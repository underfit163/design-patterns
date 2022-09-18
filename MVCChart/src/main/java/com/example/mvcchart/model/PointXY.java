package com.example.mvcchart.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class PointXY {
    private DoubleProperty x;
    private DoubleProperty y;

    public PointXY(double x) {
        this.x = new SimpleDoubleProperty();
        this.y = new SimpleDoubleProperty();
        /*getXProperty().addListener((observableValue, number, t1) ->
                y.set(Function.getInstance().getY(t1.doubleValue())));
        this.x.set(x);*/
        setX(x);
    }

    public double getX() {
        return x.get();
    }

    public void setX(double x) {
        this.x.set(x);
        this.y.set(Function.getInstance().getY(getX()));
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty getXProperty() {
        return x;
    }

    public DoubleProperty getYProperty() {
        return y;
    }
}
