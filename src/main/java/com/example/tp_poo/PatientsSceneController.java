package com.example.tp_poo;

import com.example.tp_poo.models.Adulte;
import com.example.tp_poo.models.DossierPatient;
import com.example.tp_poo.models.Enfant;
import com.example.tp_poo.models.Patient;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;


//import javax.security.auth.callback.Callback;
import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class PatientsSceneController implements Initializable {
   @FXML
    private TableView<Enfant> enfantsTable;

    @FXML
    private TableView<Adulte> adultesTable;

    @FXML
    private ChoiceBox<String> choixPatients;
    private String[] choix = {"Adulte" , "Enfant"};


@FXML
private TextField searchField;
@FXML
ImageView supprimerButtonview;
//Image image = new Image(getClass().getResourceAsStream("icons8-supprimer-30.png"));

    @FXML
    private Button ajouterPatientButton;

    Patient addedPatient = null;
    List<Enfant> enfantspatients;
    List<Adulte> adultespatients;
    AgendaManager agendaManager ;
    PatientDataManager dataManager ;


    @FXML
    private AnchorPane sideBarancherPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SideBarScene.fxml"));
        Parent sidebar = null;
        try {
            sidebar = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sideBarancherPane.getChildren().add(sidebar);
        dataManager = PatientDataManager.getInstance();
         agendaManager = AgendaManager.getInstance();

         agendaManager.setPatientDataManager(dataManager);


        choixPatients.getItems().addAll(choix);
        choixPatients.setValue("Enfant"); // initial to avoid null

        choixPatients.setOnAction(this::choixPatientsAction);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Call method to filter TableView based on search query
            filterTableView(newValue); // based on query
        });


         enfantspatients =  dataManager.getPatientsComplet().stream()
                .filter(patient -> patient instanceof Enfant)
                .map(patient -> (Enfant) patient)
                .collect(Collectors.toList());

         adultespatients = dataManager.getPatientsComplet().stream()
                .filter(patient -> patient instanceof Adulte)
                .map(patient -> (Adulte) patient)
                .collect(Collectors.toList());

        generateEnfantsTable();
        System.out.println("helllloowoowooow");
        for (Enfant enfant : enfantspatients){
            System.out.println("from list patients : "+ enfant.getNom());
        }

        dataManager.initializeData(agendaManager);

        dataManager.setDossierToPatients();

    }
    private void filterTableView(String query) {
        // Filter enfantsTable
        ObservableList<Enfant> filteredEnfants = FXCollections.observableArrayList();
        for (Enfant enfant : enfantspatients) {
            if (enfantMatchesQuery(enfant, query)) {
                filteredEnfants.add(enfant);
            }
        }
        enfantsTable.setItems(filteredEnfants);

        // Filter adultesTable
        ObservableList<Adulte> filteredAdultes = FXCollections.observableArrayList();
        for (Adulte adulte : adultespatients) {
            if (adulteMatchesQuery(adulte, query)) {
                filteredAdultes.add(adulte);
            }
        }
        adultesTable.setItems(filteredAdultes);
    }

    private boolean enfantMatchesQuery(Enfant enfant, String query) {
        // Implement logic to check if enfant matches query
        // You can search based on any fields you want, such as name, address, etc.
        return enfant.getNom().toLowerCase().contains(query.toLowerCase()) ||
                enfant.getPrenom().toLowerCase().contains(query.toLowerCase());
    }

    private boolean adulteMatchesQuery(Adulte adulte, String query) {
        // Implement logic to check if adulte matches query
        // You can search based on any fields you want, such as name, address, etc.
        return adulte.getNom().toLowerCase().contains(query.toLowerCase()) ||
                adulte.getPrenom().toLowerCase().contains(query.toLowerCase());
    }

    public void generateEnfantsTable(){
        if (!adultesTable.getItems().isEmpty()) {
            adultesTable.getItems().clear();
            adultesTable.getColumns().clear();
        }
//        if (!enfantsTable.getItems().isEmpty()) {
//            enfantsTable.getItems().clear();
//            enfantsTable.getColumns().clear();
//        }
        enfantsTable.getItems().addAll(enfantspatients);

        enfantsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Callback<TableColumn<Enfant, String>, TableCell<Enfant, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<Enfant, String> call(TableColumn<Enfant, String> column) {
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

        TableColumn<Enfant, String> nomColumn = new TableColumn<>("Nom");
        nomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        nomColumn.setCellFactory(cellFactory);

        TableColumn<Enfant, String> prenomColumn = new TableColumn<>("Prenom");
        prenomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPrenom()));
        prenomColumn.setCellFactory(cellFactory);

        TableColumn<Enfant, String> dateNaissanceColumn = new TableColumn<>("Date Naissance");
        dateNaissanceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateNaissance().toString()));
        dateNaissanceColumn.setCellFactory(cellFactory);

        TableColumn<Enfant, String> lieuNaissanceColumn = new TableColumn<>("Lieu Naissance");
        lieuNaissanceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLieuNaissance()));
        lieuNaissanceColumn.setCellFactory(cellFactory);

        TableColumn<Enfant, String> adresseColumn = new TableColumn<>("Adresse");
        adresseColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAdresse()));
        adresseColumn.setCellFactory(cellFactory);

        TableColumn<Enfant, String> classEtudesColumn = new TableColumn<>("Classe Etudes");
        classEtudesColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClassEtudes()));
        classEtudesColumn.setCellFactory(cellFactory);

        TableColumn<Enfant, String> numeroMereColumn = new TableColumn<>("Numero Mere");
        numeroMereColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumeroMere()));
        numeroMereColumn.setCellFactory(cellFactory);

        TableColumn<Enfant, String> numeroPereColumn = new TableColumn<>("Numero Pere");
        numeroPereColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumeroPere()));
        numeroPereColumn.setCellFactory(cellFactory);

        TableColumn<Enfant, String> dossierpatientButtonColumn = new TableColumn<>("");
        // supprimerButtonColumn.setCellValueFactory(data -> supprimerButton);
        dossierpatientButtonColumn.setCellFactory(new Callback<TableColumn<Enfant, String>, TableCell<Enfant, String>>() {
            @Override
            public TableCell<Enfant, String> call(TableColumn<Enfant, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("Dossier Patient");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                try {
                                    allerVersDossierPatient(enfantsTable.getSelectionModel().getSelectedItem().getDossierPatient());
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }

                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });

        TableColumn<Enfant, String> supprimerButtonColumn = new TableColumn<>("");
        // supprimerButtonColumn.setCellValueFactory(data -> supprimerButton);
        supprimerButtonColumn.setCellFactory(new Callback<TableColumn<Enfant, String>, TableCell<Enfant, String>>() {
            @Override
            public TableCell<Enfant, String> call(TableColumn<Enfant, String> param) {
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
                                    Enfant patient = getTableView().getItems().get(getIndex());
                                    getTableView().getItems().remove(patient);
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



        enfantsTable.getColumns().addAll(nomColumn, prenomColumn , dateNaissanceColumn, lieuNaissanceColumn, adresseColumn, classEtudesColumn, numeroMereColumn, numeroPereColumn , dossierpatientButtonColumn , supprimerButtonColumn);


    }
    public void generateAdultesTable(){
        if (!enfantsTable.getItems().isEmpty()) {
            enfantsTable.getItems().clear();
            enfantsTable.getColumns().clear();
        }
        adultesTable.getItems().addAll(adultespatients);

        adultesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Callback<TableColumn<Adulte, String>, TableCell<Adulte, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<Adulte, String> call(TableColumn<Adulte, String> column) {
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

        TableColumn<Adulte, String> nomColumn = new TableColumn<>("Nom");
        nomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        nomColumn.setCellFactory(cellFactory);

        TableColumn<Adulte, String> prenomColumn = new TableColumn<>("Prenom");
        prenomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPrenom()));
        prenomColumn.setCellFactory(cellFactory);

        TableColumn<Adulte, String> dateNaissanceColumn = new TableColumn<>("Date Naissance");
        dateNaissanceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateNaissance().toString()));
        dateNaissanceColumn.setCellFactory(cellFactory);

        TableColumn<Adulte, String> lieuNaissanceColumn = new TableColumn<>("Lieu Naissance");
        lieuNaissanceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLieuNaissance()));
        lieuNaissanceColumn.setCellFactory(cellFactory);

        TableColumn<Adulte, String> adresseColumn = new TableColumn<>("Adresse");
        adresseColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAdresse()));
        adresseColumn.setCellFactory(cellFactory);

        TableColumn<Adulte, String> professionColumn = new TableColumn<>("Profession");
        professionColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProfession()));
        professionColumn.setCellFactory(cellFactory);

        TableColumn<Adulte, String> diplomeColumn = new TableColumn<>("Diplome");
        diplomeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDiplome()));
        diplomeColumn.setCellFactory(cellFactory);

        TableColumn<Adulte, String> numeroTelColumn = new TableColumn<>("Numero Tel");
        numeroTelColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumeroTel()));
        numeroTelColumn.setCellFactory(cellFactory);

        TableColumn<Adulte, String> dossierpatientButtonColumn = new TableColumn<>("");
        // supprimerButtonColumn.setCellValueFactory(data -> supprimerButton);
        dossierpatientButtonColumn.setCellFactory(new Callback<TableColumn<Adulte, String>, TableCell<Adulte, String>>() {
            @Override
            public TableCell<Adulte, String> call(TableColumn<Adulte, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("Dossier Patient");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                try {

                                    allerVersDossierPatient(adultesTable.getSelectionModel().getSelectedItem().getDossierPatient());
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }

                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });

        TableColumn<Adulte, String> supprimerButtonColumn = new TableColumn<>("");
       // supprimerButtonColumn.setCellValueFactory(data -> supprimerButton);
        supprimerButtonColumn.setCellFactory(new Callback<TableColumn<Adulte, String>, TableCell<Adulte, String>>() {
            @Override
            public TableCell<Adulte, String> call(TableColumn<Adulte, String> param) {
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
                                    Adulte patient = getTableView().getItems().get(getIndex());
                                    getTableView().getItems().remove(patient);
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

        adultesTable.getColumns().addAll(nomColumn, prenomColumn , dateNaissanceColumn, lieuNaissanceColumn, adresseColumn, professionColumn , diplomeColumn, numeroTelColumn , dossierpatientButtonColumn , supprimerButtonColumn);
    }
    public void choixPatientsAction(ActionEvent event){

        String choix = choixPatients.getValue();
        if(choix.equals("Adulte")){
            generateAdultesTable();
            enfantsTable.setVisible(false);
            adultesTable.setVisible(true);
            searchField.setPromptText("Search adults by name or prenom");
        }
        else if(choix.equals("Enfant")){
            generateEnfantsTable();
            adultesTable.setVisible(false);
            enfantsTable.setVisible(true);
            searchField.setPromptText("Search enfants by name or prenom");
        }
    }
    public void switchToLoginScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScene.fxml")));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private Stage stage;
//    public void switchToCalendar(ActionEvent event) throws IOException{
//        Mycalendar calendarView = new Mycalendar();
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene calendarScene = new Scene(calendarView.getRoot(), 1300, 1000);
//
//        stage.setScene(calendarScene);
//        stage.show();
//    }
    public void allerVersDossierPatient(DossierPatient dossierPatient) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DossierPatientScene.fxml"));
        Parent root = loader.load();

        // Get the controller and set the patient details
        DossierPatientController controller = loader.getController();
        controller.setPatientDetails(dossierPatient);

        // Switch to the new scene
        if (dossierPatient.getPatient() instanceof Enfant)
             stage = (Stage) enfantsTable.getScene().getWindow();
        else if (dossierPatient.getPatient() instanceof Adulte)
             stage = (Stage) adultesTable.getScene().getWindow(); // or based on checkbox value

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showDialog(ActionEvent event){

        Dialog dialog = new Dialog();
        dialog.setTitle("Ajouter Patient");
        dialog.setHeaderText("Ajouter un nouveau patient");
        dialog.setResizable(true);
        dialog.getDialogPane().setPrefSize(480, 320);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(createContent());
        Optional result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            adultesTable.getItems().add((Adulte) addedPatient);

        }

    }
    private Node createContent() {
        // Create a VBox to hold the form elements
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        // Create the form elements
        TextField nomField = new TextField();
        nomField.setPromptText("Nom");
        TextField prenomField = new TextField();
        prenomField.setPromptText("Prenom");
        DatePicker dateNaissancePicker = new DatePicker();
        dateNaissancePicker.setPromptText("Date Naissance");
        TextField lieuNaissanceField = new TextField();
        lieuNaissanceField.setPromptText("Lieu Naissance");
        TextField adresseField = new TextField();
        adresseField.setPromptText("Adresse");
        if (choixPatients.getValue().equals("Adulte")){
TextField professionField = new TextField();
            professionField.setPromptText("Profession");
            TextField diplomeField = new TextField();
            diplomeField.setPromptText("Diplome");
            TextField numeroTelField = new TextField();
            numeroTelField.setPromptText("Numero Tel");
            vbox.getChildren().addAll(nomField, prenomField, dateNaissancePicker, lieuNaissanceField, adresseField, professionField, diplomeField, numeroTelField);
            addedPatient =  new Adulte(nomField.getText(), prenomField.getText(), dateNaissancePicker.getValue(), lieuNaissanceField.getText(), adresseField.getText(), diplomeField.getText(), professionField.getText(), numeroTelField.getText()) ;
        }
        else if (choixPatients.getValue().equals("Enfant")){
            TextField classEtudesField = new TextField();
            classEtudesField.setPromptText("Classe Etudes");
            TextField numeroMereField = new TextField();
            numeroMereField.setPromptText("Numero Mere");
            TextField numeroPereField = new TextField();
            numeroPereField.setPromptText("Numero Pere");
            vbox.getChildren().addAll(nomField, prenomField, dateNaissancePicker, lieuNaissanceField, adresseField, classEtudesField, numeroMereField, numeroPereField);
            addedPatient =  new Enfant(nomField.getText(), prenomField.getText(), dateNaissancePicker.getValue(), lieuNaissanceField.getText(), adresseField.getText(), classEtudesField.getText(), numeroMereField.getText(), numeroPereField.getText()) ;

        }

        return vbox;
    }
}
