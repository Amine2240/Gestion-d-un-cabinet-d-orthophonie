package com.example.tp_poo;

// libraries that will help us to create the GUI of the application 01/05
import com.example.tp_poo.models.Orthophoniste;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    private static final String FILE_NAME = "orthophoniste.ser";
    private Orthophoniste orthophoniste;

    @Override
    public void start(Stage stage) throws IOException {
//        orthophoniste = SerializationUtil.deserializeOrthophoniste();
//        PatientDataManager patientDataManager;
//        AgendaManager agendaManager;
//        TestsEtAnamnesesController testsEtAnamnesesController;
//        if (orthophoniste == null) {
//             patientDataManager = PatientDataManager.getInstance();
//             agendaManager = AgendaManager.getInstance();
//            testsEtAnamnesesController = new TestsEtAnamnesesController();
//            orthophoniste = new Orthophoniste("kadoum", "amine", "ma_kadoum@esi.dz", "password", "adresse 123", "0552484650",  patientDataManager,  agendaManager, testsEtAnamnesesController );
//        }
        //OrthophonisteManager.loadOrthophoniste(); // deserialize Orthophoniste
       // PatientDataManager.setInstance(OrthophonisteManager.getOrthophoniste().getPatientDataManager());
       // AgendaManager.setInstance(OrthophonisteManager.getOrthophoniste().getAgendaManager());
;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("OrthoApp !");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() {
        // Serialize Orthophoniste on application exit
       // SerializationUtil.serializeOrthophoniste(orthophoniste);
//        OrthophonisteManager.getOrthophoniste().setAgendaManager(AgendaManager.getInstance());
//        OrthophonisteManager.getOrthophoniste().setPatientDataManager(PatientDataManager.getInstance());
        OrthophonisteManager.saveOrthophoniste();

    }


    public static void main(String[] args) {
        launch();
        System.out.println("hello java fx application");
    }
}