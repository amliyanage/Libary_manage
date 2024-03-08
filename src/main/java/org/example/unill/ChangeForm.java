package org.example.unill;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ChangeForm {
    public static void ChangePane( AnchorPane pane , String fileName ){
        Parent parent = null;
        try {
            parent = FXMLLoader.load( ChangeForm.class.getResource ( "/Forms/"+fileName ) );
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
        pane.getChildren().clear();
        pane.getChildren().add( parent );
    }
}
