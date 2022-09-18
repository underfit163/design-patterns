package com.example.mvcchart;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateController {
    public TextField updateTextField;
    private double x;
    private boolean updateResult = false;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public boolean isUpdateResult() {
        return updateResult;
    }

    public void updateButtonHandler(ActionEvent actionEvent) {
        try {
            x = Double.parseDouble(updateTextField.getText());
            updateResult = true;
            ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
        } catch (NullPointerException | NumberFormatException ex) {
            updateResult = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверный формат чисел");
            alert.setContentText("Введите  параметры заново!");
            alert.showAndWait();
        }
    }
}
