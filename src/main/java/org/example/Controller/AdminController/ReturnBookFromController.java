package org.example.Controller.AdminController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.Bo.ReturnBookServiceI;
import org.example.Bo.ServiceFactor;
import org.example.Entity.Book_Transaction;
import org.example.Entity.BorrowBook;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    BorrowBook borrowBook;

    @FXML
    void returnBtnOnActhion(ActionEvent event) {
        borrowBook.setPayment(Double.parseDouble(Payment.getText()));
        boolean returned = returnBookServiceI.returnBook(borrowBook);

        if(returned){
            new Alert(Alert.AlertType.CONFIRMATION,"Book Returned").show();
        }
    }

    @FXML
    void ComboOnActhion(ActionEvent event) {
        BorrowBook pendingData = returnBookServiceI.getPendingData(MemberIdCombo.getValue());
        BookCount.setText(pendingData.getQty() + "");
        borrowBook = pendingData;

        String date = String.valueOf(pendingData.getAddedDate());

        String[] s = date.split(" ");
        Date.setText(s[0]);

        ReturnData.setText(pendingData.getDueDate() + "");
        payment();
    }

    void payment(){
        int payment = 0;
        LocalDate date = LocalDate.now();
        LocalDate dueDate = LocalDate.parse(ReturnData.getText());
        long between = ChronoUnit.DAYS.between(dueDate,date);
        if (between > 0){
            payment = (int) (between * 100);
        }
        Payment.setText(payment + "");
    }
}
