package org.example.Controller.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import org.example.Bo.ServiceFactor;
import org.example.Bo.UserMangeService;
import org.example.Controller.Table_Row.UserRowFromController;

import java.io.IOException;

public class UserManageFromController {
    public VBox TableBox;

    UserMangeService userMangeBo = (UserMangeService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.UserMange);
    public void initialize() {
        TableBox.getChildren().clear();
        userMangeBo.getAll().forEach(MemberDto -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/UserRow.fxml"));
                Parent root = fxmlLoader.load();
                UserRowFromController controller = fxmlLoader.getController();
                controller.setData(MemberDto);
                TableBox.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void AddUserOnActhion(ActionEvent actionEvent) {

    }

    public void UpdateuserOnActhion(ActionEvent actionEvent) {

    }
}
