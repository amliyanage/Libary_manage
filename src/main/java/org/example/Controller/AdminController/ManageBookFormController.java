package org.example.Controller.AdminController;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import lombok.SneakyThrows;
import org.example.Bo.BoFactor;
import org.example.Bo.ManageBookBo;
import org.example.Controller.Table_Row.BookRowController;
import org.example.Dto.BookDto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageBookFormController implements Initializable {
    public javafx.scene.control.CheckBox CheckBox;
    public VBox tableLoad;

    ManageBookBo manageBookBo = (ManageBookBo) BoFactor.getBoFactory().getBo(BoFactor.BoType.Manage_Book);

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        javafx.scene.control.CheckBox checkBox = new CheckBox();
        checkBox.setPrefSize(500,500);

        this.CheckBox = checkBox;
        LoadTable();
    }

    void LoadTable() throws IOException {
        VBox vBox = new VBox();
        vBox.setSpacing(10);

        ArrayList<BookDto> all = manageBookBo.getAll();

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
}
