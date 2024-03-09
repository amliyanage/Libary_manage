package org.example.Controller;

import javafx.scene.control.*;
import org.example.Bo.BoFactor;
import org.example.Bo.MemberBo;
import org.example.Bo.AdminBo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.unill.getIdNumber;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LoginPageController implements Initializable {

    public PasswordField PasswordFild;
    public TextField PasswordTextFild;
    public Button viewPass;
    public TextField Username;
    public CheckBox MemberCheckBox;
    public CheckBox AdminCheckBox;

    Boolean flag = false;

    MemberBo memberBo = (MemberBo) BoFactor.getBoFactory().getBo(BoFactor.BoType.Member);
    AdminBo adminBo = (AdminBo) BoFactor.getBoFactory().getBo(BoFactor.BoType.Admin);

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle ) {
        PasswordTextFild.setVisible( false );
    }

    @FXML
    void viewPassOnActhion(ActionEvent event) {

        String Password = PasswordFild.getText();
        String TExtPass = PasswordTextFild.getText();

        if ( flag == false ){
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

    public void LoginOnActhion(ActionEvent actionEvent) {
        if (MemberCheckBox.isSelected()){
            Member_login();
        } else if (AdminCheckBox.isSelected()) {
            Admin_Login();
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Please select Member or Admin").show();
        }
    }

    public void RegisterHerebtnOnActhion(MouseEvent mouseEvent) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Forms/RegisterPage.fxml"));
            Stage stage = (Stage) PasswordFild.getScene().getWindow();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    void Member_login(){
        boolean logined = memberBo.Login(Username.getText(), PasswordFild.getText());

        if (logined){
            Parent parent = null;
            try {
                parent = FXMLLoader.load( getClass().getResource( "/Forms/MainDashboardPage.fxml" ) );
                Stage stage = (Stage) PasswordFild.getScene().getWindow();
                stage.setScene(new Scene(parent));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Worng Data has been input").show();
        }
    }

    void Admin_Login(){
        boolean logined = adminBo.getData(Username.getText(), PasswordFild.getText());
        if (logined){
            Parent parent = null;
            try {
                parent = FXMLLoader.load( getClass().getResource( "/Forms/Admin/MainDashboardPage.fxml" ) );
                Stage stage = (Stage) PasswordFild.getScene().getWindow();
                stage.setScene(new Scene(parent));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Worng Data has been input").show();
        }
    }

}
