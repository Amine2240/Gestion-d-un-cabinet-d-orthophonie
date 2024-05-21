package com.example.tp_poo;

import com.calendarfx.model.Entry;
import com.calendarfx.view.EntryViewBase;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MyentryView extends Entry<String> {
    private String appointmentType;
    protected MyentryView(String title , String appointmentType) {
        super(title);
        //createMyView(entry);
        this.appointmentType = appointmentType;
    }
    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
    private void createMyView(Entry<?> entry) {
        VBox vbox = new VBox();

        // Create Labels for entry details
        Label titleLabel = new Label(entry.getTitle());
        Label startLabel = new Label("Start: " + entry.getStartTime().toString());
        Label endLabel = new Label("End: " + entry.getEndTime().toString());

        // Create a ChoiceBox with the specified options
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Consultation (1h30)", "Atelier", "Seance Suivi");

        // Add all elements to the VBox
        vbox.getChildren().addAll(titleLabel, startLabel, endLabel, choiceBox);

        // Set the VBox as the graphic of the EntryView
       // setGraphic(vbox);
        //getChildren().add(vbox);
    }
}
