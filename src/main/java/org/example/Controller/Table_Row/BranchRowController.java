package org.example.Controller.Table_Row;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.Bo.ServiceFactor;
import org.example.Bo.BranchService;
import org.example.Controller.Table_Row.Update.UpdateBranchFormController;
import org.example.Controller.Table_Row.View.ViewBranchFormController;
import org.example.Dto.BranchDto;

import java.io.IOException;

public class BranchRowController {

    @FXML
    private Label Id;

    @FXML
    private Label email;

    @FXML
    private Label locathion;

    @FXML
    private Label name;

    BranchDto branchDto;

    public void setData(BranchDto branchDto){
        Id.setText("B0"+branchDto.getId());
        name.setText(branchDto.getName());
        locathion.setText(branchDto.getLocation());
        email.setText(branchDto.getEmail());
        this.branchDto = branchDto;
    }

    public void viewBtnOnActhion(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/View/Branch.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            ViewBranchFormController controller = fxmlLoader.getController();
            controller.setData(branchDto);
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void editBtnOnActhion(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/Update/BranchUpdate.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            UpdateBranchFormController controller = fxmlLoader.getController();
            controller.setData(branchDto);
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BranchService branchService = (BranchService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Branch);

    public void DeleteBtnOnActhion(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this branch?", ButtonType.YES, ButtonType.NO).showAndWait().ifPresent(buttonType -> {
            if (buttonType == ButtonType.YES){
                branchService.delete(branchDto.getId());
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted", ButtonType.OK).show();
            }
        });
    }
}
