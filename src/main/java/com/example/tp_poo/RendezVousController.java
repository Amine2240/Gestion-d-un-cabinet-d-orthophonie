package com.example.tp_poo;

import com.almasb.fxgl.time.LocalTimer;
import com.example.tp_poo.models.*;
import impl.com.calendarfx.view.NumericTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class RendezVousController implements Initializable {

    @FXML
    private TableView<Consultation> consulationsTable;


    LocalDate date1 = LocalDate.of(2000, 1, 1);
    LocalDate date2 = LocalDate.of(2001, 2, 2);
    LocalDate date3 = LocalDate.of(2002, 3, 3);
    LocalDate date4 = LocalDate.of(2003, 4, 4);
    LocalTime time1 = LocalTime.of(8, 0);
    LocalTime time2 = LocalTime.of(12, 0);
    LocalTime time3 = LocalTime.of(15, 0);
    LocalTime time4 = LocalTime.of(20, 0);

    LocalDate rendezVousdate1 = LocalDate.of(2024, 1, 1);
    LocalDate rendezVousdate2 = LocalDate.of(2024, 2, 2);
    LocalDate rendezVousdate3 = LocalDate.of(2024, 3, 3);
    LocalDate rendezVousdate4 = LocalDate.of(2024, 4, 4);

    Adulte p1 = new Adulte("John", "Doe", date1, "Paris", "123 Main St", "doctorat", "architecte", "0541177916");
    Enfant p2 = new Enfant("Jane", "Smith", date2, "London", "456 Elm St", "Secondary", "0552484650", "0541177916");
    Adulte p3 = new Adulte("Michael", "Johnson", date3, "New York", "789 Oak St", "bacallauriat", "ingenieur", "0541177916");
    Enfant p4 = new Enfant("Emily", "Brown", date4, "Berlin", "101 Pine St", "Secondary", "0552484650", "0541177916");

    // Create Enfant objects with real data
    Consultation c1 = new Consultation(TypePatient.ADULTE , rendezVousdate1 , time1 , p1);

    Consultation c2 = new Consultation(TypePatient.ENFANT , rendezVousdate2 , time2  , p2);
    Consultation c3 = new Consultation(TypePatient.ADULTE , rendezVousdate3 , time3  , p3);
    Consultation c4 = new Consultation(TypePatient.ENFANT , rendezVousdate4 , time4  , p4);

    List<Consultation> consultations = List.of(c1, c2, c3, c4 , c4);
    private Set<Consultation> consultationSet = new HashSet<>(consultations);

    @FXML
    private TableView<SeanceSuivi> seanceSuiviTable;
//    LocalDate date1 = LocalDate.of(2000, 1, 1);
//    LocalDate date2 = LocalDate.of(2001, 2, 2);
//    LocalDate date3 = LocalDate.of(2002, 3, 3);
//    LocalDate date4 = LocalDate.of(2003, 4, 4);

    // Create adulte objects with real data
    SeanceSuivi s1 = new SeanceSuivi(rendezVousdate1 , time1  , Deroulement.ENPRESENTIEL , p1);
    SeanceSuivi s2 = new SeanceSuivi(rendezVousdate2 , time2  , Deroulement.ENLIGNE, p2);
    SeanceSuivi s3 = new SeanceSuivi(rendezVousdate3 , time3  , Deroulement.ENPRESENTIEL, p3);
    SeanceSuivi s4 = new SeanceSuivi(rendezVousdate4 , time4  , Deroulement.ENLIGNE, p4);
    List<SeanceSuivi> seancesSuivis = List.of(s1, s2, s3, s4);

    @FXML
    private TableView<Atelier> atelierTable;

    @FXML
    private ChoiceBox<String> choixRendezVous;
    private String[] choix = {"Consultation" , "Seance Suivi" , "Atelier"};




    @FXML
    private TextField searchField;
    @FXML
    ImageView supprimerButtonview;
//Image image = new Image(getClass().getResourceAsStream("icons8-supprimer-30.png"));

    @FXML
    private Button ajouterRendezVousButton;

    RendezVous addedRendezVous = null;

    private TableView<Consultation> consultationsTable;
    private DatePicker dateConsultationPicker;
    private ComboBox<Integer> heureDebutHourPicker;
    private ComboBox<Integer> heureDebutMinutePicker;
    private TextField durationField;
    private TextField nomField;
    private TextField prenomField;
    private ChoiceBox<String> typePatient;
    private NumericTextField agefield;
    private TextField lieuNaissanceField;
    private TextField adresseField;
    private TextField diplomeField;
    private TextField professionField;
    private NumericTextField numeroTelField;
    private TextField classEtudesField;
    private NumericTextField numeroMereField;
    private NumericTextField numeroPereField;
    private LocalTime heuredebut;
    //private LocalTime heurefin;
    private ChoiceBox<String> deroulement;
    private NumericTextField numdossierfield;

    DossierPatient dossierPatient1 = new DossierPatient(p1 , null , null , null);
    DossierPatient dossierPatient2 = new DossierPatient(p2 , null , null , null);
    DossierPatient dossierPatient3 = new DossierPatient(p3 , null , null , null);
    DossierPatient dossierPatient4 = new DossierPatient(p4 , null , null , null);
    List<DossierPatient> dossierPatients = List.of(dossierPatient1, dossierPatient2, dossierPatient3, dossierPatient4);

    public void initialize(URL url, ResourceBundle resourceBundle) {
        choixRendezVous.getItems().addAll(choix);
        choixRendezVous.setValue("Consultation"); // initial to avoid null
        choixRendezVous.setOnAction(this::choixRendezVousAction);
//        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
//            // Call method to filter TableView based on search query
//            filterTableView(newValue); // based on query
//        });
        p1.setDossierPatient(dossierPatient1);
        p2.setDossierPatient(dossierPatient2);
        p3.setDossierPatient(dossierPatient3);
        p4.setDossierPatient(dossierPatient4);

    }
    private void addConsultations(List<Consultation> consultations) {
        for (Consultation consultation : consultations) {
            if (consultationSet.add(consultation)) {
                consultations.add(consultation);
            }
        }
    }
    public void generateConsultationsTable(){
        if (!seanceSuiviTable.getItems().isEmpty()) {
            seanceSuiviTable.getItems().clear();
            seanceSuiviTable.getColumns().clear();
        }
      if (!atelierTable.getItems().isEmpty()) {
            atelierTable.getItems().clear();
            atelierTable.getColumns().clear();
        }
        //addConsultations(consultations);
        consulationsTable.getItems().addAll(consultations);

        consulationsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Callback<TableColumn<Consultation, String>, TableCell<Consultation, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<Consultation, String> call(TableColumn<Consultation, String> column) {
                        return new TableCell<>() {
                            @Override
                            protected void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item);
                                }
                            }
                        };
                    }
                };

        TableColumn<Consultation, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty( data != null ? data.getValue().getDate().toString() : "N/A"));
        dateColumn.setCellFactory(cellFactory);

        TableColumn<Consultation, String> heureDebutColumn = new TableColumn<>("Heure Debut");
        heureDebutColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHeureDebut().toString()));
        heureDebutColumn.setCellFactory(cellFactory);

        TableColumn<Consultation, String> heureFinColumn = new TableColumn<>("heure Fin");
        heureFinColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getHeureDebut().plus(data.getValue().getDuree())) ));
        heureFinColumn.setCellFactory(cellFactory);

        TableColumn<Consultation, String> nomPatientColumn = new TableColumn<>("Nom patient");
        nomPatientColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getNom()));
        nomPatientColumn.setCellFactory(cellFactory);

        TableColumn<Consultation, String> prenomPatientColumn = new TableColumn<>("prenom patient");
        prenomPatientColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getPrenom()));
        prenomPatientColumn.setCellFactory(cellFactory);

        TableColumn<Consultation, String> agePatientColumn = new TableColumn<>("age patient");
        agePatientColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(2024-data.getValue().getPatient().getDateNaissance().getYear()) ));
        agePatientColumn.setCellFactory(cellFactory);

    TableColumn<Consultation, String> typePatientColumn = new TableColumn<>("Type patient");
        typePatientColumn.setCellValueFactory(data -> new SimpleStringProperty(Patient.identifyPatient(data.getValue().getPatient())));
        typePatientColumn.setCellFactory(cellFactory);

        TableColumn<Consultation, String> supprimerButtonColumn = new TableColumn<>("");
        // supprimerButtonColumn.setCellValueFactory(data -> supprimerButton);
        supprimerButtonColumn.setCellFactory(new Callback<TableColumn<Consultation, String>, TableCell<Consultation, String>>() {
            @Override
            public TableCell<Consultation, String> call(TableColumn<Consultation, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("Supprimer");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Confirmation de suppression");
                                alert.setHeaderText("Confirmer la suppression");
                                alert.setContentText("Voulez-vous vraiment supprimer ce patient?");
                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.isPresent() && result.get() == ButtonType.OK) {
                                    Consultation consultation= getTableView().getItems().get(getIndex());
                                    getTableView().getItems().remove(consultation);
                                    // Optionally, add code to remove patient from the database or other data structures
                                }


                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });



        consulationsTable.getColumns().addAll(dateColumn, heureDebutColumn , heureFinColumn, nomPatientColumn, prenomPatientColumn , agePatientColumn, typePatientColumn , supprimerButtonColumn);

        System.out.println("Consultations table generated");
    }
    public void generateSeancesSuivisTable(){
        if (!consulationsTable.getItems().isEmpty()) {
            consulationsTable.getItems().clear();
            consulationsTable.getColumns().clear();

        }
        if (!atelierTable.getItems().isEmpty()) {
            atelierTable.getItems().clear();
            atelierTable.getColumns().clear();
        }
        seanceSuiviTable.getItems().addAll(seancesSuivis);

        seanceSuiviTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Callback<TableColumn<SeanceSuivi, String>, TableCell<SeanceSuivi, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<SeanceSuivi, String> call(TableColumn<SeanceSuivi, String> column) {
                        return new TableCell<>() {
                            @Override
                            protected void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item);
                                }
                            }
                        };
                    }
                };

        TableColumn<SeanceSuivi, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate().toString()));
        dateColumn.setCellFactory(cellFactory);

        TableColumn<SeanceSuivi, String> heureDebutColumn = new TableColumn<>("Heure Debut");
        heureDebutColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHeureDebut().toString()));
        heureDebutColumn.setCellFactory(cellFactory);

        TableColumn<SeanceSuivi, String> heureFinColumn = new TableColumn<>("heure Fin");
        heureFinColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getHeureDebut().plus(data.getValue().getDuree()))));
        heureFinColumn.setCellFactory(cellFactory);

        TableColumn<SeanceSuivi, String> numDossierPatientColumn = new TableColumn<>("num Dossier Patient");
        numDossierPatientColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getPatient().getDossierPatient().getNumeroDossier())));

        numDossierPatientColumn.setCellFactory(cellFactory);

        TableColumn<SeanceSuivi, String> deroulementColumn = new TableColumn<>("deroulement");
        deroulementColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTypeSeance().toString()));
        deroulementColumn.setCellFactory(cellFactory);

        TableColumn<SeanceSuivi, String> supprimerButtonColumn = new TableColumn<>("");
        // supprimerButtonColumn.setCellValueFactory(data -> supprimerButton);
        supprimerButtonColumn.setCellFactory(new Callback<TableColumn<SeanceSuivi, String>, TableCell<SeanceSuivi, String>>() {
            @Override
            public TableCell<SeanceSuivi, String> call(TableColumn<SeanceSuivi, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("Supprimer");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Confirmation de suppression");
                                alert.setHeaderText("Confirmer la suppression");
                                alert.setContentText("Voulez-vous vraiment supprimer ce patient?");
                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.isPresent() && result.get() == ButtonType.OK) {
                                    SeanceSuivi seanceSuivi = getTableView().getItems().get(getIndex());
                                    getTableView().getItems().remove(seanceSuivi);
                                    // Optionally, add code to remove patient from the database or other data structures
                                }


                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });

        seanceSuiviTable.getColumns().addAll(dateColumn, heureDebutColumn , heureFinColumn, numDossierPatientColumn, deroulementColumn, supprimerButtonColumn);
    }
    public void generateAteliersTable(){
        if (!consulationsTable.getItems().isEmpty()) {
            consulationsTable.getItems().clear();
            consulationsTable.getColumns().clear();

        }
        if (!seanceSuiviTable.getItems().isEmpty()) {
            seanceSuiviTable.getItems().clear();
            seanceSuiviTable.getColumns().clear();
        }
    }
    public void choixRendezVousAction(ActionEvent event){

        String choix = choixRendezVous.getValue();
        if(choix.equals("Seance Suivi")){
            generateSeancesSuivisTable();
            consulationsTable.setVisible(false);
            atelierTable.setVisible(false);
            seanceSuiviTable.setVisible(true);
            searchField.setPromptText("Search seance suivi by name or prenom");
            ajouterRendezVousButton.setText("Ajouter Seance Suivi");
        }
        else if(choix.equals("Consultation")){
            generateConsultationsTable();
            seanceSuiviTable.setVisible(false);
            atelierTable.setVisible(false);
            consulationsTable.setVisible(true);
            searchField.setPromptText("Search consultation by name or prenom");
            ajouterRendezVousButton.setText("Ajouter Consultation");
        }
        else if(choix.equals("Atelier")){
            generateAteliersTable();
            seanceSuiviTable.setVisible(false);
            consulationsTable.setVisible(false);
            atelierTable.setVisible(true);
            searchField.setPromptText("Search atelier by name or prenom");
            ajouterRendezVousButton.setText("Ajouter atelier");
        }
    }
    public void showDialog(ActionEvent event) {

        Dialog dialog = new Dialog();
//        dialog.getDialogPane().heightProperty().addListener((obs, oldHeight, newHeight) -> {
//            dialog.setHeight(newHeight.doubleValue() + 50); // Adjust for padding and buttons
//        });
        dialog.setTitle("Ajouter un rendez vous patient");
        if (choixRendezVous.getValue().equals("Seance Suivi")) {
            dialog.setHeaderText("Ajouter seance suivi");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(480, 320);
            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            dialog.getDialogPane().setContent(createseanceSuiviContent());
            Optional result = dialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (getDossierPatientByNumero(Integer.valueOf(numdossierfield.getText())) == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur de recherche");
                    alert.setHeaderText("Patient introuvable");
                    alert.setContentText("Numero dossier patient introuvable");
                    alert.showAndWait();
                }else {
                    if (deroulement.getValue().equals("EN PRESENTIEL")) {
                        addedRendezVous = new SeanceSuivi(dateConsultationPicker.getValue(), heuredebut, Deroulement.ENPRESENTIEL, getDossierPatientByNumero(Integer.valueOf(numdossierfield.getText())).getPatient());

                    } else if (deroulement.getValue().equals("EN LIGNE")) {
                        addedRendezVous = new SeanceSuivi(dateConsultationPicker.getValue(), heuredebut, Deroulement.ENLIGNE, getDossierPatientByNumero(Integer.valueOf(numdossierfield.getText())).getPatient());
                    }
                    seanceSuiviTable.getItems().add((SeanceSuivi) addedRendezVous);
                }


            }
        } else if (choixRendezVous.getValue().equals("Consultation")) {
            dialog.setHeaderText("Ajouter consultation ");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(480, 320);
            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            dialog.getDialogPane().setContent(createconsultationContent());
            Optional result = dialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (typePatient.getValue().equals("Enfant")) {
                    addedRendezVous = new Consultation(TypePatient.ENFANT, dateConsultationPicker.getValue(), heuredebut, new Enfant(nomField.getText(), prenomField.getText(), date2, lieuNaissanceField.getText(), adresseField.getText(), classEtudesField.getText(), numeroMereField.getText(), numeroPereField.getText()));

                } else if (typePatient.getValue().equals("Adulte")) {

                    addedRendezVous = new Consultation(TypePatient.ADULTE, dateConsultationPicker.getValue(), heuredebut, new Adulte(nomField.getText(), prenomField.getText(), date1, lieuNaissanceField.getText(), adresseField.getText(), diplomeField.getText(), professionField.getText(), numeroTelField.getText()));



                }
               // consulationsTable.getItems().add((Consultation) addedRendezVous);
                addConsultation((Consultation) addedRendezVous);
            }} else if (choixRendezVous.getValue().equals("Atelier")) {
                dialog.setHeaderText("Ajouter atelier");
                dialog.setResizable(true);
                dialog.getDialogPane().setPrefSize(480, 320);
                dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                dialog.getDialogPane().setContent(createAtelierContent());
                Optional result2 = dialog.showAndWait();
                if (result2.isPresent() && result2.get() == ButtonType.OK) {

                    atelierTable.getItems().add((Atelier) addedRendezVous);

                }
            }



    }
    public DossierPatient getDossierPatientByNumero(int numeroDossier){
        for (DossierPatient dossierPatient : dossierPatients) {
            if (dossierPatient.getNumeroDossier() == numeroDossier) {
                return dossierPatient;
            }
        }
        return null;

    }
    private void addConsultation(Consultation consultation) {

            if (consultationSet.add(consultation)) {
                consulationsTable.getItems().add(consultation);
            }

    }
    private Node createconsultationContent() {


            // Create a VBox to hold the form elements
            VBox vbox = new VBox();
            vbox.setSpacing(10);
            vbox.setPadding(new Insets(10, 10, 10, 10));

            // Create the form elements


            dateConsultationPicker = new DatePicker();
            dateConsultationPicker.setPromptText("date consultation");
            HBox hbox = new HBox();
            Label heuredebutlabel = new Label("Heure debut : ");
            heureDebutHourPicker = new ComboBox<>();
            for (int i = 0; i < 24; i++) {
                heureDebutHourPicker.getItems().add(i);
            }
            heureDebutHourPicker.setValue(8);  // default value
             Label heuredebutlabel2 = new Label(" : ");
            heureDebutMinutePicker = new ComboBox<>();
            for (int i = 0; i < 60; i += 5) {  // you can change the step as needed
                heureDebutMinutePicker.getItems().add(i);
            }
            heureDebutMinutePicker.setValue(0);
        heureDebutHourPicker.setOnAction(e -> {
            heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
        });
        heureDebutMinutePicker.setOnAction(e -> {
            heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
        });
            hbox.getChildren().addAll( heuredebutlabel, heureDebutHourPicker , heuredebutlabel2, heureDebutMinutePicker);
            durationField = new TextField();

            nomField = new TextField();
            nomField.setPromptText("Nom patient");
            prenomField = new TextField();
            prenomField.setPromptText("Prenom patient");
            typePatient = new ChoiceBox<>();
            typePatient.getItems().addAll("Enfant", "Adulte");
            typePatient.setValue("Enfant");
            agefield = new NumericTextField();
            agefield.setPromptText("Age patient");
            lieuNaissanceField = new TextField();
            lieuNaissanceField.setPromptText("Lieu Naissance");
            adresseField = new TextField();
            adresseField.setPromptText("Adresse");
            vbox.getChildren().addAll(dateConsultationPicker, hbox, durationField, nomField, prenomField, typePatient, agefield, lieuNaissanceField, adresseField);
            VBox vboxadulte = new VBox();
            VBox vboxenfant = new VBox();
            typePatient.setOnAction(e -> {
                vbox.getChildren().removeAll(vboxadulte, vboxenfant);
                if (typePatient.getValue().equals("Adulte")) {
                    durationField.setText("duree consultation : 1h30");
                    durationField.setEditable(false);
                    typePatient.setValue("Adulte");
                    vboxenfant.getChildren().clear();
                    vboxadulte.setSpacing(10);
                    vboxadulte.setPadding(new Insets(0, 0, 10, 0));
                    professionField = new TextField();
                    professionField.setPromptText("Profession");
                    diplomeField = new TextField();
                    diplomeField.setPromptText("Diplome");
                    numeroTelField = new NumericTextField();
                    numeroTelField.setPromptText("Numero Tel");
                    vboxadulte.getChildren().addAll(professionField, diplomeField, numeroTelField);
                    vbox.getChildren().addAll(vboxadulte);
                   // heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
                   // heurefin = heuredebut.plusMinutes(90);
                   // addedRendezVous = new Consultation(TypePatient.ADULTE, dateConsultationPicker.getValue(), heuredebut, new Adulte(nomField.getText(), prenomField.getText(), date1, lieuNaissanceField.getText(), adresseField.getText(), diplomeField.getText(), professionField.getText(), numeroTelField.getText()));


                } else if (typePatient.getValue().equals("Enfant")) {
                    durationField.setText("duree consultation : 2h30");
                    durationField.setEditable(false);
                    typePatient.setValue("Enfant");
                    vboxadulte.getChildren().clear();
                    vboxenfant.setSpacing(10);
                    vboxenfant.setPadding(new Insets(0, 0, 10, 0));
                    classEtudesField = new TextField();
                    classEtudesField.setPromptText("Classe Etudes");
                    numeroMereField = new NumericTextField();
                    numeroMereField.setPromptText("Numero Mere");
                    numeroPereField = new NumericTextField();
                    numeroPereField.setPromptText("Numero Pere");
                    vboxenfant.getChildren().addAll(classEtudesField, numeroMereField, numeroPereField);
                    vbox.getChildren().addAll(vboxenfant);
                   // heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
                   // heurefin = heuredebut.plusMinutes(150);
                    //addedRendezVous =  new Consultation(TypePatient.ENFANT, dateConsultationPicker.getValue(), heuredebut, heurefin, new Enfant(nomField.getText(), prenomField.getText(), date2, lieuNaissanceField.getText(), adresseField.getText(), classEtudesField.getText(), numeroMereField.getText(), numeroPereField.getText()));

                }

            });


            return vbox;
        }

    private Node createseanceSuiviContent(){
        // Create a VBox to hold the form elements
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        // Create the form elements


        dateConsultationPicker = new DatePicker();
        dateConsultationPicker.setPromptText("date seance suivi");
        HBox hbox = new HBox();
        Label heuredebutlabel = new Label("Heure debut : ");
        heureDebutHourPicker = new ComboBox<>();
        for (int i = 0; i < 24; i++) {
            heureDebutHourPicker.getItems().add(i);
        }
        heureDebutHourPicker.setValue(8);  // default value
        Label heuredebutlabel2 = new Label(" : ");
        heureDebutMinutePicker = new ComboBox<>();
        for (int i = 0; i < 60; i += 5) {  // you can change the step as needed
            heureDebutMinutePicker.getItems().add(i);
        }
        heureDebutMinutePicker.setValue(0);
        heureDebutHourPicker.setOnAction(e -> {
            heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
        });
        heureDebutMinutePicker.setOnAction(e -> {
            heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
        });
        hbox.getChildren().addAll( heuredebutlabel, heureDebutHourPicker , heuredebutlabel2, heureDebutMinutePicker);
        durationField = new TextField();
        durationField.setText("duree seance suivi : 1h");
        durationField.setEditable(false);

        deroulement = new ChoiceBox<>();
        deroulement.getItems().addAll("EN PRESENTIEL", "EN LIGNE");
        deroulement.setValue("EN PRESENTIEL");
        numdossierfield = new NumericTextField();
        numdossierfield.setPromptText("Numero Dossier Patient");

        vbox.getChildren().addAll(dateConsultationPicker, hbox, durationField,  deroulement , numdossierfield);

        //heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
        return vbox;
    }
    private Node createAtelierContent(){
        return null;
    }

    public void switchToLoginScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScene.fxml")));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private Stage stage;
    public void switchToCalendar(ActionEvent event) throws IOException{
        Mycalendar calendarView = new Mycalendar();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene calendarScene = new Scene(calendarView.getRoot(), 1300, 1000);

        stage.setScene(calendarScene);
        stage.show();
    }
}

