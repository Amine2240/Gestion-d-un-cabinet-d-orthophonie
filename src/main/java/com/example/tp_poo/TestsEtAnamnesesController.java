package com.example.tp_poo;

import com.calendarfx.view.print.PrintView;
import com.example.tp_poo.models.*;
import impl.com.calendarfx.view.NumericTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class TestsEtAnamnesesController implements Initializable {
    @FXML
   private ListView<String> listView;
   @FXML
   private HBox containerHbox ; // the selected test and list of title tests of each categorie
    @FXML
    private VBox selectedTestVBox = new VBox(); // the selected test
    @FXML
    private VBox listTestsVBox;



   // private HBox propositionsHBox;
    //private ObservableList<QuestionQcm> questionsQcm;
    //private ObservableList<QuestionQcu> questionsQcu;
    //private ObservableList<QuestionRpsLibres> questionsRpsLibres;
    //private ObservableList<Exercice> exercices;
    //private ObservableList<QuestionAnamnese> anamneses; // pour enfant



    private TextField questionQcuEnonce;
    private NumericTextField nbrePropositions;
    private Button createPropositionsButton;
    private Question questionqcu;
    private QuestionAnamnese questionanamnese;
    private TextField questionanamneseEnonceField;
    private ChoiceBox<Categories> questionanamneseCategorieField;
   // private List<String> propositionsQcu = new ArrayList<>();
    private TextField reponseJusteField;
    private List<TextField> propositionsQcuFields = new ArrayList<>();


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



    ObservableList<Exercice> exercices1 = FXCollections.observableArrayList(
            new Exercice("Exercice 1 ", "Exercice 1 consigne", "Exercice 1 materiel"),
            new Exercice("Exercice 2 ", "Exercice 2 consigne", "Exercice 2 materiel"),
            new Exercice("Exercice 3 ", "Exercice 3 consigne", "Exercice 3 materiel")

            // Add more questions with answers as needed
    );
    ArrayList<Exercice> listexercices1 = new ArrayList<>(exercices1);
    TestExerices testExerices1 = new TestExerices("test exercice 1 ", "orthophonisite observation 1 ", listexercices1);

    ObservableList<Exercice> exercices2 = FXCollections.observableArrayList(
            new Exercice("Exercice 1 ", "Exercice 1 consigne", "Exercice 1 materiel"),
            new Exercice("Exercice 2 ", "Exercice 2 consigne", "Exercice 2 materiel"),
            new Exercice("Exercice 3 ", "Exercice 3 consigne", "Exercice 3 materiel")

            // Add more questions with answers as needed
    );
    ArrayList<Exercice> listexercices2 = new ArrayList<>(exercices2);
    TestExerices testExerices2 = new TestExerices("test exercice 2 ", "orthophonisite observation 2 ",  listexercices2);

    ObservableList<Exercice> exercices3 = FXCollections.observableArrayList(
            new Exercice("Exercice 1 ", "Exercice 1 consigne", "Exercice 1 materiel"),
            new Exercice("Exercice 2 ", "Exercice 2 consigne", "Exercice 2 materiel"),
            new Exercice("Exercice 3 ", "Exercice 3 consigne", "Exercice 3 materiel")

            // Add more questions with answers as needed
    );
    ArrayList<Exercice> listexercices3 = new ArrayList<>(exercices3);
    TestExerices testExerices3 = new TestExerices("test exercice 3 ", "orthophonisite observation 3 ", listexercices3);


    ObservableList<QuestionAnamnese> anamneses1 = FXCollections.observableArrayList(
            new QuestionAnamnese("QuestionAnamnese 1 enouncé", Categories.ANTECEDENTS_FAMILIAUX),
            new QuestionAnamnese("QuestionAnamnese 2 enouncé", Categories.CARACTERE),
            new QuestionAnamnese("QuestionAnamnese 3 enouncé", Categories.CONDITIONS_NATALES)
            // Add more questions with answers as needed
    );
    ArrayList<QuestionAnamnese> listanamneses1 = new ArrayList<>(anamneses1);
    AnamneseEnfant testAnamnese1 = new AnamneseEnfant( "test anamnese 1",listanamneses1);

    ObservableList<QuestionAnamnese> anamneses2 = FXCollections.observableArrayList(
            new QuestionAnamnese("QuestionAnamnese 1 enouncé", Categories.ANTECEDENTS_FAMILIAUX),
            new QuestionAnamnese("QuestionAnamnese 2 enouncé", Categories.CARACTERE),
            new QuestionAnamnese("QuestionAnamnese 3 enouncé", Categories.CONDITIONS_NATALES)
            // Add more questions with answers as needed
    );
    ArrayList<QuestionAnamnese> listanamneses2 = new ArrayList<>(anamneses2);
    AnamneseEnfant testAnamnese2 = new AnamneseEnfant("test anamnese 2",listanamneses2);



    private ObservableList<TestQcm> listtestsQcm = FXCollections.observableArrayList((TestQcm) testqcm1, (TestQcm) testqcm2, (TestQcm) testqcm3);
    private ObservableList<TestQcu> listtestsQcu = FXCollections.observableArrayList((TestQcu) testqcu1, (TestQcu) testqcu2, (TestQcu) testqcu3);
    private ObservableList<TestExerices> listtestsExercices = FXCollections.observableArrayList((TestExerices) testExerices1, (TestExerices) testExerices2, (TestExerices) testExerices3);;
    private ObservableList<TestRpsLibres> listtestsRpsLibres = FXCollections.observableArrayList((TestRpsLibres) testRpsLibres1, (TestRpsLibres) testRpsLibres2, (TestRpsLibres) testRpsLibres3);;
    // private ObservableList<AnamneseAdulte> listtestsAnamneseAdults;
    private ObservableList<AnamneseEnfant> listtestsAnamneseEnfant =  FXCollections.observableArrayList((AnamneseEnfant) testAnamnese1, (AnamneseEnfant) testAnamnese2);;



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

    public Node renderTestQCU(TestQcu testQcu)  {

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
        Button ajouterQuestionQcu = new Button("Ajouter question Qcu");
        selectedTestVBox.getChildren().add(ajouterQuestionQcu);
        ajouterQuestionQcu.setOnAction(event -> {
            showFormulaire(testQcu);
        });
        return selectedTestVBox;
    }
    public void showFormulaire(TestQcu testQcu){
        Dialog dialog = new Dialog();
        dialog.setHeaderText("Ajouter Test qcu");
        dialog.setResizable(true);
        dialog.getDialogPane().setPrefSize(480, 320);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(createformulaireContent());
        Optional result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Extract the text from the TextFields and store in propositionsQcu
            List<String> propositionsText = propositionsQcuFields.stream()
                    .map(TextField::getText)
                    .collect(Collectors.toList());
            questionqcu = new QuestionQcu(questionQcuEnonce.getText(), propositionsText, reponseJusteField.getText());
            testQcu.getListQuestionsQcu().add((QuestionQcu) questionqcu);
            System.out.println("question qcu ajoutée");
            renderTestQCU(testQcu);


        }
    }
    public void showFormulaireAnamnese(AnamneseEnfant anamnese) {
        Dialog dialog = new Dialog();
        dialog.setHeaderText("Ajouter Question Anamnese");
        dialog.setResizable(true);
        dialog.getDialogPane().setPrefSize(480, 320);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(createformulaireAnamneseContent());
        Optional result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Extract the text from the TextFields and store in propositionsQcu

            questionanamnese = new QuestionAnamnese(questionanamneseEnonceField.getText(), questionanamneseCategorieField.getValue());
            anamnese.getListQuestions().add((QuestionAnamnese) questionanamnese);
            System.out.println("question anamnese ajoutée");
            renderTestAnamnese(anamnese);

        }
    }
    public Node createformulaireAnamneseContent(){
        VBox vBox = new VBox();
        questionanamneseEnonceField = new TextField();
        questionanamneseEnonceField.setPromptText("qustion anamnese enonce");
        questionanamneseCategorieField = new ChoiceBox<>();
        questionanamneseCategorieField.setItems(FXCollections.observableArrayList(Categories.values()));
        questionanamneseCategorieField.setValue(Categories.ANTECEDENTS_FAMILIAUX);

        vBox.getChildren().addAll(questionanamneseEnonceField , questionanamneseCategorieField);

        return  vBox;
    }

    public Node createformulaireContent(){
        VBox vBox = new VBox();
         questionQcuEnonce = new TextField();
        questionQcuEnonce.setPromptText("qustion Qcu enonce");
         nbrePropositions = new NumericTextField();
        nbrePropositions.setPromptText("nombre de propositions");
         createPropositionsButton = new Button("Create Propositions");
        createPropositionsButton.setOnAction(e -> {
            // Clear existing TextFields if any
           // vBox.getChildren().removeIf(node -> node instanceof TextField && node != nbrePropositions);
            // Clear previous propositionsQcu list
            propositionsQcuFields.clear();
            // Get the number of propositions from the NumericTextField
            int numberOfPropositions = Integer.parseInt(nbrePropositions.getText());

            // Create and add TextFields based on the specified number
            for (int i = 0; i < numberOfPropositions; i++) {
                TextField propositionField = new TextField();
                propositionField.setPromptText("proposition " + (i + 1));
                vBox.getChildren().add(propositionField);
                propositionsQcuFields.add(propositionField);
            }
        });
         reponseJusteField = new TextField();
        reponseJusteField.setPromptText("reponse juste");

        vBox.getChildren().addAll(questionQcuEnonce, nbrePropositions, createPropositionsButton , reponseJusteField);



        //fill vbox
        return vBox;
    }
    public Node renderTestQCM(TestQcm testQcm){

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
        return selectedTestVBox;
    }
    public Node renderTestRpsLibres(TestRpsLibres testRpsLibres){

        selectedTestVBox.getChildren().clear();
        Label testRpsLibreslabel = new Label(testRpsLibres.getNom());
        selectedTestVBox.getChildren().add(testRpsLibreslabel);
        // propositionsHBox.getChildren().clear();
        VBox vboxLibre = new VBox();
        for (QuestionRpsLibres question : testRpsLibres.getListQuestionsRpsLibres()) {
            Label label = new Label(question.getQuestionEnonce());
            //selectedTestVBox.getChildren().add(label);
            TextArea textArea = new TextArea();
            selectedTestVBox.setMargin(textArea, new javafx.geometry.Insets(0, 20, 10, 20));
            vboxLibre.getChildren().addAll(label , textArea);
        }
        selectedTestVBox.getChildren().addAll(vboxLibre);
        return selectedTestVBox;
    }
    public Node renderTestExercices(TestExerices testExerices){

        selectedTestVBox.getChildren().clear();
        Label testexercicelabel = new Label(testExerices.getNom());
        selectedTestVBox.getChildren().add(testexercicelabel);
        VBox vboxExo = new VBox();
        for (Exercice exercice : testExerices.getListExercices()) {

            Label label = new Label(exercice.getNomExo());
            Label consigneLabel = new Label(exercice.getConsigneExo());
            Label materielLabel = new Label(exercice.getNomMaterielExo());
            vboxExo.getChildren().addAll(label , consigneLabel , materielLabel);

        }
        selectedTestVBox.getChildren().addAll(vboxExo);
        return selectedTestVBox;
    }
    public Node renderTestAnamnese(AnamneseEnfant anamneseEnfant){

        selectedTestVBox.getChildren().clear();

        Label testanamneselabel = new Label(anamneseEnfant.getNom());
        selectedTestVBox.getChildren().add(testanamneselabel);
        VBox vboxAnam = new VBox();
        for (QuestionAnamnese question : anamneseEnfant.getListQuestions()) {
            HBox labelEtCategHBox = new HBox();
            Label label = new Label(question.getQuestionEnonce());

            Label categorieLabel = new Label(question.getQuestionCategorie().toString());
            labelEtCategHBox.getChildren().addAll(label, categorieLabel);;
            labelEtCategHBox.setSpacing(50);
           TextArea textArea = new TextArea();
           selectedTestVBox.setMargin(textArea, new javafx.geometry.Insets(0, 20, 10, 20));
            vboxAnam.getChildren().addAll(labelEtCategHBox , textArea);
        }

        Button ajouterQuestionAnamnese = new Button("Ajouter question Anamnese");
        ajouterQuestionAnamnese.setOnAction(event -> {
            showFormulaireAnamnese(anamneseEnfant);
        });
        selectedTestVBox.getChildren().addAll( vboxAnam , ajouterQuestionAnamnese);
        return selectedTestVBox;
    }

    public void renderlisttestsQCU(){
        // it will be a loop to display all the tests



        for ( TestQcu testQcu : listtestsQcu) {
            HBox hbox = new HBox();
            Button detailsbutton = new Button("voir details");
            Button suppButton = new Button("supprimer");
            Label label = new Label(testQcu.getNom());
            hbox.getChildren().addAll(label, detailsbutton , suppButton);
            listTestsVBox.getChildren().add(hbox);
            detailsbutton.setOnAction(event -> {
                // display the details of the test
                renderTestQCU(testQcu);
            });
            suppButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Confirmer la suppression");
                alert.setContentText("Voulez-vous vraiment supprimer ce test?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    // delete the test
                    listtestsQcu.remove(testQcu);
                    listTestsVBox.getChildren().remove(hbox);
                    selectedTestVBox.getChildren().clear();
                }

            });
        }

    }
    public void renderlisttestsQCM(){



        for ( TestQcm testQcm : listtestsQcm) {
            HBox hbox = new HBox();
            Button button = new Button("voir details");
            Button suppButton = new Button("supprimer");
            Label label = new Label(testQcm.getNom());
            hbox.getChildren().addAll(label, button , suppButton);
            listTestsVBox.getChildren().add(hbox);
            button.setOnAction(event -> {
                // display the details of the test
                renderTestQCM(testQcm);
            });
            suppButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Confirmer la suppression");
                alert.setContentText("Voulez-vous vraiment supprimer ce test?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    // delete the test
                    listtestsQcm.remove(testQcm);
                    listTestsVBox.getChildren().remove(hbox);
                    selectedTestVBox.getChildren().clear();
                }

            });
        }
    }
    public void renderlisttestsRpsLibres(){



        for ( TestRpsLibres testRpsLibres : listtestsRpsLibres) {
            HBox hbox = new HBox();
            Button button = new Button("voir details");
            Label label = new Label(testRpsLibres.getNom());
            Button suppButton = new Button("supprimer");
            hbox.getChildren().addAll(label, button , suppButton);
            listTestsVBox.getChildren().add(hbox);
            button.setOnAction(event -> {
                // display the details of the test
                renderTestRpsLibres(testRpsLibres);
            });
            suppButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Confirmer la suppression");
                alert.setContentText("Voulez-vous vraiment supprimer ce test?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    // delete the test
                    listtestsRpsLibres.remove(testRpsLibres);
                    listTestsVBox.getChildren().remove(hbox);
                    selectedTestVBox.getChildren().clear();
                }

            });
        }
    }
    public void renderlisttestsExercices(){


        for ( TestExerices testexo : listtestsExercices) {
            HBox hbox = new HBox();
            Button button = new Button("voir details");
            Label label = new Label(testexo.getNom());
            Button suppButton = new Button("supprimer");
            hbox.getChildren().addAll(label, button , suppButton);
            listTestsVBox.getChildren().add(hbox);
            button.setOnAction(event -> {
                // display the details of the test
                renderTestExercices(testexo);
            });
            suppButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Confirmer la suppression");
                alert.setContentText("Voulez-vous vraiment supprimer ce test?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    // delete the test
                    listtestsExercices.remove(testexo);
                    listTestsVBox.getChildren().remove(hbox);
                    selectedTestVBox.getChildren().clear();
                }

            });
        }
    }
    public void renderlisttestsAnamnese(){

        for ( AnamneseEnfant testAnamnese : listtestsAnamneseEnfant) {
            HBox hbox = new HBox();
            Button button = new Button("voir details");
            Label label = new Label(testAnamnese.getNom());
            Button suppButton = new Button("supprimer");
            hbox.getChildren().addAll(label, button , suppButton);
            listTestsVBox.getChildren().add(hbox);
            button.setOnAction(event -> {
                // display the details of the test
                renderTestAnamnese(testAnamnese);
            });
            suppButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Confirmer la suppression");
                alert.setContentText("Voulez-vous vraiment supprimer ce test?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    // delete the test
                    listtestsAnamneseEnfant.remove(testAnamnese);
                    listTestsVBox.getChildren().remove(hbox);
                    selectedTestVBox.getChildren().clear();
                }

            });
        }
    }


}
