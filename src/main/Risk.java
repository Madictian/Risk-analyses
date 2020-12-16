package main;

import javafx.fxml.FXML;
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


    public Risk(VBox riskListContainer) {

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
}
