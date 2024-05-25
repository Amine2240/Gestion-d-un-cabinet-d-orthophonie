package com.example.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginScene.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void allerVersAgenda(ActionEvent event) throws IOException {
//        Mycalendar calendarView = new Mycalendar();
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene calendarScene = new Scene(calendarView.getRoot(), 1300, 1000);
//
//        stage.setScene(calendarScene);
//        stage.show();
//    }
    public void allerVersPatients(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PatientsScene.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void allerVersStatistiques(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StatistiquesScene.fxml")));
//        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
public void allerVersStatistiques(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
    public void allerVersTestsEtAnamnese(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TestsEtAnamnesesScene.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void allerVersParametres(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ParametresScene.fxml")));
       stage =(Stage)((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }
   public void allerVersRendezVous(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RendezVousScene.fxml")));
       stage =(Stage)((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }
}
