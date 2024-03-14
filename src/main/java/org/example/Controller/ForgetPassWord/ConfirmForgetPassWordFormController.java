package org.example.Controller.ForgetPassWord;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Controller.LoginPageController;

import java.io.IOException;

public class ConfirmForgetPassWordFormController {
    public TextField textField;

    public static int otp = 0;

    public void emailOnActhion(ActionEvent actionEvent) {
        if (otp == Integer.parseInt(textField.getText())) {
            if (ForgetPassWordFormController.user.equals("Member")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/MainDashboardPage.fxml"));
                try {
                    Stage stage =  new Stage();
                    stage.setScene(new Scene(fxmlLoader.load()));
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (ForgetPassWordFormController.user.equals("Admin")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Admin/MainDashboardPage.fxml"));
                try {
                    Stage stage =  new Stage();
                    stage.setScene(new Scene(fxmlLoader.load()));
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void loginBtnOnActhion(ActionEvent actionEvent) {
    }
}
