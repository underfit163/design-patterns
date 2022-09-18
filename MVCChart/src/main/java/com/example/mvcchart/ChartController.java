package com.example.mvcchart;

import com.example.mvcchart.model.DuplicatePointException;
import com.example.mvcchart.model.Parameters;
import com.example.mvcchart.model.PointList;
import com.example.mvcchart.model.PointXY;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ChartController {

    public LineChart<Number, Number> lineChartXY;
    public TableView<PointXY> tableViewXY;
    public TableColumn<PointXY, Double> tableColumnX;
    public TableColumn<PointXY, Double> tableColumnY;
    public TextField textFieldA;
    public TextField textFieldB;
    public Button addButton;
    public Button updateButton;
    public Button delButton;
    public HBox boxButton;
    public BorderPane mainView;
    private PointList pointList;


    @FXML
    private void initialize() {
        tableColumnX.setSortable(false);
        tableColumnY.setSortable(false);
        pointList = new PointList();
        tableViewXY.setItems(pointList.getPointsX());
        tableColumnX.setCellValueFactory(new PropertyValueFactory<>("x"));
        tableColumnY.setCellValueFactory(new PropertyValueFactory<>("y"));
        tableViewXY.setItems(pointList.getPointsX());

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setData(pointList.getPointsChart());
        lineChartXY.getData().add(series);
    }

    public void addButtonHandler(ActionEvent actionEvent) throws IOException {
        //Создание модального окна
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-modal.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Окно добавления");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(this.mainView.getScene().getWindow());
        stage.showAndWait();

        AddController controller = loader.getController();
        if (controller.isAddResult()) {
            try {
                pointList.addItem(controller.getX());
            } catch (DuplicatePointException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Дубликат аргумента");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    public void updateButtonHandler(ActionEvent actionEvent) throws IOException {
        PointXY pointXY = tableViewXY.getSelectionModel().getSelectedItem();
        if (pointXY != null) {
            //Создание модального окна
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("update-modal.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setTitle("Окно изменения");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(this.mainView.getScene().getWindow());
            UpdateController controller = loader.getController();
            controller.updateTextField.setText(String.valueOf(pointXY.getX()));

            stage.showAndWait();

            if (controller.isUpdateResult()) {
                try {
                    pointList.updateItem(pointXY, controller.getX());
                } catch (DuplicatePointException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText("Дубликат аргумента");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
        }
    }

    public void delButtonHandler(ActionEvent actionEvent) {
        PointXY pointXY = tableViewXY.getSelectionModel().getSelectedItem();
        if (pointXY != null) {
            pointList.deleteItem(pointXY);
        }
    }

    public void buttonABHandler(ActionEvent actionEvent) {
        try {
            Parameters.getInstance().setA(Double.parseDouble(textFieldA.getText()));
            Parameters.getInstance().setB(Double.parseDouble(textFieldB.getText()));
            boxButton.setDisable(false);
        } catch (NullPointerException | NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверный формат чисел");
            alert.setContentText("Введите  параметры заново!");
            alert.showAndWait();
        }
    }
}