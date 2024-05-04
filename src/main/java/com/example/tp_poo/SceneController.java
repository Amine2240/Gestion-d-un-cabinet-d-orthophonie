package com.example.tp_poo;

import com.calendarfx.view.CalendarView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    public void switchToLoginScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScene.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

         }

    public void switchToSignupScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignupScene.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void showCalendarScene(ActionEvent event) throws IOException {
        // Create and show the calendar scene
        CalendarView calendarView = new CalendarView();
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene calendarScene = new Scene(calendarView, 1300, 1000);

        stage.setScene(calendarScene);
        stage.show();
    }
//    public void switchtoScene(String sceneName){
//        switch(sceneName){
//            case "CalendarApp":
//                CalendarApp calendarApp = new CalendarApp();
//                try {
//                    calendarApp.start(stage);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
//            case "HelloApplication":
//                HelloApplication helloApplication = new HelloApplication();
//                try {
//                    helloApplication.start(stage);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
//        }
//    }
}
