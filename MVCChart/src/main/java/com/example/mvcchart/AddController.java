package com.example.mvcchart;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {
    public TextField addTextField;
    private double x;
    private boolean addResult = false;

    public double getX() {
        return x;
    }

    public boolean isAddResult() {
        return addResult;
    }

    public void addButtonHandler(ActionEvent actionEvent) {
        try {
            x = Double.parseDouble(addTextField.getText());
            addResult = true;
            ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
        } catch (NullPointerException | NumberFormatException ex) {
            addResult = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверный формат чисел");
            alert.setContentText("Введите  параметры заново!");
            alert.showAndWait();
        }
    }
}
