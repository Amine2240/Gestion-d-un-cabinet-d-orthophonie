package com.example.tp_poo;

import com.almasb.fxgl.time.LocalTimer;
import com.example.tp_poo.models.*;
import impl.com.calendarfx.view.NumericTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
    private TableView<Consultation> consulationsTable = new TableView<>();


    LocalDate date1 = LocalDate.of(2000, 1, 1);
    LocalDate date2 = LocalDate.of(2001, 2, 2);
    LocalDate date3 = LocalDate.of(2002, 3, 3);
    LocalDate date4 = LocalDate.of(2003, 4, 4);
    LocalTime time1 = LocalTime.of(8, 0);
    LocalTime time2 = LocalTime.of(9, 30);
    LocalTime time3 = LocalTime.of(11,0 );
    LocalTime time4 = LocalTime.of(13, 0);
    LocalTime time5 = LocalTime.of(15, 30);
    LocalTime time6 = LocalTime.of(18, 0);
    LocalTime time7 = LocalTime.of(19, 0);
    LocalTime time8 = LocalTime.of(21, 0);

    LocalDate rendezVousdate1 = LocalDate.of(2024, 1, 1);
    LocalDate rendezVousdate2 = LocalDate.of(2024, 2, 2);
    LocalDate rendezVousdate3 = LocalDate.of(2024, 3, 3);
    LocalDate rendezVousdate4 = LocalDate.of(2024, 4, 4);

    Adulte p1 = new Adulte("John", "Doe", 25);
    Enfant p2 = new Enfant("Jane", "Smith", 10);
    Adulte p3 = new Adulte("Michael", "Johnson", 35);
    Enfant p4 = new Enfant("Emily", "Brown", 13);

//    Adulte p1 = new Adulte("John", "Doe", date1, "Paris", "123 Main St", "doctorat", "architecte", "0541177916");
//    Enfant p2 = new Enfant("Jane", "Smith", date2, "London", "456 Elm St", "Secondary", "0552484650", "0541177916");
//    Adulte p3 = new Adulte("Michael", "Johnson", date3, "New York", "789 Oak St", "bacallauriat", "ingenieur", "0541177916");
//    Enfant p4 = new Enfant("Emily", "Brown", date4, "Berlin", "101 Pine St", "Secondary", "0552484650", "0541177916");

    // Create Enfant objects with real data
    Consultation c1 = new Consultation(TypePatient.ADULTE , rendezVousdate1 , time1 , p1);

    Consultation c2 = new Consultation(TypePatient.ENFANT , rendezVousdate2 , time4  , p2);
    Consultation c3 = new Consultation(TypePatient.ADULTE , rendezVousdate3 , time2  , p3);
    Consultation c4 = new Consultation(TypePatient.ENFANT , rendezVousdate4 , time5  , p4);

    List<Consultation> consultations = new ArrayList<>(List.of(c1, c2, c3, c4 )) ;
    //private Set<Consultation> consultationSet = new HashSet<>(consultations);

    @FXML
    private TableView<SeanceSuivi> seanceSuiviTable = new TableView<>();
