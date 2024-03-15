package org.example.Controller.AdminController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import org.example.Service.PendingBookService;
import org.example.Service.ServiceFactor;
import org.example.Controller.Table_Row.PendingRowFormController;
import org.example.Dto.PendingDto;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PendingBookFormController {
    public VBox tableLoad;

    private final PendingBookService pendingBookService = (PendingBookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.pendingBook);

    public void initialize() throws IOException {
        loadTable();
    }

    void loadTable() throws IOException {
        List<PendingDto> pendingBookDetails = pendingBookService.getPendingBookDetails();
        tableLoad.getChildren().clear();
        for (int i = 0; i < pendingBookDetails.size(); i++) {


            LocalDate dueDate = LocalDate.parse(pendingBookDetails.get(i).getDueDate());
            LocalDate today = LocalDate.now();

            if (today.isAfter(dueDate)) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/pendingRow.fxml"));
                Parent root = fxmlLoader.load();
                PendingRowFormController controller = fxmlLoader.getController();
                controller.setData(pendingBookDetails.get(i));
                tableLoad.getChildren().add(root);

            }
        }


    }
}
