package org.example.Controller.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.Bo.AdminRegisterService;
import org.example.Bo.ServiceFactor;
import org.example.Dto.AdminDto;
import org.example.unill.Validation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminRegisterFormController {
    public TextField NameText;
    @FXML
    private PasswordField PasswordConfirm;

    @FXML
    private TextField PasswordConfirmText;

    @FXML
    private PasswordField PasswordFild;

    @FXML
    private TextField PasswordTextFild;

    @FXML
    private TextField emailText;

    @FXML
    private TextField usernameText;

    @FXML
    private Button viewConfirmPass;

    @FXML
    private Button viewPass;


    private final AdminRegisterService registerService = (AdminRegisterService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Admin_Register);

    Boolean flag = true;
    Boolean flag1 = true;
    @FXML
    void viewConfirmPassOnActhion(ActionEvent event) {
        String Password = PasswordConfirm.getText();
        String TExtPass = PasswordConfirmText.getText();

        if (flag == false){
            PasswordConfirm.setVisible(false);
            PasswordConfirmText.setVisible(true);
            PasswordConfirmText.setText(Password);
            flag1 = true;
        }
        else {
            PasswordConfirm.setVisible(true);
            PasswordConfirmText.setVisible(false);
            PasswordConfirm.setText(TExtPass);
            flag1 = false;
        }
    }

    @FXML
    void viewPassOnActhion(ActionEvent event) {
        String Password = PasswordFild.getText();
        String TExtPass = PasswordTextFild.getText();

        if (flag == false){
            PasswordFild.setVisible(false);
            PasswordTextFild.setVisible(true);
            PasswordTextFild.setText(Password);
            flag = true;
        }
        else {
            PasswordFild.setVisible(true);
            PasswordTextFild.setVisible(false);
            PasswordFild.setText(TExtPass);
            flag = false;
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        PasswordTextFild.setVisible(false);
        PasswordConfirmText.setVisible(false);
    }

    public void loginBtnOnAction(MouseEvent mouseEvent) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Forms/LoginPage.fxml"));
            Stage stage = (Stage) PasswordConfirm.getScene().getWindow();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void RegisterbtnOnActhion(ActionEvent actionEvent) {
        if (Validation.isValidEmail(emailText.getText()) && Validation.isValidName(NameText.getText())){
            if (PasswordFild.getText().equals(PasswordConfirm.getText())) {
                Register();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Password Not Match").show();
            }
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Invalid Input").show();
        }
    }

    private void Register() {
        int register = registerService.saveAdmin(new AdminDto(1,NameText.getText(), usernameText.getText(), PasswordTextFild.getText(), emailText.getText()));

        if (register != -1){

            new Alert(Alert.AlertType.INFORMATION,"Admin Id is : M0"+register).show();

            Parent parent = null;

            try {
                parent = FXMLLoader.load(getClass().getResource("/Forms/LoginPage.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Stage stage = (Stage) PasswordConfirm.getScene().getWindow();
            stage.setScene(new Scene(parent));
            stage.show();
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Not Complete").show();
        }
    }
}
