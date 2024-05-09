package com.example.tp_poo;

import com.calendarfx.view.CalendarView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignupController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Button signupButton;
    public TextField username;
    public PasswordField password;
    public Label errorLabel;

//    public void signup() {
//
//    }
    public void showCalendarScene(ActionEvent event) throws IOException {
        // Create and show the calendar scene

        if (username.getText().equals("admin") && password.getText().equals("admin")) {
            Mycalendar calendarView = new Mycalendar();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene calendarScene = new Scene(calendarView.getRoot(), 1300, 1000);

            stage.setScene(calendarScene);
            stage.show();
        }
        else {
            errorLabel.setText("Invalid username or password");

        }
    }

    public void switchToLoginScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginScene.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
