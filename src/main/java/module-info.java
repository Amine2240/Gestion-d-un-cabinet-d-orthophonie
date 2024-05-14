module com.example.tp_poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires com.calendarfx.view;
    requires java.desktop;
    requires javafx.swing;
    // requires de.jensd.fx.fontawesomefx.fontawesome;

    opens com.example.tp_poo to javafx.fxml;
    exports com.example.tp_poo;
    //exports com.example.tp_poo.controllers;
    //opens com.example.tp_poo.controllers to javafx.fxml;
}