package org.example.Controller.Table_Row.Update;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import org.example.Bo.AdminBo;
import org.example.Bo.BoFactor;
import org.example.Bo.Custom.AdminBoImpl;
import org.example.Bo.DashboardBo;
import org.example.Bo.UserMangeBo;
import org.example.Dto.AdminDto;
import org.example.Entity.Admin;

import java.util.List;

public class UpdateUserFormController {
    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    AdminDto adminDto = AdminBoImpl.data;

    DashboardBo userMangeBo = (DashboardBo) BoFactor.getBoFactory().getBo(BoFactor.BoType.DashBoard);
    @FXML
    void updateBtnOnActhion(ActionEvent event) {
        try {
            userMangeBo.Update(new AdminDto(adminDto.getId(),name.getText(),username.getText(),password.getText(),email.getText()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
    }

    public void setData() {
        name.setText(adminDto.getName());
        username.setText(adminDto.getUsername());
        password.setText(adminDto.getPassword());
        email.setText(adminDto.getEmail());
    }

    public void DeleteBtnOnActhion(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this branch?", ButtonType.YES, ButtonType.NO).showAndWait().ifPresent(buttonType -> {
            if (buttonType == ButtonType.YES){
                userMangeBo.Delete(adminDto.getId());
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted", ButtonType.OK).show();
                System.exit(0);
            }
        });
    }
}
