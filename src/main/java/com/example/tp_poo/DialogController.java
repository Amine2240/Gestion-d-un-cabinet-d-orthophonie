package com.example.tp_poo;

import com.example.tp_poo.models.*;
import impl.com.calendarfx.view.NumericTextField;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalTime;
import java.util.*;

public class DialogController {

    // Assume these are passed or initialized appropriately
    private TableView<SeanceSuivi> seanceSuiviTable;
    private TestsEtAnamnesesController testsEtAnamnesesController;
    private AnamneseEnfant testAnamnese1;
    private TestQcu testqcu1;
    private TestQcm testqcm1;
    private TestRpsLibres testRpsLibres1;
    private TestExerices testExerices1;


    public DialogController( TestsEtAnamnesesController testsEtAnamnesesController, AnamneseEnfant testAnamnese1, TestQcu testqcu1, TestQcm testqcm1, TestRpsLibres testRpsLibres1, TestExerices testExerices1 ) {
        //this.seanceSuiviTable = seanceSuiviTable;
        this.testsEtAnamnesesController = testsEtAnamnesesController;
        this.testAnamnese1 = testAnamnese1;
        this.testqcu1 = testqcu1;
        this.testqcm1 = testqcm1;
        this.testRpsLibres1 = testRpsLibres1;
        this.testExerices1 = testExerices1;


    }

