package org.example.Controller.AdminController;

import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageBookFormController implements Initializable {
    public javafx.scene.control.CheckBox CheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        javafx.scene.control.CheckBox checkBox = new CheckBox();
        checkBox.setPrefSize(500,500);

        this.CheckBox = checkBox;
    }
}
