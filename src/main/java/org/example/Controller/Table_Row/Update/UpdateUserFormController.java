package org.example.Controller.Table_Row.Update;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.Bo.AdminBo;
import org.example.Bo.Custom.AdminBoImpl;
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

    UserMangeBo userMangeBo = (UserMangeBo) org.example.Bo.BoFactor.getBoFactory().getBo(org.example.Bo.BoFactor.BoType.UserMange);
    @FXML
    void updateBtnOnActhion(ActionEvent event) {
//        userMangeBo.update(new AdminDto(AdminBoImpl.UserId, name.getText(), username.getText(), password.getText(), email.getText()));
    }

    public void setData() {
//        AdminDto data = userMangeBo.getData();
//        name.setText(data.getName());
//        username.setText(data.getUsername());
//        password.setText(data.getPassword());
//        email.setText(data.getEmail());
    }
}
