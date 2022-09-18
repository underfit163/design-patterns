package com.example.mvcchart.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class PointList {
    private final ObservableList<PointXY> pointsX;
    private final ObservableList<XYChart.Data<Number, Number>> pointsChart;

    public PointList() {
        pointsX = FXCollections.observableArrayList();
        pointsChart = FXCollections.observableArrayList();
    }

    public ObservableList<PointXY> getPointsX() {
        return pointsX;
    }

    public ObservableList<XYChart.Data<Number, Number>> getPointsChart() {
        return pointsChart;
    }

    public void addItem(double x) throws DuplicatePointException {
        for (PointXY xy : pointsX) {
            if (xy.getX() == x) throw new DuplicatePointException(x);
        }
        PointXY pointXY = new PointXY(x);
        pointsX.add(pointXY);
        pointsChart.add(new XYChart.Data<>(pointXY.getX(), pointXY.getY()));
    }

    public void updateItem(PointXY pointXY, double x) throws DuplicatePointException {
        for (PointXY xy : pointsX) {
            if (xy.getX() == x) throw new DuplicatePointException(x);
        }
        PointXY point = new PointXY(x);
        int index = pointsX.indexOf(pointXY);
        pointsX.set(index, point);
        pointsChart.set(index, new XYChart.Data<>(point.getX(), point.getY()));
    }

    public void deleteItem(PointXY pointXY) {
        int indexDel = pointsX.indexOf(pointXY);
        pointsX.remove(indexDel);
        pointsChart.remove(indexDel);
    }
}
