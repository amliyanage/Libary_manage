package org.example.Controller.Table_Row.View;

import javafx.scene.control.Label;
import org.example.Dto.BookDto;

public class ViewBookFormController {
    public Label Book_Id;
    public Label available;
    public Label title;
    public Label author;
    public Label genre;

    public void setData(BookDto bookDto){
        Book_Id.setText("B0"+bookDto.getId());
        available.setText(bookDto.getAvailable());
        title.setText(bookDto.getTitle());
        author.setText(bookDto.getAutor());
        genre.setText(bookDto.getGenre());
        author.setText(bookDto.getGenre());
    }
}
