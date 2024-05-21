package com.example.tp_poo;

import com.calendarfx.view.CalendarView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



import java.io.IOException;
import java.util.Objects;

public class Mycalendar extends CalendarView {// ou bien lextrendre de CalendarView
   /// private CalendarView calendarView;
    private BorderPane root;
    private Button mybutton;

    public Mycalendar() {
        // Initialize the calendar view
       // calendarView = new CalendarView();

        // Initialize the root BorderPane
        root = new BorderPane();

        // Initialize the logout button
        mybutton = new Button("Patients");
        mybutton.setStyle("-fx-background-color: green");

        // Set action for the logout button
        mybutton.setOnAction(e -> {
            try {
               // switchToSignupScene(e);
                switchToPatientScene(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        // Set the logout button at the top of the BorderPane
        root.setTop(mybutton);

        // Set the calendar view at the center of the BorderPane
        root.setCenter(this);
       // this.setEntryDetailsPopOverContentCallback(entry ->new MyentryView(entry.getEntry()));
    }

    private void switchToSignupScene(ActionEvent event) throws IOException {
        // Implement your logic to switch to the signup scene here
    }
    public void switchToPatientScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PatientsScene.fxml")));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Parent getRoot() {
        return root;
    }

    // You can add more methods as needed to interact with the calendar and the logout button
}

