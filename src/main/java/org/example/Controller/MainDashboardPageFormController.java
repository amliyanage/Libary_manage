package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.example.unill.ChangeForm;

import java.net.URL;
import java.util.ResourceBundle;

public class MainDashboardPageFormController implements Initializable {
    public AnchorPane ChangePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChangeForm.ChangePane(ChangePane,"DashBoardPage.fxml");
    }

    public void DashboardbtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"DashBoardPage.fxml");
    }

    public void SearchBookOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"BookView.fxml");
    }

    public void ReturnBookBtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"ReturnBookPage.fxml");
    }

    public void BookBorrowBtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"BorrowBookPage.fxml");
    }

    public void ExitBtnOnActhion(ActionEvent actionEvent) {
        System.exit(0);
    }
}
