package org.example.Controller.Table_Row.Update;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.Bo.ServiceFactor;
import org.example.Bo.ManageBookService;
import org.example.Dto.BookDto;
import org.example.unill.Validation;

public class UpdateBook {
    public TextField Genre;
    public TextField Author;
    public TextField title;
    public TextField available;
    public TextField id;

    BookDto bookDto;

    public void setData(BookDto bookDto){
        id.setText("B0"+bookDto.getId());
        Genre.setText(bookDto.getGenre());
        Author.setText(bookDto.getAutor());
        available.setText(bookDto.getAvailable());
        title.setText(bookDto.getTitle());
        this.bookDto = bookDto;
    }

    public void updateBtnOnActhion(ActionEvent actionEvent) {
        if (Validation.validateBookTitle(title.getText()) && Validation.isValidName(Author.getText()) && Validation.isValidAddress(Genre.getText())){
            ManageBookService manageBookService = (ManageBookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Manage_Book);
            manageBookService.Update(new BookDto(
                    bookDto.getId(),
                    title.getText(),
                    Author.getText(),
                    bookDto.getDis(),
                    Genre.getText(),
                    available.getText()
            ));
            new Alert(Alert.AlertType.INFORMATION,"Updated").show();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Invalid Input").show();
        }
    }
}
