package org.example.Controller.Table_Row;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import org.example.Bo.ServiceFactor;
import org.example.Bo.UserMangeService;
import org.example.Dto.MemberDto;

public class UserRowFromController {
    public Label UserId;
    public Label name;
    public Label Username;
    public Label Password;

    MemberDto memberDto = null;

    public void setData(MemberDto userDto){
        this.UserId.setText("Bo"+userDto.getId());
        name.setText(userDto.getFull_name());
        Username.setText(userDto.getUsername());
        Password.setText(userDto.getPassword());
        memberDto = userDto;
    }

    UserMangeService userMangeBo = (UserMangeService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.UserMange);

    public void DeleteBtnOnActhion(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this user?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            userMangeBo.delete(memberDto.getId());
        }
    }
}
