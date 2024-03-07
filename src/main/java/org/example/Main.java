package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Form/LoginPage.fxml"));
        Font.loadFont(getClass().getResourceAsStream("/path/to/YourFontFile.ttf"), 14);
        stage.setScene(new Scene(root));
        stage.show();
    }
}

class Run{
    public static void main(String[] args) {
        Main.main(args);
    }
}