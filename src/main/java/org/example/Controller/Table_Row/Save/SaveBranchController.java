package org.example.Controller.Table_Row.Save;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.Bo.ServiceFactor;
import org.example.Bo.BranchService;
import org.example.Dto.BranchDto;

public class SaveBranchController {


    public TextField name;
    public TextField locationtext;
    public TextField email;
    BranchService branchService = (BranchService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Branch);

    @FXML
    public void saveBtnOnActhion(ActionEvent actionEvent) { // Corrected typo in method name
//        if(Regex.name(name.getText()) && Regex.city(locationtext.getText()) && Regex.email(email.getText())){
            int save = branchService.save(new BranchDto(0, name.getText(), locationtext.getText(), email.getText()));
            if (save > 0) {
                name.clear();
                locationtext.clear();
                email.clear();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Try Again..").show();
            }
//        }
//        else {
//            new Alert(Alert.AlertType.ERROR, "Invalid Input").show();
//        }
    }
}
