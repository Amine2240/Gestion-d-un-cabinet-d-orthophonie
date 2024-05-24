package com.example.tp_poo;

import com.example.tp_poo.models.Adulte;
import com.example.tp_poo.models.DossierPatient;
import com.example.tp_poo.models.Enfant;
import com.example.tp_poo.models.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DossierPatientController implements Initializable {



   private Image image = new Image("file:src/main/resources/com/example/tp_poo/assets/icons8-utilisateur-90.png");


    @FXML
    private ImageView imageView = new ImageView();

    @FXML
    private Label nameLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label dateNaissanceLabel;
    @FXML
    private Label lieuNaissanceLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label classeEtudeOuprofessionLabel;
    @FXML
    private Label telephoneMereOutelephoneLabel;
    @FXML
    private Label telephonePereOudiplomeLabel;

    @FXML
    private Label dossierNumberLabel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView.setImage(image);

    }
    public void switchToLoginScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScene.fxml")));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToCalendar(ActionEvent event) throws IOException{
        Mycalendar calendarView = new Mycalendar();
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene calendarScene = new Scene(calendarView.getRoot(), 1300, 1000);

        stage.setScene(calendarScene);
        stage.show();
    }
    public void allerVersListsPatients(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PatientsScene.fxml")));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setPatientDetails(DossierPatient dossierPatient) {
        dossierNumberLabel.setText("Dossier Patient n°=: " + dossierPatient.getNumeroDossier());
        nameLabel.setText("Nom: " + dossierPatient.getPatient().getNom());
        prenomLabel.setText("Prenom: " + dossierPatient.getPatient().getPrenom());
        dateNaissanceLabel.setText("Date de naissance: " + dossierPatient.getPatient().getDateNaissance());
        lieuNaissanceLabel.setText("Lieu de naissance: " + dossierPatient.getPatient().getLieuNaissance());
        addressLabel.setText("Addresse: " + dossierPatient.getPatient().getAdresse());
        if (dossierPatient.getPatient() instanceof Enfant) {
            classeEtudeOuprofessionLabel.setText("Classe d'etude: " + ((Enfant) dossierPatient.getPatient()).getClassEtudes());
            telephonePereOudiplomeLabel.setText("Numero de pere: " + ((Enfant) dossierPatient.getPatient()).getNumeroPere());
            telephoneMereOutelephoneLabel.setText("Numero de mere: " + ((Enfant) dossierPatient.getPatient()).getNumeroMere());
        } else {
            classeEtudeOuprofessionLabel.setText("Profession: " + ((Adulte) dossierPatient.getPatient()).getProfession());
            telephoneMereOutelephoneLabel.setText("Telephone: " + ((Adulte) dossierPatient.getPatient()).getNumeroTel());
            telephonePereOudiplomeLabel.setText("Diplome: " + ((Adulte) dossierPatient.getPatient()).getDiplome());
        }
    }
}
