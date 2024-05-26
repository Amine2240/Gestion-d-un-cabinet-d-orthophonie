package com.example.tp_poo;

// libraries that will help us to create the GUI of the application 01/05
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        System.out.println("hello java fx application");
    }
}