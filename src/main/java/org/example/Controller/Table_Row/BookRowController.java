package org.example.Controller.Table_Row;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.Bo.ServiceFactor;
import org.example.Bo.ManageBookService;
import org.example.Controller.AdminController.ManageBookFormController;
import org.example.Controller.Table_Row.Update.UpdateBook;
import org.example.Controller.Table_Row.View.ViewBookFormController;
import org.example.Dto.BookDto;

import java.io.IOException;

public class BookRowController {
    @FXML
    private Label Id;

    @FXML
    private Label autor;

    @FXML
    private Label avilable;

    @FXML
    private CheckBox checkBox;

    @FXML
    private Label title;

    BookDto bookDto;

    public void setData(BookDto bookDto){
        this.Id.setText("Bo"+bookDto.getId());
        autor.setText(bookDto.getAutor());
        avilable.setText(bookDto.getAvailable());
        title.setText(bookDto.getTitle());
        this.bookDto = bookDto;
    }

    public void viewBtnOnActhion(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BookRowController.class.getResource("/Forms/Table_Row/View/ViewBook.fxml"));
        Parent parent = fxmlLoader.load();
        ViewBookFormController bookRowController = fxmlLoader.getController();
        bookRowController.setData(bookDto);
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setScene(new Scene(parent));
        popupStage.centerOnScreen();
        popupStage.showAndWait();
    }

    public void editBtnOnActhion(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BookRowController.class.getResource("/Forms/Table_Row/UpDate/UpdateBook.fxml"));
        Parent parent = fxmlLoader.load();
        UpdateBook bookRowController = fxmlLoader.getController();
        bookRowController.setData(bookDto);
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setScene(new Scene(parent));
        popupStage.centerOnScreen();
        popupStage.showAndWait();
    }

    ManageBookService manageBookBo = (ManageBookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Manage_Book);
    public void DeleteBtnOnActhion(ActionEvent actionEvent) {
        manageBookBo.Delete(bookDto.getId());
        new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
        ManageBookFormController manageBookFormController = new ManageBookFormController();
        manageBookFormController.initialize(null ,null);
    }
}