//    LocalDate date1 = LocalDate.of(2000, 1, 1);
//    LocalDate date2 = LocalDate.of(2001, 2, 2);
//    LocalDate date3 = LocalDate.of(2002, 3, 3);
//    LocalDate date4 = LocalDate.of(2003, 4, 4);

    // Create adulte objects with real data
    SeanceSuivi s1 = new SeanceSuivi(rendezVousdate1 , time6  , Deroulement.ENPRESENTIEL , p1);
    SeanceSuivi s2 = new SeanceSuivi(rendezVousdate2 , time7  , Deroulement.ENLIGNE, p2);
    SeanceSuivi s3 = new SeanceSuivi(rendezVousdate3 , time8  , Deroulement.ENPRESENTIEL, p3);
    SeanceSuivi s4 = new SeanceSuivi(rendezVousdate4 , time3  , Deroulement.ENLIGNE, p4);
    List<SeanceSuivi> seancesSuivis = new ArrayList<>(List.of(s1, s2, s3, s4)) ;

    @FXML
    private TableView<Atelier> atelierTable = new TableView<>();

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
    private DatePicker dateConsultationPicker = new DatePicker();
    private ComboBox<Integer> heureDebutHourPicker = new ComboBox<>();
    private ComboBox<Integer> heureDebutMinutePicker = new ComboBox<>();
    private TextField durationField = new TextField();
    private TextField nomField =  new TextField();;
    private TextField prenomField = new TextField();;
    private ChoiceBox<String> typePatient = new ChoiceBox<>();
    private NumericTextField agefield= new NumericTextField();;
    private TextField lieuNaissanceField  = new TextField();
    private TextField adresseField  = new TextField();
    private TextField diplomeField  = new TextField();
    private TextField professionField  = new TextField();
    private NumericTextField numeroTelField  = new NumericTextField();
    private TextField classEtudesField  = new TextField();
    private NumericTextField numeroMereField  = new NumericTextField();
    private NumericTextField numeroPereField  = new NumericTextField();
    private LocalTime heuredebut;
    //private LocalTime heurefin;
    private ChoiceBox<String> deroulement = new ChoiceBox<>();
    private NumericTextField numdossierfield  = new NumericTextField();

    DossierPatient dossierPatient1 = new DossierPatient(p1 , null , null , null);
    DossierPatient dossierPatient2 = new DossierPatient(p2 , null , null , null);
    DossierPatient dossierPatient3 = new DossierPatient(p3 , null , null , null);
    DossierPatient dossierPatient4 = new DossierPatient(p4 , null , null , null);
    List<DossierPatient> dossierPatients = List.of(dossierPatient1, dossierPatient2, dossierPatient3, dossierPatient4);

    List<RendezVous> rendezVousList = new ArrayList<>(List.of(c1, c2, c3, c4 , s1 , s2 , s3 , s4 ));


    TestsEtAnamnesesController testsEtAnamnesesController = new TestsEtAnamnesesController();
    ObservableList<QuestionAnamnese> anamneses1 = FXCollections.observableArrayList(
            new QuestionAnamnese("QuestionAnamnese 1 enouncé", Categories.ANTECEDENTS_FAMILIAUX),
            new QuestionAnamnese("QuestionAnamnese 2 enouncé", Categories.CARACTERE),
            new QuestionAnamnese("QuestionAnamnese 3 enouncé", Categories.CONDITIONS_NATALES)
            // Add more questions with answers as needed
    );
    ArrayList<QuestionAnamnese> listanamneses1 = new ArrayList<>(anamneses1);
    AnamneseEnfant testAnamnese1 = new AnamneseEnfant( "test anamnese 1",listanamneses1);
    ObservableList<Exercice> exercices1 = FXCollections.observableArrayList(
            new Exercice("Exercice 1 ", "Exercice 1 consigne", "Exercice 1 materiel"),
            new Exercice("Exercice 2 ", "Exercice 2 consigne", "Exercice 2 materiel"),
            new Exercice("Exercice 3 ", "Exercice 3 consigne", "Exercice 3 materiel")

            // Add more questions with answers as needed
    );
    ArrayList<Exercice> listexercices1 = new ArrayList<>(exercices1);
    TestExerices testExerices1 = new TestExerices("test exercice 1 ", "orthophonisite observation 1 ", listexercices1);
    ObservableList<QuestionRpsLibres>  questionsRpsLibres1 = FXCollections.observableArrayList(
            new QuestionRpsLibres("QuestionRpsLibres 1 enouncé"),
            new QuestionRpsLibres("QuestionRpsLibres 2 enouncé"),
            new QuestionRpsLibres("QuestionQcm 3 enouncé")
            // Add more questions with answers as needed
    );
    Set<QuestionRpsLibres> questionsRpsLibresSet1 = new HashSet<>(questionsRpsLibres1);
    TestRpsLibres testRpsLibres1 = new TestRpsLibres(questionsRpsLibresSet1,"test RpsLibres 1", " orthogonisteObservation 1 ");

    ObservableList<QuestionQcm>  questionsQcm1 = FXCollections.observableArrayList(
            new QuestionQcm("QuestionQcm 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
            new QuestionQcm("QuestionQcm 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
            new QuestionQcm("QuestionQcm 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2"))
            // Add more questions with answers as needed
    );
    Set<QuestionQcm> questionsQcmSet1 = new HashSet<>(questionsQcm1);
    TestQcm testqcm1 = new TestQcm(questionsQcmSet1,"test qcm 1", " orthogonisteObservation 1 ");

    ObservableList<QuestionQcu>  questionsQcu1 = FXCollections.observableArrayList(
            new QuestionQcu("QuestionQcu 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 1"),
            new QuestionQcu("QuestionQcu 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 2"),
            new QuestionQcu("QuestionQcu 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 3")
            // Add more questions with answers as needed
    );
    Set<QuestionQcu> questionsQcuSet1 = new HashSet<>(questionsQcu1);
    TestQcu testqcu1 = new TestQcu(questionsQcuSet1,"test qcu 1", " orthogonisteObservation 1 ");


//    GenerateTabeController generateTableController = new GenerateTabeController( consulationsTable,  dateConsultationPicker,  heureDebutHourPicker,  heureDebutMinutePicker,  durationField,  seanceSuiviTable,  atelierTable,  consultations,  testAnamnese1,  testqcm1,  testqcu1,  testRpsLibres1,  testExerices1,  testsEtAnamnesesController);

    DialogController dialogController = new DialogController(testsEtAnamnesesController, testAnamnese1, testqcu1, testqcm1, testRpsLibres1, testExerices1);
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
        agePatientColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getPatient().getAge()) ));
        agePatientColumn.setCellFactory(cellFactory);

        TableColumn<Consultation, String> typePatientColumn = new TableColumn<>("Type patient");
        typePatientColumn.setCellValueFactory(data -> new SimpleStringProperty(Patient.identifyPatient(data.getValue().getPatient())));
        typePatientColumn.setCellFactory(cellFactory);

        TableColumn<Consultation, String> faireConsultationColumn = new TableColumn<>("");
        faireConsultationColumn.setCellFactory(new Callback<TableColumn<Consultation, String>, TableCell<Consultation, String>>() {
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
                            Button button = new Button("faire consultation");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                showFaireConsultationDialog(e);

                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });

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



        consulationsTable.getColumns().addAll(dateColumn, heureDebutColumn , heureFinColumn, nomPatientColumn, prenomPatientColumn , agePatientColumn, typePatientColumn, faireConsultationColumn , supprimerButtonColumn);

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


        TableColumn<SeanceSuivi, String> faireSuiviButtonColumn = new TableColumn<>("");
        faireSuiviButtonColumn.setCellFactory(new Callback<TableColumn<SeanceSuivi, String>, TableCell<SeanceSuivi, String>>() {
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
                            Button button = new Button("Faire Suivi");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                showFaireSeanceSuiviDialog(e);


                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });


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



        seanceSuiviTable.getColumns().addAll(dateColumn, heureDebutColumn , heureFinColumn, numDossierPatientColumn, deroulementColumn, faireSuiviButtonColumn, supprimerButtonColumn);
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
        switch (choix) {
            case "Seance Suivi" -> {
                generateSeancesSuivisTable();
                consulationsTable.setVisible(false);
                atelierTable.setVisible(false);
                seanceSuiviTable.setVisible(true);
                searchField.setPromptText("Search seance suivi by name or prenom");
                ajouterRendezVousButton.setText("Ajouter Seance Suivi");
            }
            case "Consultation" -> {
                generateConsultationsTable();
                //generateTableController.generateConsultationsTable();
                seanceSuiviTable.setVisible(false);
                atelierTable.setVisible(false);
                consulationsTable.setVisible(true);
                searchField.setPromptText("Search consultation by name or prenom");
                ajouterRendezVousButton.setText("Ajouter Consultation");
            }
            case "Atelier" -> {
                generateAteliersTable();
                seanceSuiviTable.setVisible(false);
                consulationsTable.setVisible(false);
                atelierTable.setVisible(true);
                searchField.setPromptText("Search atelier by name or prenom");
                ajouterRendezVousButton.setText("Ajouter atelier");
            }
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
            dialog.getDialogPane().setContent(dialogController.createseanceSuiviContent( dateConsultationPicker,  heureDebutHourPicker,  heureDebutMinutePicker,  durationField ,  deroulement,  numdossierfield ,  this));
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
                    //seancesSuivis.add((SeanceSuivi) addedRendezVous);
                   // seanceSuiviTable.getItems().add((SeanceSuivi) addedRendezVous);
                    addRendezVous(addedRendezVous);
                    //seanceSuiviTable.getItems().add((SeanceSuivi) addedRendezVous);
                }


            }
        } else if (choixRendezVous.getValue().equals("Consultation")) {
            dialog.setHeaderText("Ajouter consultation ");
            dialog.setResizable(true);
            dialog.getDialogPane().setPrefSize(480, 320);
            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            dialog.getDialogPane().setContent(dialogController.createconsultationContent(dateConsultationPicker, heureDebutHourPicker,  heureDebutMinutePicker,  durationField,  nomField,  prenomField, typePatient,  agefield ,  this));
            Optional result = dialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (patientExiste(nomField.getText(), prenomField.getText())){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur de recherche");
                    alert.setHeaderText("Patient existe deja");
                    alert.setContentText("Patient existe deja");
                    alert.showAndWait();
                } else {

                if (typePatient.getValue().equals("Enfant")) {
                    addedRendezVous = new Consultation(TypePatient.ENFANT, dateConsultationPicker.getValue(), heuredebut, new Enfant(nomField.getText(), prenomField.getText(), Integer.valueOf(agefield.getText())));

                } else if (typePatient.getValue().equals("Adulte")) {

                    addedRendezVous = new Consultation(TypePatient.ADULTE, dateConsultationPicker.getValue(), heuredebut, new Adulte(nomField.getText(), prenomField.getText(),  Integer.valueOf(agefield.getText())));}
               // consulationsTable.getItems().add((Consultation) addedRendezVous);
                addRendezVous(addedRendezVous);
                }
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
    public void showFaireConsultationDialog(ActionEvent event) {
        Dialog dialog = new Dialog();
        dialog.setTitle("Faire consultation");
        dialog.setHeaderText("Faire consultation");
        dialog.setResizable(true);
        dialog.getDialogPane().setPrefSize(800 , 600);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        ScrollPane scrollPane = new ScrollPane(dialogController.createFaireConsultationContent(consulationsTable,nomField, prenomField, agefield, lieuNaissanceField, adresseField, professionField, diplomeField, numeroTelField, classEtudesField, numeroMereField, numeroPereField));
        scrollPane.setFitToWidth(true);
        dialog.getDialogPane().setContent(scrollPane);
        Optional result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Call method to add consultation
            //addConsultation(addedRendezVous);
        }
    }
    public void showFaireSeanceSuiviDialog(ActionEvent event) {
        Dialog dialog = new Dialog();
        dialog.setTitle("Faire Seance suivi");
        dialog.setHeaderText("Faire Seance suivi");
        dialog.setResizable(true);
        dialog.getDialogPane().setPrefSize(800 , 600);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        ScrollPane scrollPane = new ScrollPane(dialogController.createFaireSeanceSuiviContent( seanceSuiviTable,nomField, prenomField, agefield, lieuNaissanceField, adresseField, professionField, diplomeField, numeroTelField, classEtudesField, numeroMereField, numeroPereField));
        scrollPane.setFitToWidth(true);
        dialog.getDialogPane().setContent(scrollPane);
        Optional result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Call method to add consultation
            //addConsultation(addedRendezVous);
        }
    }
    public boolean patientExiste(String nom , String prenom){
        for (DossierPatient dossierPatient : dossierPatients) {
            if (dossierPatient.getPatient().getNom().equals(nom) && dossierPatient.getPatient().getPrenom().equals(prenom) ) {
                return true;
            }
        }
        return false;
    }
    public DossierPatient getDossierPatientByNumero(int numeroDossier){
        for (DossierPatient dossierPatient : dossierPatients) {
            if (dossierPatient.getNumeroDossier() == numeroDossier) {
                return dossierPatient;
            }
        }
        return null;

    }
    private Node createAtelierContent(){
        return null;
    }
    public void addRendezVous(RendezVous rendezVous) {
        LocalTime endTime = rendezVous.getHeureDebut().plus(rendezVous.getDuree());

        for (RendezVous rv : rendezVousList) {
            if (rv.getDate().equals(rendezVous.getDate()) && timesOverlap(rv.getHeureDebut(), rv.getHeureFin(), rendezVous.getHeureDebut(), endTime)) {
                System.out.println("Conflict detected: There is already a RendezVous at this time.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de conflit");
                alert.setHeaderText("Conflit de rendez-vous");
                alert.setContentText("Il y a déjà un rendez-vous à cette heure");
                alert.showAndWait();
                return;
            }
        }

        if (rendezVous instanceof Consultation) {
            Consultation newConsultation = (Consultation) rendezVous;
            consultations.add(newConsultation);
            consulationsTable.getItems().add((Consultation) rendezVous);
        } else if (rendezVous instanceof SeanceSuivi) {
            SeanceSuivi newSeanceSuivi = (SeanceSuivi) rendezVous;
            seancesSuivis.add(newSeanceSuivi);
            seanceSuiviTable.getItems().add((SeanceSuivi) rendezVous);
        } else if (rendezVous instanceof Atelier) {
            Atelier newAtelier = (Atelier) rendezVous;
            //ateliers.add(newAtelier);
        }

       // RendezVous newRendezVous = new RendezVous(date, startTime, duration);
        rendezVousList.add(rendezVous);
        System.out.println("RendezVous added successfully.");
    }
    private boolean timesOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
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

    public void setHeureDebut(LocalTime heuredebut) { // to set the value of heuredebut in dialog controller (createConsultationContent and createSeanceSuiviContent methods    )
        this.heuredebut = heuredebut;
    }
}

