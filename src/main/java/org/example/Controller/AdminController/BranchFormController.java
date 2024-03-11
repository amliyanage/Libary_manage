package org.example.Controller.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Bo.ServiceFactor;
import org.example.Bo.BranchService;
import org.example.Controller.Table_Row.BranchRowController;
import org.example.Dto.BranchDto;

import java.io.IOException;
import java.util.ArrayList;

public class BranchFormController {
    public VBox TableBox;

    BranchService branchBo = (BranchService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Branch);

    public void AddUserOnActhion(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/Save/BranchSave.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        laodTable();
    }

    private void laodTable() {
        TableBox.getChildren().clear();
        ArrayList<BranchDto> all = branchBo.getAll();
        for (BranchDto branchDto : all) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/BranchRow.fxml"));
                Parent root = fxmlLoader.load();
                BranchRowController controller = fxmlLoader.getController();
                controller.setData(branchDto);
                TableBox.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
