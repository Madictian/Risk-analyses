package main;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Risk {

    private String description;
    private String probability;
    private String consequence;
    private int priority;
    private String revisedProbability;
    private String revisedConsequence;
    private String counterMeasure;

    @FXML
    TextArea riskDescription = new TextArea("Beskrivelse");
    @FXML
    TextField riskProbability = new TextField("1");
    @FXML
    TextField riskConsequence = new TextField("10 kr.");
    @FXML
    TextField riskPriority = new TextField("10");
    @FXML
    TextField riskRevisedProbability = new TextField("");
    @FXML
    TextField riskRevisedConsequence = new TextField("");
    @FXML
    TextArea riskCounterMeasure = new TextArea("Imødegåelsesstrategi");
    @FXML
    HBox riskTextFieldsContainer = new HBox(riskProbability, riskConsequence, riskPriority, riskRevisedProbability, riskRevisedConsequence);
    @FXML
    VBox riskHBoxContainer = new VBox(riskTextFieldsContainer, riskCounterMeasure);
    @FXML
    HBox riskContainer = new HBox(riskDescription, riskHBoxContainer);

    public TextArea getRiskDescription() {
        return riskDescription;
    }

    public TextField getRiskProbability() {
        return riskProbability;
    }

    public TextField getRiskConsequence() {
        return riskConsequence;
    }

    public TextField getRiskPriority() {
        return riskPriority;
    }

    public TextField getRiskRevisedProbability() {
        return riskRevisedProbability;
    }

    public TextField getRiskRevisedConsequence() {
        return riskRevisedConsequence;
    }

    public TextArea getRiskCounterMeasure() {
        return riskCounterMeasure;
    }

    public HBox getRiskContainer() {
        return riskContainer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getRevisedProbability() {
        return revisedProbability;
    }

    public void setRevisedProbability(String revisedProbability) {
        this.revisedProbability = revisedProbability;
    }

    public String getRevisedConsequence() {
        return revisedConsequence;
    }

    public void setRevisedConsequence(String revisedConsequence) {
        this.revisedConsequence = revisedConsequence;
    }

    public String getCounterMeasure() {
        return counterMeasure;
    }

    public void setCounterMeasure(String counterMeasure) {
        this.counterMeasure = counterMeasure;
    }

    public void open() {

        // increase height of the Hbox
        riskContainer.setPrefHeight(riskContainer.getHeight() * 3.5);

        // Set textfields and areas to Editable
        riskDescription.setEditable(true);
        riskProbability.setEditable(true);
        riskConsequence.setEditable(true);
        riskPriority.setEditable(true);
        riskRevisedProbability.setEditable(true);
        riskRevisedConsequence.setEditable(true);
        riskCounterMeasure.setEditable(true);

        riskDescription.setStyle("-fx-background-color: default");
        riskProbability.setStyle("-fx-background-color: default");
        riskConsequence.setStyle("-fx-background-color: default");
        riskPriority.setStyle("-fx-background-color: default");
        riskRevisedProbability.setStyle("-fx-background-color: default");
        riskRevisedConsequence.setStyle("-fx-background-color: default");
        riskCounterMeasure.setStyle("-fx-background-color: default");
    }

    public void close() {

        // reset height to defaults
        riskContainer.setPrefHeight(riskContainer.getHeight() / 3.5);

        // Set uneditable "correct?"
        riskDescription.setEditable(false);
        riskProbability.setEditable(false);
        riskConsequence.setEditable(false);
        riskPriority.setEditable(false);
        riskRevisedProbability.setEditable(false);
        riskRevisedConsequence.setEditable(false);
        riskCounterMeasure.setEditable(false);

        // Delete background
        riskDescription.setStyle("-fx-background-color: -fx-control-inner-background;");
        riskDescription.setStyle("-fx-background-color: -fx-control-inner-background;");
        riskProbability.setStyle("-fx-background-color: -fx-control-inner-background;");
        riskConsequence.setStyle("-fx-background-color: -fx-control-inner-background;");
        riskPriority.setStyle("-fx-background-color: -fx-control-inner-background;");
        riskRevisedProbability.setStyle("-fx-background-color: -fx-control-inner-background;");
        riskRevisedConsequence.setStyle("-fx-background-color: -fx-control-inner-background;");
        riskCounterMeasure.setStyle("-fx-background-color: -fx-control-inner-background;");
        /*
        * This might not work, so to be sure there is also this:
        * .setStyle("-fx-text-box-border: transparent; -fx-focus-color: transparent; -fx-background-color: -fx-control-inner-background; -fx-background-insets: 0; -fx-padding: 1 3 1 3;"); // does this even work
        what sorcery is this?
        * */


    }

    public Risk() {
        structureRisk();
        this.open();
    }

    public void structureRisk(){

        riskContainer = new HBox();
        riskHBoxContainer.setMinSize(723.0, 100);
        riskHBoxContainer.setMaxSize(723.0, 100);

        riskDescription = new TextArea("tilføj beskrivelse");
        riskDescription.setMinSize(196.0,100);
        riskDescription.setMaxSize(196.0, 100);

        Separator separator1 = new Separator();
        separator1.setOrientation(Orientation.VERTICAL);
        separator1.setMinHeight(riskContainer.getHeight());

        riskHBoxContainer = new VBox();
        riskHBoxContainer.setMaxSize(723, 100);
        riskHBoxContainer.setMinSize(723, 100);

        riskTextFieldsContainer = new HBox();
        riskTextFieldsContainer.setMaxSize(722, 24);
        riskTextFieldsContainer.setMinSize(722, 24);


        riskProbability = new TextField("1");
        riskProbability.setMinSize(86, 25.);
        riskProbability.setText("50%");
        riskProbability.setAlignment(Pos.CENTER);


        Separator separator3 = new Separator();
        separator3.setMinHeight(100);
        separator3.setOrientation(Orientation.VERTICAL);

        riskConsequence = new TextField("10 kr.");
        riskConsequence.setMinSize(174, 25.);
        riskConsequence.setText("50%");
        riskConsequence.setAlignment(Pos.CENTER);

        Separator separator4 = new Separator();
        separator4.setMinHeight(100);
        separator4.setOrientation(Orientation.VERTICAL);


        riskPriority = new TextField("10");
        riskPriority.setMinSize(74, 25.);
        riskPriority.setText("50%");
        riskPriority.setAlignment(Pos.CENTER);

        Separator separator5 = new Separator();
        separator5.setMinHeight(100);
        separator5.setOrientation(Orientation.VERTICAL);


        riskRevisedProbability = new TextField("");
        riskRevisedProbability.setMinSize(218, 25.);
        riskRevisedProbability.setText("50%");
        riskRevisedProbability.setAlignment(Pos.CENTER);

        Separator separator6 = new Separator();
        separator6.setMinHeight(100);
        separator6.setOrientation(Orientation.VERTICAL);


        riskRevisedConsequence = new TextField("");
        riskRevisedConsequence.setMinSize(86, 25.);
        riskRevisedConsequence.setText("50%");
        riskRevisedConsequence.setAlignment(Pos.CENTER);

        riskTextFieldsContainer.getChildren().addAll(
                riskProbability, separator3,
                riskConsequence, separator4,
                riskPriority, separator5,
                riskRevisedProbability, separator6,
                riskRevisedConsequence);

        riskCounterMeasure = new TextArea();
        riskCounterMeasure.setMaxSize(715, 72);
        riskCounterMeasure.setMinSize(715, 72);


        Separator separator2 = new Separator();
        separator2.setMinWidth(200);
        riskHBoxContainer.getChildren().addAll(riskTextFieldsContainer,separator2, riskCounterMeasure);



        riskContainer.getChildren().addAll(riskDescription, separator1, riskHBoxContainer);














    }
}
