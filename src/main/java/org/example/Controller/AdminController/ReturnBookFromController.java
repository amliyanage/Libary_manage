package org.example.Controller.AdminController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.Bo.ReturnBookServiceI;
import org.example.Bo.ServiceFactor;

import java.util.List;

public class ReturnBookFromController {
    @FXML
    private TextField BookCount;

    @FXML
    private TextField Date;

    @FXML
    private ComboBox<String> MemberIdCombo;

    @FXML
    private TextField Payment;

    @FXML
    private TextField ReturnData;

    public final ReturnBookServiceI returnBookServiceI = (ReturnBookServiceI) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Return_Book);

    public void initialize(){
        List<Integer> allId = returnBookServiceI.getAllId();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Integer integer : allId) {
            items.add("M0"+integer);
        }
        MemberIdCombo.setItems(items);
    }

    @FXML
    void returnBtnOnActhion(ActionEvent event) {

    }

    @FXML
    void ComboOnActhion(ActionEvent event) {

    }

}
