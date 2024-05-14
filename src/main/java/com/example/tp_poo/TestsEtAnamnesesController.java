package com.example.tp_poo;

import com.example.tp_poo.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TestsEtAnamnesesController implements Initializable {
    @FXML
   private ListView<String> listView;
    @FXML
    private VBox questionsVBox;
    @FXML
   // private HBox propositionsHBox;
    private ObservableList<QuestionQcm> questionsQcm;
    private ObservableList<QuestionQcu> questionsQcu;
    private ObservableList<QuestionRpsLibres> questionsRpsLibres;
    private ObservableList<Exercice> exercices;
    private ObservableList<QuestionAnamnese> anamneses; // pour enfant
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList(
                "QCU", // ou bien Tests QCU
                "QCM",
                "Reponse libres",
                "Exercices",
                "Anamnèse"

        );

        // Crée un ListView pour afficher les éléments

         listView.setItems(items);
        //listView.setStyle("-fx-background-color: transparent;");


        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null && selectedItem.equals("QCM")) {
                renderQuestionsQCM();
            }
            if (selectedItem != null && selectedItem.equals("QCU")) {
                renderQuestionsQCU();
            }
            if (selectedItem != null && selectedItem.equals("Reponse libres")) {
                renderQuestionsRpsLibres();
            }
            if (selectedItem != null && selectedItem.equals("Exercices")) {
                renderExercices();
            }
            if (selectedItem != null && selectedItem.equals("Anamnèse")) {
                renderQuestionsAnamnese();
            }
        });


    }

    public void renderQuestionsQCM(){
        questionsQcm = FXCollections.observableArrayList(
                new QuestionQcm("QuestionQcm 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 2")),
                new QuestionQcm("QuestionQcm 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 2", "Proposition 3")),
                new QuestionQcm("QuestionQcm 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), Arrays.asList("Proposition 1", "Proposition 3"))
                // Add more questions with answers as needed
        );
        questionsVBox.getChildren().clear();
       // propositionsHBox.getChildren().clear();
        for (QuestionQcm question : questionsQcm) {
            Label label = new Label(question.getQuestionEnonce());
            //questionsVBox.getChildren().add(label);
            HBox propositionsHBox = new HBox();
            propositionsHBox.setSpacing(10);

           // System.out.println(question.getListpropositions());
            for (String proposition : question.getListpropositions()) {

                CheckBox checkBox = new CheckBox(proposition);
                propositionsHBox.getChildren().add(checkBox);

            }
            questionsVBox.getChildren().addAll(label,propositionsHBox);
        }
    }
    public void renderQuestionsQCU(){
        questionsQcu = FXCollections.observableArrayList(
                new QuestionQcu("QuestionQcu 1 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 1"),
                new QuestionQcu("QuestionQcu 2 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 2"),
                new QuestionQcu("QuestionQcu 3 enouncé", Arrays.asList("Proposition 1", "Proposition 2", "Proposition 3"), "Proposition 3")
                // Add more questions with answers as needed
        );
        questionsVBox.getChildren().clear();

        // propositionsHBox.getChildren().clear();
        for (QuestionQcu question : questionsQcu) {
            Label label = new Label(question.getQuestionEnonce());
            //questionsVBox.getChildren().add(label);
            HBox propositionsHBox = new HBox();
            propositionsHBox.setSpacing(10);
            ToggleGroup toggleGroup = new ToggleGroup();

            // System.out.println(question.getListpropositions());
            for (String proposition : question.getListpropositions()) {
                RadioButton radioButton = new RadioButton(proposition);
                radioButton.setToggleGroup(toggleGroup);
                propositionsHBox.getChildren().add(radioButton);

            }
            questionsVBox.getChildren().addAll(label,propositionsHBox);
        }
    }
    public void renderQuestionsRpsLibres(){
        questionsRpsLibres = FXCollections.observableArrayList(
                new QuestionRpsLibres("QuestionRpsLibres 1 enouncé"),
                new QuestionRpsLibres("QuestionRpsLibres 2 enouncé"),
                new QuestionRpsLibres("QuestionRpsLibres 3 enouncé")
                // Add more questions with answers as needed
        );
        questionsVBox.getChildren().clear();
        // propositionsHBox.getChildren().clear();
        for (QuestionRpsLibres question : questionsRpsLibres) {
            Label label = new Label(question.getQuestionEnonce());
            //questionsVBox.getChildren().add(label);
            TextArea textArea = new TextArea();
            questionsVBox.getChildren().addAll(label,textArea);
        }
    }
    public void renderExercices(){
        exercices = FXCollections.observableArrayList(
                new Exercice("Exercice 1 ", "Exercice 1 consigne", "Exercice 1 materiel"),
                new Exercice("Exercice 2 ", "Exercice 2 consigne", "Exercice 2 materiel"),
                new Exercice("Exercice 3 ", "Exercice 3 consigne", "Exercice 3 materiel")

                // Add more questions with answers as needed
        );
        questionsVBox.getChildren().clear();
        // propositionsHBox.getChildren().clear();
        for (Exercice exercice : exercices) {
            Label label = new Label(exercice.getNomExo());
            //questionsVBox.getChildren().add(label);
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
            questionsVBox.getChildren().addAll(label);
        }
    }
    public void renderQuestionsAnamnese(){
        anamneses = FXCollections.observableArrayList(
                new QuestionAnamnese("QuestionAnamnese 1 enouncé", Categories.ANTECEDENTS_FAMILIAUX),
                new QuestionAnamnese("QuestionAnamnese 2 enouncé", Categories.CARACTERE),
                new QuestionAnamnese("QuestionAnamnese 3 enouncé", Categories.CONDITIONS_NATALES)
                // Add more questions with answers as needed
        );
        questionsVBox.getChildren().clear();
        // propositionsHBox.getChildren().clear();
        for (QuestionAnamnese question : anamneses) {
            Label label = new Label(question.getQuestionEnonce());
            //questionsVBox.getChildren().add(label);
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
            questionsVBox.getChildren().addAll(label);
        }
    }
}
