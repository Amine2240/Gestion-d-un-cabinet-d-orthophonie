

package com.example.tp_poo;

import com.example.tp_poo.models.*;
import impl.com.calendarfx.view.NumericTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
        import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

 public class GenerateTabeController {
     private TableView<Consultation> consulationsTable ;
     private DatePicker dateConsultationPicker;
     private ComboBox<Integer> heureDebutHourPicker;
     private ComboBox<Integer> heureDebutMinutePicker;
     private TextField durationField;
     private TextField nomField =  new TextField();;
     private TextField prenomField = new TextField();;
     private ChoiceBox<String> typePatient;
     private NumericTextField agefield= new NumericTextField();;
     private TextField lieuNaissanceField;
     private TextField adresseField;
     private TextField diplomeField;
     private TextField professionField;
     private NumericTextField numeroTelField;
     private TextField classEtudesField;
     private NumericTextField numeroMereField;
     private NumericTextField numeroPereField;
     private LocalTime heuredebut;
     TableView seanceSuiviTable ;
     TableView atelierTable ;
     List consultations ;
     AnamneseEnfant testAnamnese1 ;
        TestQcm testqcm1 ;
        TestQcu testqcu1 ;
        TestRpsLibres testRpsLibres1 ;
        TestExerices testExerices1 ;
     public TestsEtAnamnesesController testsEtAnamnesesController;


     public GenerateTabeController(TableView<Consultation> consulationsTable, DatePicker dateConsultationPicker, ComboBox<Integer> heureDebutHourPicker, ComboBox<Integer> heureDebutMinutePicker, TextField durationField, TableView seanceSuiviTable, TableView atelierTable, List consultations, AnamneseEnfant testAnamnese1, TestQcm testqcm1, TestQcu testqcu1, TestRpsLibres testRpsLibres1, TestExerices testExerices1, TestsEtAnamnesesController testsEtAnamnesesController) {
         this.consulationsTable = consulationsTable;
         this.dateConsultationPicker = dateConsultationPicker;
         this.heureDebutHourPicker = heureDebutHourPicker;
         this.heureDebutMinutePicker = heureDebutMinutePicker;
         this.durationField = durationField;
         this.seanceSuiviTable = seanceSuiviTable;
         this.atelierTable = atelierTable;
         this.consultations = consultations;
         this.testAnamnese1 = testAnamnese1;
         this.testqcm1 = testqcm1;
         this.testqcu1 = testqcu1;
         this.testRpsLibres1 = testRpsLibres1;
         this.testExerices1 = testExerices1;
         this.testsEtAnamnesesController = testsEtAnamnesesController;
     }
    public void generateConsultationsTable( ){
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
    //    public void generateSeancesSuivisTable(){
//        if (!consulationsTable.getItems().isEmpty()) {
//            consulationsTable.getItems().clear();
//            consulationsTable.getColumns().clear();
//
//        }
//        if (!atelierTable.getItems().isEmpty()) {
//            atelierTable.getItems().clear();
//            atelierTable.getColumns().clear();
//        }
//        seanceSuiviTable.getItems().addAll(seancesSuivis);
//
//        seanceSuiviTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//
//        Callback<TableColumn<SeanceSuivi, String>, TableCell<SeanceSuivi, String>> cellFactory =
//                new Callback<>() {
//                    @Override
//                    public TableCell<SeanceSuivi, String> call(TableColumn<SeanceSuivi, String> column) {
//                        return new TableCell<>() {
//                            @Override
//                            protected void updateItem(String item, boolean empty) {
//                                super.updateItem(item, empty);
//                                if (item == null || empty) {
//                                    setText(null);
//                                } else {
//                                    setText(item);
//                                }
//                            }
//                        };
//                    }
//                };
//
//        TableColumn<SeanceSuivi, String> dateColumn = new TableColumn<>("Date");
//        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate().toString()));
//        dateColumn.setCellFactory(cellFactory);
//
//        TableColumn<SeanceSuivi, String> heureDebutColumn = new TableColumn<>("Heure Debut");
//        heureDebutColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHeureDebut().toString()));
//        heureDebutColumn.setCellFactory(cellFactory);
//
//        TableColumn<SeanceSuivi, String> heureFinColumn = new TableColumn<>("heure Fin");
//        heureFinColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getHeureDebut().plus(data.getValue().getDuree()))));
//        heureFinColumn.setCellFactory(cellFactory);
//
//        TableColumn<SeanceSuivi, String> numDossierPatientColumn = new TableColumn<>("num Dossier Patient");
//        numDossierPatientColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getPatient().getDossierPatient().getNumeroDossier())));
//
//        numDossierPatientColumn.setCellFactory(cellFactory);
//
//        TableColumn<SeanceSuivi, String> deroulementColumn = new TableColumn<>("deroulement");
//        deroulementColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTypeSeance().toString()));
//        deroulementColumn.setCellFactory(cellFactory);
//
//
//        TableColumn<SeanceSuivi, String> faireSuiviButtonColumn = new TableColumn<>("");
//        faireSuiviButtonColumn.setCellFactory(new Callback<TableColumn<SeanceSuivi, String>, TableCell<SeanceSuivi, String>>() {
//            @Override
//            public TableCell<SeanceSuivi, String> call(TableColumn<SeanceSuivi, String> param) {
//                return new TableCell<>() {
//                    @Override
//                    protected void updateItem(String item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            HBox hbox = new HBox();
//                            Button button = new Button("Faire Suivi");
//                            button.setCursor(javafx.scene.Cursor.HAND);
//                            button.setOnAction(e -> {
//
//
//                            });
//                            hbox.getChildren().add(button);
//                            setGraphic(hbox);
//                        }
//                    }
//                };
//            }
//        });
//
//
//        TableColumn<SeanceSuivi, String> supprimerButtonColumn = new TableColumn<>("");
//        // supprimerButtonColumn.setCellValueFactory(data -> supprimerButton);
//        supprimerButtonColumn.setCellFactory(new Callback<TableColumn<SeanceSuivi, String>, TableCell<SeanceSuivi, String>>() {
//            @Override
//            public TableCell<SeanceSuivi, String> call(TableColumn<SeanceSuivi, String> param) {
//                return new TableCell<>() {
//                    @Override
//                    protected void updateItem(String item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            HBox hbox = new HBox();
//                            Button button = new Button("Supprimer");
//                            button.setCursor(javafx.scene.Cursor.HAND);
//                            button.setOnAction(e -> {
//                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                                alert.setTitle("Confirmation de suppression");
//                                alert.setHeaderText("Confirmer la suppression");
//                                alert.setContentText("Voulez-vous vraiment supprimer ce patient?");
//                                Optional<ButtonType> result = alert.showAndWait();
//                                if (result.isPresent() && result.get() == ButtonType.OK) {
//                                    SeanceSuivi seanceSuivi = getTableView().getItems().get(getIndex());
//                                    getTableView().getItems().remove(seanceSuivi);
//                                    // Optionally, add code to remove patient from the database or other data structures
//                                }
//
//
//                            });
//                            hbox.getChildren().add(button);
//                            setGraphic(hbox);
//                        }
//                    }
//                };
//            }
//        });
//
//
//
//        seanceSuiviTable.getColumns().addAll(dateColumn, heureDebutColumn , heureFinColumn, numDossierPatientColumn, deroulementColumn, faireSuiviButtonColumn, supprimerButtonColumn);
//    }
//    public void generateAteliersTable(){
//        if (!consulationsTable.getItems().isEmpty()) {
//            consulationsTable.getItems().clear();
//            consulationsTable.getColumns().clear();
//
//        }
//        if (!seanceSuiviTable.getItems().isEmpty()) {
//            seanceSuiviTable.getItems().clear();
//            seanceSuiviTable.getColumns().clear();
//        }
//    }
    @FunctionalInterface
    public interface ContentCreator {
        Node createContent();
    }



    public void showFaireConsultationDialog(ActionEvent event  ) {
        Dialog dialog = new Dialog();
        dialog.setTitle("Faire consultation");
        dialog.setHeaderText("Faire consultation");
        dialog.setResizable(true);
        dialog.getDialogPane().setPrefSize(800 , 600);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        ScrollPane scrollPane = new ScrollPane(createFaireConsultationContent());
        scrollPane.setFitToWidth(true);
        dialog.getDialogPane().setContent(scrollPane);
        Optional result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Call method to add consultation
            //addConsultation(addedRendezVous);
        }
    }

     public Node createFaireConsultationContent(){
         VBox vbox = new VBox();
         vbox.setSpacing(10);
         vbox.setPadding(new Insets(10, 10, 10, 10));



         nomField.setText(consulationsTable.getSelectionModel().getSelectedItem().getPatient().getNom());
         prenomField.setText(consulationsTable.getSelectionModel().getSelectedItem().getPatient().getPrenom());
         agefield.setText(String.valueOf(consulationsTable.getSelectionModel().getSelectedItem().getPatient().getAge()));
         lieuNaissanceField = new TextField();
         lieuNaissanceField.setPromptText("Lieu Naissance");
         adresseField = new TextField();
         adresseField.setPromptText("Adresse");
         vbox.getChildren().addAll( nomField, prenomField, agefield, lieuNaissanceField, adresseField);
         VBox vboxadulte = new VBox();
         VBox vboxenfant = new VBox();

         vbox.getChildren().removeAll(vboxadulte, vboxenfant);
         if (consulationsTable.getSelectionModel().getSelectedItem().getPatient() instanceof Adulte) {
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

         } else if (consulationsTable.getSelectionModel().getSelectedItem().getPatient() instanceof Enfant) {
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

         }
         Label label1 = new Label("Premier Bilan orthophonique : ");
         // les tests seront effectues predefinitevenemt (peut plus tard implementer la fonctionnalite de choisir les tests a effectuer)
         Label label2 =  new Label("etape 1 : test anamnese ");
         Node testAnamneseNode = new VBox(  testsEtAnamnesesController.renderTestAnamnese(testAnamnese1));
         Label label3 =  new Label("etape 2 : epreuves cliniques ");
         Label label4 =  new Label("test qcu :  ");
         Node testqcuNode = new VBox(testsEtAnamnesesController.renderTestQCU( testqcu1)) ;
         Label label5 =  new Label("test qcm :  ");
         Node testqcmNode = new VBox(testsEtAnamnesesController.renderTestQCM( testqcm1)) ;
         Label label6 =  new Label("test reponses libres :  ");
         Node testRpsLibresNode = new VBox(testsEtAnamnesesController.renderTestRpsLibres( testRpsLibres1));
         Label label7 =  new Label("test exercices :  ");
         Node testExercicesNode = new VBox(testsEtAnamnesesController.renderTestExercices(testExerices1));
         Label label8 =  new Label("etape 3 : Diagnostic :  ");
         ChoiceBox<TroubleCategries> diagnostic = new ChoiceBox<>();
         diagnostic.getItems().addAll(TroubleCategries.values());
         Label label9 =  new Label(" etape 4 : projet thérapeutique :  ");
         TextArea projetTherapeutique = new TextArea();
         Button validerButton = new Button("creer Dossier patient");

         vbox.getChildren().addAll(label1, label2, testAnamneseNode, label3, label4, testqcuNode, label5, testqcmNode, label6, testRpsLibresNode, label7, testExercicesNode, label8, diagnostic, label9, projetTherapeutique, validerButton);
         return vbox;
     }

}

