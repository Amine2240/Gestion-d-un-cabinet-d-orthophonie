package com.example.tp_poo;

import com.example.tp_poo.models.*;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
        System.out.println("Dossier Patient list des rendez vous: " );
        for (int i = 0; i < dossierPatient.getListRdvous().size(); i++) {
            System.out.println(dossierPatient.getListRdvous().get(i).getDate());
            System.out.println(dossierPatient.getListRdvous().get(i).getHeureDebut());
            System.out.println(dossierPatient.getListRdvous().get(i).getPatient().getNom());
            System.out.println(dossierPatient.getListRdvous().get(i).getObservation());
        }
        listRendezVous = dossierPatient.getListRdvous();
        generateRendezVousTable();
        listBos = dossierPatient.getListBos();
        generateBosTable();
    }


    List<RendezVous> listRendezVous  ;
    @FXML
    private TableView<RendezVous> rendezVousTable = new TableView<>();

    List<Bo> listBos  ;
    @FXML
    private TableView<Bo> BosTable = new TableView<>();

    public void generateRendezVousTable(){

        //addRendezVouss(listRendezVous);
        rendezVousTable.getItems().addAll(listRendezVous);

        rendezVousTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Callback<TableColumn<RendezVous, String>, TableCell<RendezVous, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<RendezVous, String> call(TableColumn<RendezVous, String> column) {
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

        TableColumn<RendezVous, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty( data != null ? data.getValue().getDate().toString() : "N/A"));
        dateColumn.setCellFactory(cellFactory);

        TableColumn<RendezVous, String> heureDebutColumn = new TableColumn<>("Heure Debut");
        heureDebutColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHeureDebut().toString()));
        heureDebutColumn.setCellFactory(cellFactory);

        TableColumn<RendezVous, String> heureFinColumn = new TableColumn<>("heure Fin");
        heureFinColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getHeureDebut().plus(data.getValue().getDuree())) ));
        heureFinColumn.setCellFactory(cellFactory);

        TableColumn<RendezVous, String> typeRendezVousColumn = new TableColumn<>("Type RendezVous");
        typeRendezVousColumn.setCellValueFactory(data -> {
            RendezVous rendezVous = data.getValue();
            if (rendezVous instanceof SeanceSuivi) {
                return new SimpleStringProperty("Seance Suivi");
            } else if (rendezVous instanceof Consultation) {
                return new SimpleStringProperty("Consultation");
            } else {
                return new SimpleStringProperty("Unknown Type");
            }
        });
        typeRendezVousColumn.setCellFactory(cellFactory);

        TableColumn<RendezVous, String> voirObservationButtonColumn = new TableColumn<>("");
        // supprimerButtonColumn.setCellValueFactory(data -> supprimerButton);
        voirObservationButtonColumn.setCellFactory(new Callback<TableColumn<RendezVous, String>, TableCell<RendezVous, String>>() {
            @Override
            public TableCell<RendezVous, String> call(TableColumn<RendezVous, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("voir Observation");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                RendezVous rendezVous = getTableView().getItems().get(getIndex());
                                TextInputDialog dialog = new TextInputDialog(rendezVous.getObservation());
                                dialog.setTitle("Observation");
                                dialog.setHeaderText("Observation");
                                dialog.setContentText("Observation:");
                                Optional<String> result = dialog.showAndWait();
                                result.ifPresent(rendezVous::setObservation);

                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });



        rendezVousTable.getColumns().addAll(dateColumn, heureDebutColumn , heureFinColumn ,typeRendezVousColumn ,  voirObservationButtonColumn);

    }

    public void generateBosTable(){

        //addRendezVouss(listRendezVous);
        BosTable.getItems().addAll(listBos);

        BosTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Callback<TableColumn<Bo, String>, TableCell<Bo, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<Bo, String> call(TableColumn<Bo, String> column) {
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

        TableColumn<Bo, String> anamneseButtonColumn = new TableColumn<>("Anamnese");
        anamneseButtonColumn.setCellFactory(new Callback<TableColumn<Bo, String>, TableCell<Bo, String>>() {
            @Override
            public TableCell<Bo, String> call(TableColumn<Bo, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("voir anamnese");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                Bo bo = getTableView().getItems().get(getIndex());
                                Dialog dialog = new Dialog();
                                dialog.setTitle("Anamnese");
                                dialog.setHeaderText(bo.getAnamnese().getNom());
                                dialog.setContentText(bo.getAnamnese().toString());
                                dialog.showAndWait();
                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });


        TableColumn<Bo, String> EpreuvesCliniquesButtonColumn = new TableColumn<>("Epreuves Cliniques");
        EpreuvesCliniquesButtonColumn.setCellFactory(new Callback<TableColumn<Bo, String>, TableCell<Bo, String>>() {
            @Override
            public TableCell<Bo, String> call(TableColumn<Bo, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("voir epreuves cliniques");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                Bo bo = getTableView().getItems().get(getIndex());
                                Dialog dialog = new Dialog();
                                dialog.setTitle("Epreuves cliniques");
                                dialog.setHeaderText("Epreuves cliniques");
                                for (EpreuveClinique epreuveClinique : bo.getListEpreuvesCliniques()) {
                                    dialog.setContentText(" observation clinique : "+ epreuveClinique.getObservationClinique());
                                    for (Test test : epreuveClinique.getListTests()) {
                                        dialog.setContentText(test.getNom());
                                        dialog.setContentText("score total : " + test.calculerScoreTotal());


                                    }
                                }
                                dialog.showAndWait();
                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });


        TableColumn<Bo, String> diagnosticButtonColumn = new TableColumn<>("Diagnostic");
        diagnosticButtonColumn.setCellFactory(new Callback<TableColumn<Bo, String>, TableCell<Bo, String>>() {
            @Override
            public TableCell<Bo, String> call(TableColumn<Bo, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("voir Diagnostic");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                Bo bo = getTableView().getItems().get(getIndex());
                                Dialog dialog = new Dialog();
                                dialog.setTitle("Diagnostic");
                                dialog.setHeaderText("Diagnostic");
                                dialog.setContentText(bo.getDiagnostic().getTroublesPatient().toString());
                                dialog.showAndWait();
                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });


        TableColumn<Bo, String> projetTherapeutiqueButtonColumn = new TableColumn<>("Projet Therapeutique");
        projetTherapeutiqueButtonColumn.setCellFactory(new Callback<TableColumn<Bo, String>, TableCell<Bo, String>>() {
            @Override
            public TableCell<Bo, String> call(TableColumn<Bo, String> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox hbox = new HBox();
                            Button button = new Button("voir projet therapeutique");
                            button.setCursor(javafx.scene.Cursor.HAND);
                            button.setOnAction(e -> {
                                Bo bo = getTableView().getItems().get(getIndex());
                                Dialog dialog = new Dialog();
                                dialog.setTitle("Projet Therapeutique");
                                dialog.setHeaderText(bo.getProjetTherapeutique().getTextDemarcheTherapeutique());
                                dialog.showAndWait();
                            });
                            hbox.getChildren().add(button);
                            setGraphic(hbox);
                        }
                    }
                };
            }
        });


        BosTable.getColumns().addAll(anamneseButtonColumn, EpreuvesCliniquesButtonColumn , diagnosticButtonColumn ,projetTherapeutiqueButtonColumn);

    }
}
