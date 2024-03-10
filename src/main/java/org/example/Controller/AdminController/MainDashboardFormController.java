package org.example.Controller.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.example.unill.ChangeForm;

import java.net.URL;
import java.util.ResourceBundle;

public class MainDashboardFormController implements Initializable {
    public AnchorPane ChangePane;

    public void DashboardbtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"Admin/DashboardForm.fxml");
    }

    public void ManageBookOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"Admin/ManageBook.fxml");
    }

    public void ManageBranchOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"Admin/BranchForm.fxml");
    }

    public void ReturnBookBtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"Admin/ReturnBookFrom.fxml");
    }

    public void ExitBtnOnActhion(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void UserbtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"Admin/UserManageFrom.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChangeForm.ChangePane(ChangePane,"Admin/DashboardForm.fxml");
    }
}
