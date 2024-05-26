package com.example.tp_poo;


import com.example.tp_poo.models.StatisticsData;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class HelloController {

    @FXML
    private VBox chartContainer;

    @FXML
    private VBox barChartContainer;

    @FXML
    Button exportButton = new Button("exporter les graphes");

    @FXML
    private AnchorPane sideBarancherPane;

    @FXML
    public void initialize() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SideBarScene.fxml"));
        Parent sidebar = null;
        try {
            sidebar = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sideBarancherPane.getChildren().add(sidebar);
        // Create Pie Chart
        PieChart pieChart = new PieChart();

        // Set the title of the Pie Chart
        pieChart.setTitle("Pourcentage des patients par trouble");

        //-------------- Modification des noms des catégories --------------
        PieChart.Data slice1 = new PieChart.Data("Troubles de la déglutition", StatisticsData.getA());
        PieChart.Data slice2 = new PieChart.Data("Troubles neuro-développementaux", StatisticsData.getB());
        PieChart.Data slice3 = new PieChart.Data("Troubles cognitifs", StatisticsData.getC());
        //-------------- Fin de la modification des noms des catégories --------------

        pieChart.getData().addAll(slice1, slice2, slice3);

        // Set colors for the Pie Chart slices
        slice1.getNode().setStyle("-fx-pie-color: #ff6347;"); // Tomato
        slice2.getNode().setStyle("-fx-pie-color: #4682b4;"); // SteelBlue
        slice3.getNode().setStyle("-fx-pie-color: #3cb371;"); // MediumSeaGreen

        // Add Pie Chart to the VBox
        chartContainer.getChildren().add(pieChart);

        // Bind the values of PieChart.Data to the properties
        slice1.pieValueProperty().bind(StatisticsData.aProperty());
        slice2.pieValueProperty().bind(StatisticsData.bProperty());
        slice3.pieValueProperty().bind(StatisticsData.cProperty());

        // Create Bar Chart
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Type de trouble");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Nombre de patients");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Nombre de patients par trouble");

        // Create data series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Patients");

        //-------------- Ajout des données au Bar Chart --------------
        XYChart.Data<String, Number> bar1 = new XYChart.Data<>("Troubles de la déglutition", StatisticsData.getA());
        XYChart.Data<String, Number> bar2 = new XYChart.Data<>("Troubles neuro-développementaux", StatisticsData.getB());
        XYChart.Data<String, Number> bar3 = new XYChart.Data<>("Troubles cognitifs", StatisticsData.getC());

        series.getData().addAll(bar1, bar2, bar3);
        //-------------- Fin de l'ajout des données au Bar Chart --------------

        // Set colors for the Bar Chart bars
        bar1.nodeProperty().addListener((observable, oldValue, newValue) -> newValue.setStyle("-fx-bar-fill: #ff6347;")); // Tomato
        bar2.nodeProperty().addListener((observable, oldValue, newValue) -> newValue.setStyle("-fx-bar-fill: #4682b4;")); // SteelBlue
        bar3.nodeProperty().addListener((observable, oldValue, newValue) -> newValue.setStyle("-fx-bar-fill: #3cb371;")); // MediumSeaGreen

        barChart.getData().add(series);


        // Add Bar Chart to the VBox
        barChartContainer.getChildren().add(barChart);
        barChartContainer.getChildren().add(exportButton);
        exportButton.setOnAction(e -> {
            System.out.println("exporter les graphes");
            exportGraphs();
        });
    }
    private void exportGraphs() {
        // Create a WritableImage to hold the snapshot of the charts
        WritableImage image = new WritableImage((int) barChartContainer.getWidth(), (int) barChartContainer.getHeight());

        // Snapshot the VBox containing the charts
        barChartContainer.snapshot(new SnapshotParameters(), image);

        // Save the snapshot to a file
        File file = new File("graphs.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            System.out.println("Graphes exportés avec succès!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Échec de l'exportation des graphes.");
        }
    }
}
