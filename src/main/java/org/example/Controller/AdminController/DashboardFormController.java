package org.example.Controller.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Bo.ServiceFactor;
import org.example.Bo.Custom.AdminServiceImpl;
import org.example.Bo.DashboardService;
import org.example.Controller.Table_Row.Update.UpdateUserFormController;
import org.example.Dto.AdminDto;

public class DashboardFormController {
    public Label BookCount;
    public Label BranchCount;
    public Label PaymentCount;
    public Label MemberCount;
    @FXML
    private PasswordField PasswordFild;

    @FXML
    private TextField PasswordTextFild;

    @FXML
    private TextField Username;

    @FXML
    private TextField email;

    @FXML
    private Button viewPass;

    Boolean flag = false;

    AdminDto adminDto = AdminServiceImpl.data;

    DashboardService dashboardService = (DashboardService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.DashBoard);

    public void initialize() {
        PasswordTextFild.setVisible(false);
        Username.setText(adminDto.getUsername());
        email.setText(adminDto.getEmail());
        PasswordFild.setText(adminDto.getPassword());
        PasswordTextFild.setText(adminDto.getPassword());
        setData();
    }

    void setData(){
        BookCount.setText(String.valueOf(dashboardService.BookCount()));
        BranchCount.setText(String.valueOf(dashboardService.BranchCount()));
        MemberCount.setText(String.valueOf(dashboardService.MemberCount()));
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

    public void settingsBtnOnActhion(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/UpDate/UpdateAdmin.fxml"));
        try {
            fxmlLoader.load();
            UpdateUserFormController controller = fxmlLoader.getController();
            controller.setData();
            Stage stage = new Stage();
            stage.setScene(new Scene(fxmlLoader.getRoot()));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
