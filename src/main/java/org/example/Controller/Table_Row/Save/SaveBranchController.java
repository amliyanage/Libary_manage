package org.example.Controller.Table_Row.Save;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.Bo.BoFactor;
import org.example.Bo.BranchBo;
import org.example.Dto.BranchDto;

public class SaveBranchController {


    public TextField name;
    public TextField locationtext;
    public TextField email;
    BranchBo branchBo = (BranchBo) BoFactor.getBoFactory().getBo(BoFactor.BoType.Branch);

    @FXML
    public void saveBtnOnActhion(ActionEvent actionEvent) { // Corrected typo in method name
        int save = branchBo.save(new BranchDto(0, name.getText(), locationtext.getText(), email.getText()));
        if (save > 0) {
            name.clear();
            locationtext.clear();
            email.clear();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again..").show();
        }
    }
}
