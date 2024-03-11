package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.example.Bo.ServiceFactor;
import org.example.Bo.SearchBookService;
import org.example.Dto.BookDto;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class BookViewFormController implements Initializable {

    @FXML
    private TextField AutorText;

    @FXML
    private TextArea DisText;

    @FXML
    private TextField genreText;

    @FXML
    private Label lable;

    @FXML
    private Text lableText;

    @FXML
    private TextField searchBar;

    @FXML
    private TextField titleText;

    SearchBookService searchBookService = (SearchBookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Search_Book);

    @FXML
    void searchOnActhion(ActionEvent event) {

        BookDto bookDto = searchBookService.getData(searchBar.getText());

        titleText.setText(bookDto.getTitle());
        AutorText.setText(bookDto.getAutor());
        DisText.setText(bookDto.getDis());
        genreText.setText(bookDto.getGenre());

        if(bookDto.getAvailable().equals("yes")){
            lable.setStyle("-fx-background-color: green");
            lableText.setText("Yes");
        }
        else {
            lable.setStyle("-fx-background-color: red");
            lableText.setText("No");
        }

    }

    private AutoCompletionBinding<String> Autotitle;

    private List<String> titles = searchBookService.getTitles();

    private Set<String> titleSet = new HashSet<>(titles);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Autotitle = TextFields.bindAutoCompletion(searchBar,titleSet);

    }
}
