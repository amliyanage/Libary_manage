package org.example.Controller.Table_Row.View;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.Dto.BranchDto;

public class ViewBranchFormController {

    @FXML
    private TextField Branch_Id;

    @FXML
    private TextField email;

    @FXML
    private TextField locationtext;

    @FXML
    private TextField name;

    public void setData(BranchDto branchDto){
        Branch_Id.setText("B0"+branchDto.getId());
        name.setText(branchDto.getName());
        locationtext.setText(branchDto.getLocation());
        email.setText(branchDto.getEmail());
    }
}
