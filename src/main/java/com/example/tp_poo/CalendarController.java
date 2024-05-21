package com.example.tp_poo;

import com.calendarfx.view.CalendarView;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;

public class CalendarController {
    public VBox calendarContainer;
    private CalendarView calendarView;
    private ComboBox<String> appointmentTypeComboBox;

    public void initialize() {
        calendarView = new CalendarView();
        appointmentTypeComboBox = new ComboBox<>(FXCollections.observableArrayList("Consultation", "Atelier", "Séance de Suivi"));

        calendarView.setEntryDetailsPopOverContentCallback(param -> {
            MyentryView entry = (MyentryView) param.getEntry();
            appointmentTypeComboBox.setValue(entry.getAppointmentType());

            appointmentTypeComboBox.setOnAction(e -> {
                entry.setAppointmentType(appointmentTypeComboBox.getValue());
            });

            return new VBox(appointmentTypeComboBox);
        });

        calendarContainer.getChildren().add(calendarView);
    }

    public void addEntry() {
        MyentryView entry = new MyentryView("New Appointment", appointmentTypeComboBox.getValue());
        entry.setInterval(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        calendarView.getCalendarSources().get(0).getCalendars().get(0).addEntry(entry);
    }
}
