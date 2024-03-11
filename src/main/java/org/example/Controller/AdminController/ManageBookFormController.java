package org.example.Controller.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.example.Bo.ServiceFactor;
import org.example.Bo.ManageBookService;
import org.example.Controller.Table_Row.BookRowController;
import org.example.Controller.Table_Row.View.ViewBookFormController;
import org.example.Dto.BookDto;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ManageBookFormController implements Initializable {
    public javafx.scene.control.CheckBox CheckBox;
    public VBox tableLoad;
    public TextField search;

    ManageBookService manageBookService = (ManageBookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Manage_Book);

    private AutoCompletionBinding<String> Autotitle;

    private List<String> titles = manageBookService.getTitles();

    private Set<String> titleSet = new HashSet<>(titles);

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Autotitle = TextFields.bindAutoCompletion(search,titleSet);
        javafx.scene.control.CheckBox checkBox = new CheckBox();
        checkBox.setPrefSize(500,500);

        this.CheckBox = checkBox;
        LoadTable();
    }

    void LoadTable() throws IOException {
        VBox vBox = new VBox();
        vBox.setSpacing(10);

        ArrayList<BookDto> all = manageBookService.getAll();

        for (int i = 0; i < all.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/bookRow.fxml"));
            Parent laodNode = fxmlLoader.load();
            BookRowController bookRowController = fxmlLoader.getController();
            bookRowController.setData(all.get(i));
            vBox.getChildren().add(laodNode);
        }

        tableLoad.getChildren().clear();
        tableLoad.getChildren().add(vBox);
    }

    public void AddBtnOnActhion(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/Save/SaveBook.fxml"));
        Parent parent = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.centerOnScreen();
        stage.showAndWait();
    }

    public void searchOnActhion(ActionEvent actionEvent) {
        String text = search.getText();
        BookDto bookDto = manageBookService.search(text);

        if (bookDto != null){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/View/ViewBook.fxml"));
            Parent parent = null;
            try {
                parent = fxmlLoader.load();
                ViewBookFormController viewBookFormController = fxmlLoader.getController();
                viewBookFormController.setData(bookDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.centerOnScreen();
            stage.showAndWait();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Not Found").show();
        }
    }
}
