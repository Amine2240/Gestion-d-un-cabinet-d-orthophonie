package com.example.tp_poo;

import com.example.tp_poo.models.Adulte;
import com.example.tp_poo.models.Enfant;
import com.example.tp_poo.models.Patient;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;


//import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class PatientsSceneController implements Initializable {
   @FXML
    private TableView<Enfant> enfantsTable;
    LocalDate date1 = LocalDate.of(2000, 1, 1);
    LocalDate date2 = LocalDate.of(2001, 2, 2);
    LocalDate date3 = LocalDate.of(2002, 3, 3);
    LocalDate date4 = LocalDate.of(2003, 4, 4);

    // Create Enfant objects with real data
    Enfant p1 = new Enfant("John", "Doe", date1, "Paris", "123 Main St", "Primary", "0552484650", "0541177916");
    Enfant p2 = new Enfant("Jane", "Smith", date2, "London", "456 Elm St", "Secondary", "0552484650", "0541177916");
    Enfant p3 = new Enfant("Michael", "Johnson", date3, "New York", "789 Oak St", "Primary", "0552484650", "0541177916");
    Enfant p4 = new Enfant("Emily", "Brown", date4, "Berlin", "101 Pine St", "Secondary", "0552484650", "0541177916");
    List<Enfant> enfantspatients = List.of(p1, p2, p3, p4);

    @FXML
    private TableView<Adulte> adultesTable;
//    LocalDate date1 = LocalDate.of(2000, 1, 1);
//    LocalDate date2 = LocalDate.of(2001, 2, 2);
//    LocalDate date3 = LocalDate.of(2002, 3, 3);
//    LocalDate date4 = LocalDate.of(2003, 4, 4);

    // Create adulte objects with real data
    Adulte a1 = new Adulte("John", "Doe", date1, "Paris", "123 Main St", "doctorat", "architecte", "0541177916");
    Adulte a2 = new Adulte("Jane", "Smith", date2, "London", "456 Elm St", "liscence", "medecin", "0541177916");
    Adulte a3 = new Adulte("Michael", "Johnson", date3, "New York", "789 Oak St", "bacallauriat", "ingenieur", "0541177916");
    Adulte a4 = new Adulte("Emily", "Brown", date4, "Berlin", "101 Pine St", "master", "professeur", "0541177916");
    List<Adulte> adultespatients = List.of(a1, a2, a3, a4);

    //private Patient selectedPatient;

    @FXML
    private ChoiceBox<String> choixPatients;
    private String[] choix = {"Adulte" , "Enfant"};


@FXML
private TextField searchField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choixPatients.getItems().addAll(choix);
        choixPatients.setValue("Enfant"); // initial to avoid null
        choixPatients.setOnAction(this::choixPatientsAction);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Call method to filter TableView based on search query
            filterTableView(newValue); // based on query
        });


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



        enfantsTable.getColumns().addAll(nomColumn, prenomColumn , dateNaissanceColumn, lieuNaissanceColumn, adresseColumn, classEtudesColumn, numeroMereColumn, numeroPereColumn);


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

        adultesTable.getColumns().addAll(nomColumn, prenomColumn , dateNaissanceColumn, lieuNaissanceColumn, adresseColumn, professionColumn , diplomeColumn, numeroTelColumn);
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
    public void switchToCalendar(ActionEvent event) throws IOException{
        Mycalendar calendarView = new Mycalendar();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene calendarScene = new Scene(calendarView.getRoot(), 1300, 1000);

        stage.setScene(calendarScene);
        stage.show();
    }
}
