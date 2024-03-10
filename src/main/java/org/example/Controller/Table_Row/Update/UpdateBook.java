package org.example.Controller.Table_Row.Update;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.Bo.BoFactor;
import org.example.Bo.ManageBookBo;
import org.example.Dto.BookDto;

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
        ManageBookBo manageBookBo = (ManageBookBo) BoFactor.getBoFactory().getBo(BoFactor.BoType.Manage_Book);
        manageBookBo.Update(new BookDto(
                bookDto.getId(),
                title.getText(),
                Author.getText(),
                bookDto.getDis(),
                Genre.getText(),
                available.getText()
        ));
        new Alert(Alert.AlertType.INFORMATION,"Updated").show();
    }
}
