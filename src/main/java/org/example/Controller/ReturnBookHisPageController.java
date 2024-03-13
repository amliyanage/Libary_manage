package org.example.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import org.example.Bo.ReturnBookServiceI;
import org.example.Bo.ServiceFactor;
import org.example.Controller.Table_Row.HisBookRowFormController;
import org.example.Dto.BookDto;
import org.example.Entity.Book_Transaction;
import org.example.Entity.Books;
import org.example.Entity.BorrowBook;

import java.awt.print.Book;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.example.Dao.Custom.RepositoryFactory.DaoType.Books;

public class ReturnBookHisPageController implements Initializable {
    private final ReturnBookServiceI returnBookServiceI = (ReturnBookServiceI) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Return_Book);
    public VBox Vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTable();
    }

    void LoadTable(){
        List<BorrowBook> allTableData = returnBookServiceI.getAllTableData();
        System.out.println(allTableData.size()+"==============================aaaaaaaa============================");
        for (int i = 0; i < allTableData.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/BookHis.fxml"));
            try {
                Vbox.getChildren().add(fxmlLoader.load());
                Vbox.setSpacing(5);
                Vbox.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));
                HisBookRowFormController controller = fxmlLoader.getController();
                List<Book_Transaction> details = allTableData.get(i).getDetails();

                for (int j = 0; j < details.size(); j++) {
                    org.example.Entity.Books book = details.get(j).getBook();
                    controller.setData(
                            "B0"+book.getId(),
                            book.getTitle(),
                            allTableData.get(i).getStatus()
                    );
                }
                System.out.println("+++++++++++======================================================================");
                Vbox.getChildren().add(fxmlLoader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
