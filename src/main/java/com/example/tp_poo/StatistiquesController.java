package com.example.tp_poo;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class StatistiquesController {
    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private Button exportButton;

    @FXML
    void initialize() {
        // Initialize the bar chart with some data
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        barChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("A", 10));
        series1.getData().add(new XYChart.Data<>("B", 20));
        series1.getData().add(new XYChart.Data<>("C", 30));

        barChart.getData().add(series1);
    }

    @FXML
    void handleExport(ActionEvent event) {
        // Create a snapshot parameters object
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setDepthBuffer(true);

        // Capture the bar chart as an image
        WritableImage snapshot = barChart.snapshot(parameters, null);

        // Choose a file to save the image
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        File file = fileChooser.showSaveDialog(exportButton.getScene().getWindow());

        if (file != null) {
            // Write the image to the chosen file
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
                showAlert("Success", "Chart exported successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to export chart.");
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
