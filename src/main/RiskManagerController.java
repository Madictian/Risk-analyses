package main;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class RiskManagerController {

    // Current open risk analysis and current targeted/opened risk
    private RiskAnalysis rA = null;
    private Risk currentRisk = null;

    // Redo'n'Undo risk matters
    Risk riskUndo = new Risk();
    ArrayList<String> textRedoables = new ArrayList<>();

    // GUI change
    enum ChangeType {
        RISKANALYSIS,
        RISK;
    }

    // FXML elements
    @FXML
    TextArea riskDescription;
    @FXML
    TextField riskProbability;
    @FXML
    TextField riskConsequence;
    @FXML
    TextField riskPriority;
    @FXML
    TextField riskRevisedProbability;
    @FXML
    TextField riskRevisedConsequence;
    @FXML
    TextArea riskCountermeasure;

    // FXML methods
    @FXML
    public void updateChange(String currentText) {

        textRedoables.add(currentText);

    }

    private void updateGUI(ChangeType type) {

        switch (type) {
            case RISKANALYSIS -> {

            }
            case RISK -> {
                riskDescription.setText(currentRisk.description);
                riskProbability.setText(currentRisk.probability);
                riskConsequence.setText(currentRisk.consequence);
                riskPriority.setText(Integer.toString(currentRisk.priority));
                riskRevisedProbability.setText(currentRisk.revisedProbability);
                riskRevisedConsequence.setText(currentRisk.revisedConsequence);
                riskCountermeasure.setText(currentRisk.counterMeasure);
            }
        }

        // TODO
    }

    // Handles all risk analysis matters
    public void createRiskAnalysis(String name) {

        RiskAnalysis newRiskAnalysis = new RiskAnalysis();
        // TODO
    }
    public void editRiskAnalaysis(RiskAnalysis rA) {


        // TODO
    }
    public void deleteRiskAnalysis(RiskAnalysis rA) {

        // TODO
    }
    public void saveRiskAnalysis(RiskAnalysis rA) {
        // TODO
    }

    // Handles all risk matters
    public void editRisk() {

        // TODO find out a way to set r to the current risk open in GUI

        // Call this when you exit the risk you were editing
        currentRisk.description = riskDescription.getText();
        currentRisk.probability = riskProbability.getText();
        currentRisk.consequence = riskConsequence.getText();
        currentRisk.priority = Integer.parseInt(riskPriority.getText());
        currentRisk.revisedProbability = riskRevisedProbability.getText();
        currentRisk.revisedConsequence = riskRevisedConsequence.getText();
        currentRisk.counterMeasure = riskCountermeasure.getText();



        // TODO
    }

    public void addRisk(RiskAnalysis rA) {

        rA.riskArrayList.add(new Risk());
        updateGUI(ChangeType.RISKANALYSIS);

    }

    public void deleteRisk(RiskAnalysis rA, Risk currentRisk) {

        riskUndo = currentRisk;
        rA.riskArrayList.remove(currentRisk);
        updateGUI(ChangeType.RISKANALYSIS);

    }

    public void undoRisk(RiskAnalysis rA) {

        rA.riskArrayList.add(riskUndo);
        updateGUI(ChangeType.RISKANALYSIS);

    }

    // Risk Text
    @FXML
    public void undoText() {

        updateGUI(ChangeType.RISK);
        // TODO
    }

    public void undoText(KeyEvent event1, KeyEvent event2) {

        if (event1.getCode() == KeyCode.CONTROL && event2.getCode() == KeyCode.Z) {


            updateGUI(ChangeType.RISK);
        }

        // TODO
    }

    public void redoText() {
        // TODO
    }



}
