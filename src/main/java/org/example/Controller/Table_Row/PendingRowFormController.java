package org.example.Controller.Table_Row;

import javafx.scene.control.Label;
import org.example.Dto.PendingDto;

import java.time.LocalDate;

public class PendingRowFormController {
    public Label ID;
    public Label MemberId;
    public Label name;
    public Label returnDate;
    public Label dateCount;

    public void setData(PendingDto pendingDto){
        LocalDate dueDate = LocalDate.parse(pendingDto.getDueDate());
        LocalDate today = LocalDate.now();

        if (today.isAfter(dueDate)) {
            ID.setText("P0" + pendingDto.getId());
            MemberId.setText("M0" + pendingDto.getMemberId());
            name.setText(pendingDto.getMemberName());
            returnDate.setText(pendingDto.getDueDate());

            LocalDate dueDate1 = LocalDate.now();
            LocalDate returnDate = LocalDate.parse(pendingDto.getDueDate());

            long days = dueDate1.toEpochDay() - returnDate.toEpochDay();
            dateCount.setText(String.valueOf(days));
        }
        else {
            ID.setText("");
            MemberId.setText("");
            name.setText("");
            returnDate.setText("");
            dateCount.setText("");
        }
    }
}
