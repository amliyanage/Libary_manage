package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.Bo.BoFactor;
import org.example.Bo.RegisterBo;
import org.example.Dto.MemberDto;
import org.example.Entity.Member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterPageFormController implements Initializable {

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


    RegisterBo registerBo = (RegisterBo) BoFactor.getBoFactory().getBo(BoFactor.BoType.Register);

    Boolean flag = false;
    Boolean flag1 = false;
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

    @Override
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
        Parent parent = null;
        try {
            Register();
            parent = FXMLLoader.load(getClass().getResource("/Forms/LoginPage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) PasswordConfirm.getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private void Register() {
        int register = registerBo.Register(new MemberDto(1, usernameText.getText(), PasswordFild.getText(), emailText.getText()));

        if (register != -1){
            new Alert(Alert.AlertType.INFORMATION,"User Id is : M0"+register).show();
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Not Complete").show();
        }
    }

}
