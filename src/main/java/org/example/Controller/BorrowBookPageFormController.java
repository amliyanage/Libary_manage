package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.example.Bo.BorrowBookService;
import org.example.Bo.Custom.MemberServiceImpl;
import org.example.Bo.ServiceFactor;
import org.example.Controller.Table_Row.BookRowController;
import org.example.Controller.Table_Row.BorrowBookRowController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BorrowBookPageFormController {

    public TextField Date;
    public VBox vBox;

    @FXML
    private TextField Return_Book;

    @FXML
    private TextField SearchBook;

    @FXML
    private TextField memberIdText;

    private final BorrowBookService borrowBookService = (BorrowBookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Borrow_Book);

    private AutoCompletionBinding<String> Autotitle;

    private List<String> titles = borrowBookService.getTitles();

    private Set<String> titleSet = new HashSet<>(titles);

    public List<String> borrowRows = new ArrayList<>();

    public static BorrowBookPageFormController borrowBookPageFormController;

    public BorrowBookPageFormController(){
        borrowBookPageFormController = this;
    }


    public void initialize() {
        memberIdText.setText("M0"+MemberServiceImpl.member.getId());
        Autotitle = TextFields.bindAutoCompletion(SearchBook, titleSet);
        LocalDate localDate = LocalDate.now();
        Date.setText(localDate.toString());
        Return_Book.setText(LocalDate.now().plusDays(7).toString());
    }

    boolean flag = true;

    public void addBtnOnActhion(ActionEvent actionEvent) {
        if (flag){
            flag = false;
            borrowRows.add(SearchBook.getText());
            LoadTable();
            return;
        }
        for (int i = 0; i < borrowRows.size(); i++) {
            if (borrowRows.get(i).equals(SearchBook.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Duplicate Book");
                alert.setContentText("You have already added this book");
                alert.showAndWait();
                break;
            }
            else {
                borrowRows.add(SearchBook.getText());
                LoadTable();
                break;
            }
        }
    }

    public void LoadTable(){
        vBox.getChildren().clear();
        for (int i = 0; i < borrowRows.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/BorrowBook.fxml"));
            try {
                Parent laodNode = fxmlLoader.load();
                BorrowBookRowController borrowBookRowController = fxmlLoader.getController();
                borrowBookRowController.setData(borrowRows.get(i), i);
                vBox.getChildren().add(laodNode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    void gtOnActhion(ActionEvent event) {
        saveData();
    }

    void saveData(){
        boolean saveTransaction = borrowBookService.saveTransaction(titles);
        if (saveTransaction){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Transaction Success");
            alert.setContentText("Transaction has been saved successfully");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Transaction Failed");
            alert.setContentText("Transaction has been failed");
            alert.showAndWait();
        }
    }

}
