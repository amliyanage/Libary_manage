package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.Bo.MemberDashboardServer;
import org.example.Bo.ServiceFactor;
import org.example.Dto.MemberDto;
import org.example.unill.Validation;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardPageFormController implements Initializable {

    public TextField emailText;
    public TextField UsernameText;
    @FXML
    private PasswordField PasswordFild;

    @FXML
    private TextField PasswordTextFild;

    @FXML
    private Button viewPass;

    Boolean flag = false;

    private final MemberDashboardServer memberDashboardServer = (MemberDashboardServer) org.example.Bo.ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.MemberDashBoard);

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
        SetData();
    }

    int Id = 0;
    String name = "";

    void SetData(){
        MemberDto data = memberDashboardServer.getData(LoginPageController.memberUsername);
        UsernameText.setText(data.getUsername());
        emailText.setText(data.getEmail());
        PasswordTextFild.setText(data.getPassword());
        PasswordFild.setText(data.getPassword());
        Id = data.getId();
        name = data.getFull_name();
    }

    boolean change = true;

    @FXML
    void ChangePasswordOnActhion(ActionEvent event) {
        if (change){
            new Alert(Alert.AlertType.INFORMATION,"Now You can enter new Pass word On Password Field").show();
            PasswordFild.setEditable(true);
            PasswordTextFild.setEditable(true);
            change = false;
        }
        else {
            ChangePassword();
            PasswordFild.setEditable(false);
            PasswordTextFild.setEditable(false);
            change = true;
        }
    }

    void ChangePassword(){
        if (Validation.isValidEmail(emailText.getText())){
            memberDashboardServer.Update(new MemberDto(Id,name,UsernameText.getText(),PasswordFild.getText(),emailText.getText()));
            new Alert(Alert.AlertType.INFORMATION,"Password Changed").show();
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Please Enter Valid Data").show();
        }
    }
}