    public Node createFaireSeanceSuiviContent(TableView<SeanceSuivi> seanceSuiviTable,TextField nomField, TextField prenomField, NumericTextField agefield, TextField lieuNaissanceField, TextField adresseField, TextField professionField, TextField diplomeField, NumericTextField numeroTelField, TextField classEtudesField, NumericTextField numeroMereField, NumericTextField numeroPereField , FicheSuivi ancienneficheSuivi) {
        System.out.println("createFaireSeanceSuiviContent");
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        SeanceSuivi selectedSeanceSuivi = seanceSuiviTable.getSelectionModel().getSelectedItem();
        if (selectedSeanceSuivi == null) {
            System.out.println("selected seance suivi is null");
            return vbox; // or handle the null case appropriately


        }

        Patient selectedPatient = selectedSeanceSuivi.getPatient();

        nomField.setText(selectedPatient.getNom());
        nomField.setEditable(false);
        prenomField.setText(selectedPatient.getPrenom());
        prenomField.setEditable(false);
        agefield.setText(String.valueOf(selectedPatient.getAge()));
        agefield.setEditable(false);
        lieuNaissanceField.setText(selectedPatient.getLieuNaissance());
        lieuNaissanceField.setEditable(false);
        adresseField.setText(selectedPatient.getAdresse());
        adresseField.setEditable(false);
        vbox.getChildren().addAll(nomField, prenomField, agefield, lieuNaissanceField, adresseField);

        VBox vboxadulte = new VBox();
        VBox vboxenfant = new VBox();
        vbox.getChildren().removeAll(vboxadulte, vboxenfant);

        if (selectedPatient instanceof Adulte) {
            vboxenfant.getChildren().clear();
            vboxadulte.setSpacing(10);
            vboxadulte.setPadding(new Insets(0, 0, 10, 0));
            professionField.setText(((Adulte) selectedPatient).getProfession());
            professionField.setEditable(false);
            diplomeField.setText(((Adulte) selectedPatient).getDiplome());
            diplomeField.setEditable(false);
            numeroTelField.setText(((Adulte) selectedPatient).getNumeroTel());
            numeroTelField.setEditable(false);
            vboxadulte.getChildren().addAll(professionField, diplomeField, numeroTelField);
            vbox.getChildren().addAll(vboxadulte);
        } else if (selectedPatient instanceof Enfant) {
            vboxadulte.getChildren().clear();
            vboxenfant.setSpacing(10);
            vboxenfant.setPadding(new Insets(0, 0, 10, 0));
            classEtudesField.setText(((Enfant)selectedPatient).getClassEtudes());
            classEtudesField.setEditable(false);
            numeroMereField.setText(((Enfant)selectedPatient).getNumeroMere());
            numeroMereField.setEditable(false);
            numeroPereField.setText(((Enfant)selectedPatient).getNumeroPere());
            numeroPereField.setEditable(false);
            vboxenfant.getChildren().addAll(classEtudesField, numeroMereField, numeroPereField);
            vbox.getChildren().addAll(vboxenfant);
        }

        Label label1 = new Label("Bilan orthophonique : ");

        Label label3 = new Label("etape 2 : epreuves cliniques ");
        Label label4 = new Label("test qcu :  ");
        VBox testqcuNode = createTestQcuNode();

        Label label5 = new Label("test qcm :  ");
        VBox testqcmNode = createTestQcmNode();

        Label label6 = new Label("test reponses libres :  ");
        VBox testRpsLibresNode = createTestRpsLibresNode();

        Label label7 = new Label("test exercices :  ");
        Node testExercicesNode = testsEtAnamnesesController.renderTestExercices(testExerices1);

        Label label8 = new Label("etape 3 : Diagnostic :  ");
        ChoiceBox<TroubleCategries> diagnostic = new ChoiceBox<>();
        diagnostic.getItems().addAll(TroubleCategries.values());

        Label label9 = new Label(" etape 4 : projet thérapeutique :  ");
        TextArea projetTherapeutique = new TextArea();

        Label label10= new Label(" Fiche de suivi  : ");
        VBox vboxFicheSuivi = new VBox();
        Label label11 = new Label("Objectifs : ");
        VBox vboxObjectifs = new VBox();
        for (Objectif objectif : ancienneficheSuivi.getListObjectifs()) {
            Label objectifLabel = new Label(objectif.getNomObjectif() + " _______________ " + objectif.getCategorieObjectif().toString());
            vboxObjectifs.getChildren().add(objectifLabel);
        }
        Label label12 = new Label("Note Objectifs : ");
        TextField noteObjectifsField = new TextField();
        noteObjectifsField.setPromptText("Note Objectifs");
        Label label14 = new Label("orthophoniste observation");
        TextArea orthophonisteObservation = new TextArea();
        Label label13 = new Label("Objectifs Atteints : ");
        HBox hbox = new HBox();
        RadioButton optionoui = new RadioButton("Oui");
        RadioButton optionnon = new RadioButton("Non");
        hbox.getChildren().addAll(optionoui, optionnon);
        ToggleGroup group = new ToggleGroup();
        optionoui.setToggleGroup(group);
        optionnon.setToggleGroup(group);
        vboxFicheSuivi.getChildren().addAll(label11, vboxObjectifs, label12, noteObjectifsField, label13, hbox);
        Button validerButton = new Button("sauvergarder fiche de suivi");
        validerButton.setDisable(true);
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (optionoui.isSelected()) {
                validerButton.setDisable(false);
                validerButton.setOnAction(e -> {
//
                    System.out.println("information patient enregistrées");

                    //patientDataManager.addPatient(selectedSeanceSuivi.getPatient()); // add it to patient
                    ArrayList<Test> listTests = new ArrayList<>(List.of(testqcu1, testqcm1, testRpsLibres1, testExerices1));
                    EpreuveClinique epreuveClinique = new EpreuveClinique("epreuve clinique observation 1 "  ,listTests);
                    ArrayList<EpreuveClinique> listEpreuvesCliniques = new ArrayList<>(List.of(epreuveClinique));
                    Trouble trouble1 = new Trouble("nom trouble", diagnostic.getValue());
                    ArrayList<Trouble> troubles = new ArrayList<>(List.of(trouble1));
                    Diagnostic diagnostic1 = new Diagnostic(troubles);
                    ProjetTherapeutique projetTherapeutique1 = new ProjetTherapeutique(projetTherapeutique.getText());
                    Bo bo1 = new Bo( selectedSeanceSuivi.getPatient(), listEpreuvesCliniques, diagnostic1, projetTherapeutique1);
                    ArrayList<Bo> listBos = new ArrayList<>(List.of(bo1));
                    AgendaManager agendaManager = AgendaManager.getInstance();
//                    agendaManager.setPatientDataManager(patientDataManager);
                    ArrayList<RendezVous> listRendezVous = new ArrayList<>();
                    for (RendezVous rdv : agendaManager.agenda.getListRendezVous()) {
                        if (rdv.getPatient().getNom().equals(selectedSeanceSuivi.getPatient().getNom()) && rdv.getPatient().getPrenom().equals(selectedSeanceSuivi.getPatient().getPrenom())){
                            rdv.setObservation(orthophonisteObservation.getText());
                            listRendezVous.addAll(Collections.singleton(rdv));
                        }
                    }
                    ArrayList<FicheSuivi> listFicheSuivi = new ArrayList<>();
//                    patientDataManager.getPatientsComplet().add(selectedSeanceSuivi.getPatient());
//                    patientDataManager.setPatientsComplet(patientDataManager.getPatientsComplet());
                    selectedSeanceSuivi.getPatient().getDossierPatient().getListFicheSuivis().add(ancienneficheSuivi);
                    selectedSeanceSuivi.getPatient().getDossierPatient().getListBos().addAll(listBos);
                    selectedSeanceSuivi.getPatient().getDossierPatient().getListRdvous().add(selectedSeanceSuivi);

                });
            } else {
                validerButton.setDisable(true);
            }
        });

        vbox.getChildren().addAll(label1, label3, label4, testqcuNode, label5, testqcmNode, label6, testRpsLibresNode, label7, testExercicesNode, label8, diagnostic, label9, projetTherapeutique,label10,vboxFicheSuivi,label14 , orthophonisteObservation, validerButton);
        return vbox;
    }

    public Node createFaireConsultationContent(PatientDataManager patientDataManager,TableView<Consultation> consulationsTable, TextField nomField, TextField prenomField, NumericTextField agefield, TextField lieuNaissanceField, TextField adresseField, TextField professionField, TextField diplomeField, NumericTextField numeroTelField, TextField classEtudesField, NumericTextField numeroMereField, NumericTextField numeroPereField){
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
         Consultation selectedConsultation = consulationsTable.getSelectionModel().getSelectedItem();
        if (consulationsTable.getSelectionModel().getSelectedItem() == null) {
            return vbox; // or handle the null case appropriately
        }


        nomField.setText(selectedConsultation.getPatient().getNom());
        nomField.setEditable(false);
        prenomField.setText(selectedConsultation.getPatient().getPrenom());
        prenomField.setEditable(false);
        agefield.setText(String.valueOf(selectedConsultation.getPatient().getAge()));
        agefield.setEditable(false);

        lieuNaissanceField.setPromptText("Lieu Naissance");
        adresseField.setPromptText("Adresse");
        vbox.getChildren().addAll( nomField, prenomField, agefield, lieuNaissanceField, adresseField);
        VBox vboxadulte = new VBox();
        VBox vboxenfant = new VBox();

        vbox.getChildren().removeAll(vboxadulte, vboxenfant);
        if (consulationsTable.getSelectionModel().getSelectedItem().getPatient() instanceof Adulte) {
            vboxenfant.getChildren().clear();
            vboxadulte.setSpacing(10);
            vboxadulte.setPadding(new Insets(0, 0, 10, 0));

            professionField.setPromptText("Profession");

            diplomeField.setPromptText("Diplome");

            numeroTelField.setPromptText("Numero Tel");
            vboxadulte.getChildren().addAll(professionField, diplomeField, numeroTelField);
            vbox.getChildren().addAll(vboxadulte);

        } else if (consulationsTable.getSelectionModel().getSelectedItem().getPatient() instanceof Enfant) {
            vboxadulte.getChildren().clear();
            vboxenfant.setSpacing(10);
            vboxenfant.setPadding(new Insets(0, 0, 10, 0));

            classEtudesField.setPromptText("Classe Etudes");

            numeroMereField.setPromptText("Numero Mere");
            numeroPereField.setPromptText("Numero Pere");
            vboxenfant.getChildren().addAll(classEtudesField, numeroMereField, numeroPereField);
            vbox.getChildren().addAll(vboxenfant);

        }
        Label label1 = new Label("Premier Bilan orthophonique : ");
        // les tests seront effectues predefinitevenemt (peut plus tard implementer la fonctionnalite de choisir les tests a effectuer)
        Label label2 =  new Label("etape 1 : test anamnese ");
        VBox testAnamneseNode = createTestAnamneseNode();

        Label label3 =  new Label("etape 2 : epreuves cliniques ");
        Label label4 =  new Label("test qcu :  ");
        VBox testqcuNode = createTestQcuNode();
        Label label5 =  new Label("test qcm :  ");
        VBox testqcmNode = createTestQcmNode();

        Label label6 =  new Label("test reponses libres :  ");
        VBox testRpsLibresNode = createTestRpsLibresNode();

        Label label7 =  new Label("test exercices :  ");
        Node testExercicesNode = new VBox(testsEtAnamnesesController.renderTestExercices(testExerices1));
        Label label8 =  new Label("etape 3 : Diagnostic :  ");
        ChoiceBox<TroubleCategries> diagnostic = new ChoiceBox<>();
        diagnostic.getItems().addAll(TroubleCategries.values());
        Label label9 =  new Label(" etape 4 : projet thérapeutique :  ");
        TextArea projetTherapeutique = new TextArea();
        Label label11 = new Label("orthophoniste observation");
        TextArea orthophonisteObservation = new TextArea();
        Label label10= new Label(" Prise en charge : ");
        HBox hbox = new HBox();
        RadioButton optionoui = new RadioButton("Oui");
        RadioButton optionnon = new RadioButton("Non");
        hbox.getChildren().addAll(optionoui, optionnon);
        ToggleGroup group = new ToggleGroup();
        optionoui.setToggleGroup(group);
        optionnon.setToggleGroup(group);

        Button validerButton = new Button("creer Bo et dossier patient");
        validerButton.setDisable(true);
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (optionoui.isSelected()) {
                validerButton.setDisable(false);
                validerButton.setOnAction(e -> {
//                    double correctCount ;
//                    for (Map.Entry<QuestionQcu, String> entry : userSelections.entrySet()) {
//                        if (entry.getKey().getReponseJuste().equals(entry.getValue())) {
//
//                            try {
//                                entry.getKey().setScoreQuestion(10);
//                            } catch (Exception1 ex) {
//                                throw new RuntimeException(ex);
//                            }
//                        }
//                    }

                    //selectedConsultation.setObservation(projetTherapeutique.getText());
                    selectedConsultation.getPatient().setAdresse(adresseField.getText());
                    selectedConsultation.getPatient().setLieuNaissance(lieuNaissanceField.getText());
                    if (selectedConsultation.getPatient() instanceof Adulte) {

                        ((Adulte) selectedConsultation.getPatient()).setProfession(professionField.getText());
                        ((Adulte) selectedConsultation.getPatient()).setDiplome(diplomeField.getText());
                        ((Adulte) selectedConsultation.getPatient()).setNumeroTel(numeroTelField.getText());

                    } else if (selectedConsultation.getPatient() instanceof Enfant) {
                        ((Enfant) selectedConsultation.getPatient()).setClassEtudes(classEtudesField.getText());
                        ((Enfant) selectedConsultation.getPatient()).setNumeroMere(numeroMereField.getText());
                        ((Enfant) selectedConsultation.getPatient()).setNumeroPere(numeroPereField.getText());

                    }
                    //Bo bo1 = new Bo(testAnamnese1, testqcu1, testqcm1, testRpsLibres1, testExerices1, diagnostic.getValue(), projetTherapeutique.getText());
                    System.out.println("information patient enregistrées");

                    patientDataManager.addPatient(selectedConsultation.getPatient());
                    ArrayList<Test> listTests = new ArrayList<>(List.of(testqcu1, testqcm1, testRpsLibres1, testExerices1));
                    EpreuveClinique epreuveClinique = new EpreuveClinique("epreuve clinique observation 1 "  ,listTests);
                    ArrayList<EpreuveClinique> listEpreuvesCliniques = new ArrayList<>(List.of(epreuveClinique));
                    Trouble trouble1 = new Trouble("nom trouble", diagnostic.getValue());
                    ArrayList<Trouble> troubles = new ArrayList<>(List.of(trouble1));
                    Diagnostic diagnostic1 = new Diagnostic(troubles);
                    ProjetTherapeutique projetTherapeutique1 = new ProjetTherapeutique(projetTherapeutique.getText());
                    Bo bo1 = new Bo( selectedConsultation.getPatient(),testAnamnese1, listEpreuvesCliniques, diagnostic1, projetTherapeutique1);
                    ArrayList<Bo> listBos = new ArrayList<>(List.of(bo1));
                    AgendaManager agendaManager = AgendaManager.getInstance();
//                    agendaManager.setPatientDataManager(patientDataManager);
                    ArrayList<RendezVous> listRendezVous = new ArrayList<>();
                    for (RendezVous rdv : agendaManager.agenda.getListRendezVous()) {
                        if (rdv.getPatient().getNom().equals(selectedConsultation.getPatient().getNom()) && rdv.getPatient().getPrenom().equals(selectedConsultation.getPatient().getPrenom())){
                            rdv.setObservation(orthophonisteObservation.getText());
                            listRendezVous.addAll(Collections.singleton(rdv));
                        }
                    }
                    ArrayList<FicheSuivi> listFicheSuivi = new ArrayList<>();
//                    patientDataManager.getPatientsComplet().add(selectedConsultation.getPatient());
//                    patientDataManager.setPatientsComplet(patientDataManager.getPatientsComplet());
                    for (Patient patient1 : patientDataManager.getPatientsComplet()) {

                        System.out.println(" patient before creation dossier : " + patient1.getNom());

                    }
                    DossierPatient dossierPatient = new DossierPatient(selectedConsultation.getPatient(), listBos, listRendezVous, listFicheSuivi);
                    patientDataManager.getDossiersPatients().add(dossierPatient);
                    patientDataManager.setDossierPatient(patientDataManager.getDossiersPatients());
                    patientDataManager.getPatientsIncomplet().remove(selectedConsultation.getPatient());
                    patientDataManager.setPatientsIncomplet(patientDataManager.getPatientsIncomplet());


                    for (DossierPatient dossier : patientDataManager.getDossiersPatients()){
                        System.out.println(" dossier patien : " + dossier.getPatient().getNom());
                    }
                    //consulationsTable.getItems().remove(selectedConsultation);

                    //ajouter au liste des dossiers
                });
            } else {
                validerButton.setDisable(true);
            }
        });

        vbox.getChildren().addAll(label1, label2, testAnamneseNode, label3, label4, testqcuNode, label5, testqcmNode, label6, testRpsLibresNode, label7, testExercicesNode, label8, diagnostic, label9, projetTherapeutique, label11, orthophonisteObservation , label10, hbox , validerButton);
        return vbox;
    }

    private VBox createTestAnamneseNode() {
        VBox testAnamneseNode = new VBox();
        Label testanamneselabel = new Label(testAnamnese1.getNom());
        testAnamneseNode.getChildren().add(testanamneselabel);
        for (QuestionAnamnese question : testAnamnese1.getListQuestions()) {
            HBox labelEtCategHBox = new HBox();
            Label label = new Label(question.getQuestionEnonce());
            Label categorieLabel = new Label(question.getQuestionCategorie().toString());
            labelEtCategHBox.getChildren().addAll(label, categorieLabel);
            labelEtCategHBox.setSpacing(50);
            TextArea textArea = new TextArea();
            VBox.setMargin(textArea, new Insets(0, 20, 10, 20));
            testAnamneseNode.getChildren().addAll(labelEtCategHBox, textArea);
        }
        return testAnamneseNode;
    }

    Map<QuestionQcu, String> userSelections;
    private VBox createTestQcuNode() {
        VBox testqcuNode = new VBox();
        Label testnomLabel = new Label(testqcu1.getNom());
        testqcuNode.getChildren().add(testnomLabel);
        // Map to store user selections
        userSelections = new HashMap<>();
        for (QuestionQcu question : testqcu1.getListQuestionsQcu()) {
            Label label = new Label(question.getQuestionEnonce());
            HBox propositionsHBox = new HBox();
            propositionsHBox.setSpacing(10);
            ToggleGroup toggleGroup = new ToggleGroup();
            for (String proposition : question.getListpropositions()) {
                RadioButton radioButton = new RadioButton(proposition);
                radioButton.setToggleGroup(toggleGroup);
                // Add listener to update the user selection map
                radioButton.setOnAction(e -> userSelections.put(question, proposition));
                propositionsHBox.getChildren().add(radioButton);
            }
            testqcuNode.getChildren().addAll(label, propositionsHBox);
        }
        return testqcuNode;
    }

    private VBox createTestQcmNode() {
        VBox testqcmNode = new VBox();
        Label testqcmlabel = new Label(testqcm1.getNom());
        testqcmNode.getChildren().add(testqcmlabel);
        for (QuestionQcm question : testqcm1.getListQuestionsQcm()) {
            Label label = new Label(question.getQuestionEnonce());
            HBox propositionsHBox = new HBox();
            propositionsHBox.setSpacing(10);
            for (String proposition : question.getListpropositions()) {
                CheckBox checkBox = new CheckBox(proposition);
                propositionsHBox.getChildren().add(checkBox);
            }
            testqcmNode.getChildren().addAll(label, propositionsHBox);
        }
        return testqcmNode;
    }

    private VBox createTestRpsLibresNode() {
        VBox testRpsLibresNode = new VBox();
        Label testRpsLibreslabel = new Label(testRpsLibres1.getNom());
        testRpsLibresNode.getChildren().add(testRpsLibreslabel);
        VBox vboxLibre = new VBox();
        for (QuestionRpsLibres question : testRpsLibres1.getListQuestionsRpsLibres()) {
            Label label = new Label(question.getQuestionEnonce());
            TextArea textArea = new TextArea();
            VBox.setMargin(textArea, new Insets(0, 20, 10, 20));
            vboxLibre.getChildren().addAll(label, textArea);
        }
        testRpsLibresNode.getChildren().addAll(vboxLibre);
        return testRpsLibresNode;
    }

    public Node createconsultationContent(DatePicker dateConsultationPicker, ComboBox<Integer> heureDebutHourPicker, ComboBox<Integer> heureDebutMinutePicker, TextField durationField, TextField nomField, TextField prenomField, ChoiceBox<String> typePatient, NumericTextField agefield , RendezVousController rdcontroller){


        // Create a VBox to hold the form elements
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        // Create the form elements

        //heureDebutHourPicker.getItems().clear();
        dateConsultationPicker.setPromptText("date consultation");
        HBox hbox = new HBox();
        Label heuredebutlabel = new Label("Heure debut : ");
        for (int i = 0; i < 24; i++) {
            heureDebutHourPicker.getItems().add(i);
        }
        heureDebutHourPicker.setValue(8);  // default value
        Label heuredebutlabel2 = new Label(" : ");
        for (int i = 0; i < 60; i += 5) {  // you can change the step as needed
            heureDebutMinutePicker.getItems().add(i);
        }
        heureDebutMinutePicker.setValue(0);
        heureDebutHourPicker.setOnAction(e -> {
          rdcontroller.setHeureDebut( LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue()));
        });
        heureDebutMinutePicker.setOnAction(e -> {
          rdcontroller.setHeureDebut( LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue()));
        });
        hbox.getChildren().addAll(heuredebutlabel, heureDebutHourPicker , heuredebutlabel2, heureDebutMinutePicker);

         nomField.clear(); // due to his previsous value
        nomField.setEditable(true);
        nomField.setPromptText("Nom patient");
        prenomField.clear();
        prenomField.setEditable(true);
        prenomField.setPromptText("Prenom patient");

        typePatient.getItems().addAll("Enfant", "Adulte");
        typePatient.setValue("Enfant");
        agefield.setPromptText("Age patient");
        vbox.getChildren().addAll(dateConsultationPicker, hbox, durationField, nomField, prenomField, typePatient, agefield);
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

                // heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
                // heurefin = heuredebut.plusMinutes(150);
                //addedRendezVous =  new Consultation(TypePatient.ENFANT, dateConsultationPicker.getValue(), heuredebut, heurefin, new Enfant(nomField.getText(), prenomField.getText(), date2, lieuNaissanceField.getText(), adresseField.getText(), classEtudesField.getText(), numeroMereField.getText(), numeroPereField.getText()));

            }

        });


        return vbox;
    }

    public Node createseanceSuiviContent(DatePicker dateConsultationPicker, ComboBox<Integer> heureDebutHourPicker, ComboBox<Integer> heureDebutMinutePicker, TextField durationField , ChoiceBox<String> deroulement, NumericTextField numdossierfield , RendezVousController rdcontroller){
        // Create a VBox to hold the form elements
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
       // heureDebutHourPicker.getItems().clear();
        // Create the form elements
        dateConsultationPicker.setPromptText("date seance suivi");
        HBox hbox = new HBox();
        Label heuredebutlabel = new Label("Heure debut : ");

        for (int i = 0; i < 24; i++) {
            heureDebutHourPicker.getItems().add(i);
        }
        heureDebutHourPicker.setValue(8);  // default value
        Label heuredebutlabel2 = new Label(" : ");

        for (int i = 0; i < 60; i += 5) {  // you can change the step as needed
            heureDebutMinutePicker.getItems().add(i);
        }
        heureDebutMinutePicker.setValue(0);
        heureDebutHourPicker.setOnAction(e -> {
          rdcontroller.setHeureDebut( LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue()));
        });
        heureDebutMinutePicker.setOnAction(e -> {
          rdcontroller.setHeureDebut( LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue()));
        });
        hbox.getChildren().addAll( heuredebutlabel, heureDebutHourPicker , heuredebutlabel2, heureDebutMinutePicker);

        durationField.setText("duree seance suivi : 1h");
        durationField.setEditable(false);

        deroulement.getItems().addAll("EN PRESENTIEL", "EN LIGNE");
        deroulement.setValue("EN PRESENTIEL");
        numdossierfield.setPromptText("Numero Dossier Patient");

        vbox.getChildren().addAll(dateConsultationPicker, hbox, durationField,  deroulement , numdossierfield);

        //heuredebut = LocalTime.of(heureDebutHourPicker.getValue(), heureDebutMinutePicker.getValue());
        return vbox;
    }
}
