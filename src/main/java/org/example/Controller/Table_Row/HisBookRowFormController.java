package org.example.Controller.Table_Row;

import javafx.scene.control.Label;

public class HisBookRowFormController {
    public Label Book_ID;
    public Label title;
    public Label returnBook;

    public void setData(String book_ID, String title, String returnBook) {
        Book_ID.setText(book_ID);
        this.title.setText(title);
        this.returnBook.setText(returnBook);
    }
}
