package org.example.Controller.Table_Row;

import javafx.scene.control.Label;
import org.example.Dto.AdminDto;

public class UserRowFromController {
    public Label UserId;
    public Label name;
    public Label Username;
    public Label Password;


    public void setData(AdminDto userDto){
        this.UserId.setText("Bo"+userDto.getId());
        name.setText(userDto.getName());
        Username.setText(userDto.getUsername());
        Password.setText(userDto.getPassword());
    }

}
