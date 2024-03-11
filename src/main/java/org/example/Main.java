package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Forms/Admin/AdminRegisterForm.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}

class Run{
    public static void main(String[] args) {
        Main.main(args);
    }
}