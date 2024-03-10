package org.example.Controller.Table_Row.Save;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.Bo.BoFactor;
import org.example.Bo.ManageBookBo;
import org.example.Controller.AdminController.ManageBookFormController;
import org.example.Dto.BookDto;

public class SaveBookFromController {
    @FXML
    private TextField Genre;

    @FXML
    private TextField autor;

    @FXML
    private TextField dis;

    @FXML
    private TextField title;

    @FXML
    void saveBtnOnActhion(ActionEvent event) {
        ManageBookBo manageBookBo = (ManageBookBo) BoFactor.getBoFactory().getBo(BoFactor.BoType.Manage_Book);
        int yes = manageBookBo.Save(new BookDto(0, title.getText(), autor.getText(), dis.getText(), Genre.getText(), "Yes"));
        if (yes > 0){
            title.setText("");
            autor.setText("");
            dis.setText("");
            Genre.setText("");
            new Alert(Alert.AlertType.INFORMATION, "Saved").show();
            ManageBookFormController manageBookFormController = new ManageBookFormController();
            manageBookFormController.initialize(null,null);
        }
    }

}
