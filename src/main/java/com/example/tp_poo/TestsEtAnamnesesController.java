package com.example.tp_poo;

import com.calendarfx.view.print.PrintView;
import com.example.tp_poo.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class TestsEtAnamnesesController implements Initializable {
    @FXML
   private ListView<String> listView;
   @FXML
   private HBox containerHbox ; // the selected test and list of title tests of each categorie
    @FXML
    private VBox selectedTestVBox;
    @FXML
    private VBox listTestsVBox;



   // private HBox propositionsHBox;
    private ObservableList<QuestionQcm> questionsQcm;
    private ObservableList<QuestionQcu> questionsQcu;
    private ObservableList<QuestionRpsLibres> questionsRpsLibres;
    private ObservableList<Exercice> exercices;
    private ObservableList<QuestionAnamnese> anamneses; // pour enfant

    private ObservableList<TestQcm> listtestsQcm;
    private ObservableList<TestQcu> listtestsQcu;
    private ObservableList<TestExerices> listtestsExercices;
    private ObservableList<TestRpsLibres> listtestsRpsLibres;
   // private ObservableList<AnamneseAdulte> listtestsAnamneseAdults;
    private ObservableList<AnamneseEnfant> listtestsAnamneseEnfant;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Tests QCU", // ou bien Tests QCU
                "Tests QCM",
                "Tests Reponse libres",
                "Tests Exercices",
                "Tests Anamnèse"

        );

        // Crée un ListView pour afficher les éléments

         listView.setItems(items);
        //listView.setStyle("-fx-background-color: transparent;");


        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null && selectedItem.equals("Tests QCU")) {
                listTestsVBox.getChildren().clear();
                renderlisttestsQCU();
            }
            if (selectedItem != null && selectedItem.equals("Tests QCM")) {
                listTestsVBox.getChildren().clear();
                renderlisttestsQCM();
            }
            if (selectedItem != null && selectedItem.equals("Tests Reponse libres")) {
                listTestsVBox.getChildren().clear();
                renderlisttestsRpsLibres();
            }
            if (selectedItem != null && selectedItem.equals("Tests Exercices")) {
                listTestsVBox.getChildren().clear();
                renderlisttestsExercices();
            }
            if (selectedItem != null && selectedItem.equals("Tests Anamnèse")) {
                listTestsVBox.getChildren().clear();
                renderlisttestsAnamnese();
            }
        });


    }

    public void renderTestQCU(TestQcu testQcu)  {

        selectedTestVBox.getChildren().clear();
        Label testnomLabel = new Label(testQcu.getNom());
        selectedTestVBox.getChildren().add(testnomLabel);
        // propositionsHBox.getChildren().clear();
        for (QuestionQcu question : testQcu.getListQuestionsQcu()) {
            Label label = new Label(question.getQuestionEnonce());
            //selectedTestVBox.getChildren().add(label);
            HBox propositionsHBox = new HBox();
            propositionsHBox.setSpacing(10);
            ToggleGroup toggleGroup = new ToggleGroup();

            for (String proposition : question.getListpropositions()) {
                RadioButton radioButton = new RadioButton(proposition);
                radioButton.setToggleGroup(toggleGroup);
                propositionsHBox.getChildren().add(radioButton);

            }
            selectedTestVBox.getChildren().addAll(label,propositionsHBox);
        }
    }
    public void renderTestQCM(TestQcm testQcm){

        selectedTestVBox.getChildren().clear();
        Label testqcmlabel = new Label(testQcm.getNom());
        selectedTestVBox.getChildren().add(testqcmlabel);
       // propositionsHBox.getChildren().clear();
        for (QuestionQcm question : testQcm.getListQuestionsQcm()) {
            Label label = new Label(question.getQuestionEnonce());
            //selectedTestVBox.getChildren().add(label);
            HBox propositionsHBox = new HBox();
            propositionsHBox.setSpacing(10);

           // System.out.println(question.getListpropositions());
            for (String proposition : question.getListpropositions()) {

                CheckBox checkBox = new CheckBox(proposition);
                propositionsHBox.getChildren().add(checkBox);

            }
            selectedTestVBox.getChildren().addAll(label,propositionsHBox);
        }
    }
    public void renderTestRpsLibres(TestRpsLibres testRpsLibres){

        selectedTestVBox.getChildren().clear();
        Label testRpsLibreslabel = new Label(testRpsLibres.getNom());
        selectedTestVBox.getChildren().add(testRpsLibreslabel);
        // propositionsHBox.getChildren().clear();
        for (QuestionRpsLibres question : testRpsLibres.getListQuestionsRpsLibres()) {
            Label label = new Label(question.getQuestionEnonce());
            //selectedTestVBox.getChildren().add(label);
            TextArea textArea = new TextArea();
            selectedTestVBox.getChildren().addAll(label,textArea);
        }
    }
    public void renderTestExercices(TestExerices testExerices){
        exercices = FXCollections.observableArrayList(
                new Exercice("Exercice 1 ", "Exercice 1 consigne", "Exercice 1 materiel"),
                new Exercice("Exercice 2 ", "Exercice 2 consigne", "Exercice 2 materiel"),
                new Exercice("Exercice 3 ", "Exercice 3 consigne", "Exercice 3 materiel")

                // Add more questions with answers as needed
        );
        selectedTestVBox.getChildren().clear();
        // propositionsHBox.getChildren().clear();
        ArrayList<Exercice> listexercices = new ArrayList<>(exercices);
        Test testexercices = new TestExerices("test exercice 1 ", "orthophonisite observation 1 ",listexercices);
        for (Exercice exercice : exercices) {
            Label label = new Label(exercice.getNomExo());
            //selectedTestVBox.getChildren().add(label);
//            HBox propositionsHBox = new HBox();
//            propositionsHBox.setSpacing(10);
//
//            // System.out.println(question.getListpropositions());
//            for (String proposition : question.getListpropositions()) {
//
//                CheckBox checkBox = new CheckBox(proposition);
//                propositionsHBox.getChildren().add(checkBox);
//
//            }
            selectedTestVBox.getChildren().addAll(label);
        }
    }
    public void renderTestAnamnese(AnamneseEnfant anamneseEnfant){
        anamneses = FXCollections.observableArrayList(
                new QuestionAnamnese("QuestionAnamnese 1 enouncé", Categories.ANTECEDENTS_FAMILIAUX),
                new QuestionAnamnese("QuestionAnamnese 2 enouncé", Categories.CARACTERE),
                new QuestionAnamnese("QuestionAnamnese 3 enouncé", Categories.CONDITIONS_NATALES)
                // Add more questions with answers as needed
        );
        selectedTestVBox.getChildren().clear();
        // propositionsHBox.getChildren().clear();
        ArrayList<QuestionAnamnese> listquestionsAnamnese = new ArrayList<>(anamneses);
        Anamnese testAnamnese = new AnamneseEnfant(listquestionsAnamnese);
        for (QuestionAnamnese question : anamneses) {
            Label label = new Label(question.getQuestionEnonce());
            //selectedTestVBox.getChildren().add(label);
//            HBox propositionsHBox = new HBox();
//            propositionsHBox.setSpacing(10);
//
//            // System.out.println(question.getListpropositions());
//            for (String proposition : question.getListpropositions()) {
//
//                CheckBox checkBox = new CheckBox(proposition);
//                propositionsHBox.getChildren().add(checkBox);
//
//            }
            selectedTestVBox.getChildren().addAll(label);
        }
    }

    public void renderlisttestsQCU(){
        // it will be a loop to display all the tests
      ObservableList<QuestionQcu>  questionsQcu1 = FXCollections.observableArrayList(
                new QuestionQcu("QuestionQcu 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 1"),
                new QuestionQcu("QuestionQcu 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 2"),
                new QuestionQcu("QuestionQcu 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 3")
                // Add more questions with answers as needed
        );
        Set<QuestionQcu> questionsQcuSet1 = new HashSet<>(questionsQcu1);
        Test testqcu1 = new TestQcu(questionsQcuSet1,"test qcu 1", " orthogonisteObservation 1 ");

        ObservableList<QuestionQcu>  questionsQcu2 = FXCollections.observableArrayList(
                new QuestionQcu("QuestionQcu 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 1"),
                new QuestionQcu("QuestionQcu 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 2"),
                new QuestionQcu("QuestionQcu 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 3")
                // Add more questions with answers as needed
        );
        Set<QuestionQcu> questionsQcuSet2 = new HashSet<>(questionsQcu2);
        Test testqcu2 = new TestQcu(questionsQcuSet2,"test qcu 2", " orthogonisteObservation 2 ");

        ObservableList<QuestionQcu>  questionsQcu3 = FXCollections.observableArrayList(
                new QuestionQcu("QuestionQcu 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 1"),
                new QuestionQcu("QuestionQcu 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 2"),
                new QuestionQcu("QuestionQcu 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 3")
                // Add more questions with answers as needed
        );
        Set<QuestionQcu> questionsQcuSet3 = new HashSet<>(questionsQcu3);
        Test testqcu3 = new TestQcu(questionsQcuSet3,"test qcu 3", " orthogonisteObservation 3 ");

        listtestsQcu = FXCollections.observableArrayList((TestQcu) testqcu1, (TestQcu) testqcu2, (TestQcu) testqcu3);


        for ( TestQcu testQcu : listtestsQcu) {
            HBox hbox = new HBox();
            Button button = new Button("voir details");
            Label label = new Label(testQcu.getNom());
            hbox.getChildren().addAll(label, button);
            listTestsVBox.getChildren().add(hbox);
            button.setOnAction(event -> {
                // display the details of the test
                renderTestQCU(testQcu);
            });
        }

    }
    public void renderlisttestsQCM(){
        ObservableList<QuestionQcm>  questionsQcm1 = FXCollections.observableArrayList(
                new QuestionQcm("QuestionQcm 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
                new QuestionQcm("QuestionQcm 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
                new QuestionQcm("QuestionQcm 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2"))
                // Add more questions with answers as needed
        );
        Set<QuestionQcm> questionsQcmSet1 = new HashSet<>(questionsQcm1);
        Test testqcm1 = new TestQcm(questionsQcmSet1,"test qcm 1", " orthogonisteObservation 1 ");

        ObservableList<QuestionQcm>  questionsQcm2 = FXCollections.observableArrayList(
                new QuestionQcm("QuestionQcm 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
                new QuestionQcm("QuestionQcm 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
                new QuestionQcm("QuestionQcm 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2"))
                // Add more questions with answers as needed
        );
        Set<QuestionQcm> questionsQcmSet2 = new HashSet<>(questionsQcm2);
        Test testqcm2 = new TestQcm(questionsQcmSet2,"test qcm 2", " orthogonisteObservation 2 ");

        ObservableList<QuestionQcm>  questionsQcm3 = FXCollections.observableArrayList(
                new QuestionQcm("QuestionQcm 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
                new QuestionQcm("QuestionQcm 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
                new QuestionQcm("QuestionQcm 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2"))
                // Add more questions with answers as needed
        );
        Set<QuestionQcm> questionsQcmSet3 = new HashSet<>(questionsQcm3);
        Test testqcm3 = new TestQcm(questionsQcmSet3,"test qcm 3", " orthogonisteObservation 3 ");

        listtestsQcm = FXCollections.observableArrayList((TestQcm) testqcm1, (TestQcm) testqcm2, (TestQcm) testqcm3);


        for ( TestQcm testQcm : listtestsQcm) {
            HBox hbox = new HBox();
            Button button = new Button("voir details");
            Label label = new Label(testQcm.getNom());
            hbox.getChildren().addAll(label, button);
            listTestsVBox.getChildren().add(hbox);
            button.setOnAction(event -> {
                // display the details of the test
                renderTestQCM(testQcm);
            });
        }
    }
    public void renderlisttestsRpsLibres(){
        ObservableList<QuestionRpsLibres>  questionsRpsLibres1 = FXCollections.observableArrayList(
                new QuestionRpsLibres("QuestionRpsLibres 1 enouncé"),
                new QuestionRpsLibres("QuestionRpsLibres 2 enouncé"),
                new QuestionRpsLibres("QuestionQcm 3 enouncé")
                // Add more questions with answers as needed
        );
        Set<QuestionRpsLibres> questionsRpsLibresSet1 = new HashSet<>(questionsRpsLibres1);
        Test testRpsLibres1 = new TestRpsLibres(questionsRpsLibresSet1,"test RpsLibres 1", " orthogonisteObservation 1 ");

        ObservableList<QuestionRpsLibres>  questionsRpsLibres2 = FXCollections.observableArrayList(
                new QuestionRpsLibres("QuestionRpsLibres 1 enouncé  "),
                new QuestionRpsLibres("QuestionRpsLibres 2 enouncé  " ),
                new QuestionRpsLibres("QuestionRpsLibres 3 enouncé  " )
                // Add more questions with answers as needed
        );
        Set<QuestionRpsLibres> questionsRpsLibresSet2 = new HashSet<>(questionsRpsLibres2);
        Test testRpsLibres2 = new TestRpsLibres(questionsRpsLibresSet2,"test RpsLibres 2", " orthogonisteObservation 2 ");

        ObservableList<QuestionRpsLibres>  questionsRpsLibres3 = FXCollections.observableArrayList(
                new QuestionRpsLibres("QuestionRpsLibres 1 enouncé"),
                new QuestionRpsLibres("QuestionRpsLibres 2 enouncé"),
                new QuestionRpsLibres("QuestionRpsLibres 3 enouncé")
                // Add more questions with answers as needed
        );
        Set<QuestionRpsLibres> questionsRpsLibresSet3 = new HashSet<>(questionsRpsLibres3);
        Test testRpsLibres3 = new TestRpsLibres(questionsRpsLibresSet3,"test RpsLibres 3", " orthogonisteObservation 3 ");

        listtestsRpsLibres = FXCollections.observableArrayList((TestRpsLibres) testRpsLibres1, (TestRpsLibres) testRpsLibres2, (TestRpsLibres) testRpsLibres3);


        for ( TestRpsLibres testRpsLibres : listtestsRpsLibres) {
            HBox hbox = new HBox();
            Button button = new Button("voir details");
            Label label = new Label(testRpsLibres.getNom());
            hbox.getChildren().addAll(label, button);
            listTestsVBox.getChildren().add(hbox);
            button.setOnAction(event -> {
                // display the details of the test
                renderTestRpsLibres(testRpsLibres);
            });
        }
    }
    public void renderlisttestsExercices(){}
    public void renderlisttestsAnamnese(){}


}
