package main;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Date;

public class RiskManagerController {

    // Current open risk analysis and current targeted/opened risk
    private RiskAnalysis rA = null;
    private Risk currentRisk = null;

    // Redo'n'Undo risk matters
    Risk riskUndo = new Risk();
    ArrayList<String> textRedoables = new ArrayList<>();

    // GUI change
    enum ChangeType {
        DASHBOARD,
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
            case DASHBOARD -> {

            }
            case RISKANALYSIS -> {

                for (Risk currentRisk: rA.getRiskArrayList()) {

                    currentRisk.close(); // TODO Der kommer til at være en close() og open() metode som åbner og lukker risk på GUI

                    // TODO Create in GUI the risks in a table formation
                }

            }
            case RISK -> {

                riskDescription.setText(currentRisk.getDescription());
                riskProbability.setText(currentRisk.getProbability());
                riskConsequence.setText(currentRisk.getConsequence());
                riskPriority.setText(Integer.toString(currentRisk.getPriority()));
                riskRevisedProbability.setText(currentRisk.getRevisedProbability());
                riskRevisedConsequence.setText(currentRisk.getRevisedConsequence());
                riskCountermeasure.setText(currentRisk.getCounterMeasure());

            }
        }

        // TODO
    }

    // Handles all risk analysis matters
    public void createRiskAnalysis(String name) {
        updateGUI(ChangeType.RISKANALYSIS);
        RiskAnalysis newRiskAnalysis = new RiskAnalysis();
        // TODO
    }
    public void editRiskAnalaysis(RiskAnalysis rA) {
        for (int i = 0; i < rA.getRiskArrayList().size(); i++) {

        }
        updateGUI(ChangeType.RISKANALYSIS);

        // TODO
    }
    public void deleteRiskAnalysis(RiskAnalysis rA) {
        if(!rA.getRiskArrayList().isEmpty()){
        //TODO Make a printout saying the Analysis is not empty, and asks if the user is sure of their decision

        }else{

            updateGUI(ChangeType.RISKANALYSIS);
        }

        // TODO
    }
    public void saveRiskAnalysis(RiskAnalysis rA) {
        rA.setDate(new Date());
        updateGUI(ChangeType.DASHBOARD);
        // TODO
    }

    // Handles all risk matters

    public void editRisk() {
        updateGUI(ChangeType.RISK);
        // TODO find out a way to set r to the current risk open in GUI
        // TODO Call this method when exiting a risk, so when you dont want to edit the risk anymore

        // Call this when you exit the risk you were editing
        currentRisk.setDescription(riskDescription.getText());
        currentRisk.setProbability(riskProbability.getText());
        currentRisk.setConsequence(riskConsequence.getText());
        currentRisk.setPriority(Integer.parseInt(riskPriority.getText()));
        currentRisk.setRevisedProbability(riskRevisedProbability.getText());
        currentRisk.setRevisedConsequence(riskRevisedConsequence.getText());
        currentRisk.setCounterMeasure(riskCountermeasure.getText());



        // TODO
    }

    public void addRisk(RiskAnalysis rA) {

        rA.getRiskArrayList().add(new Risk());
        rA.getRiskArrayList().get(rA.getRiskArrayList().size()-1).open();
        updateGUI(ChangeType.RISKANALYSIS);

    }

    public void deleteRisk(RiskAnalysis rA, Risk currentRisk) {

        riskUndo = currentRisk;
        rA.getRiskArrayList().remove(currentRisk);
        updateGUI(ChangeType.RISKANALYSIS);

    }

    public void undoRisk(RiskAnalysis rA) {

        rA.getRiskArrayList().add(riskUndo);
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
    public void redoText(){
        //TODO
    }

    public void redoText(KeyEvent event1, KeyEvent event2) {

        if (event1.getCode() == KeyCode.CONTROL && event2.getCode() == KeyCode.Y) {


            updateGUI(ChangeType.RISK);
        }
        // TODO
    }



}
