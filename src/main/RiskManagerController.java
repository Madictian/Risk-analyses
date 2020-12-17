package main;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiskManagerController {

    // Current open risk analysis and current targeted/opened risk
    private RiskAnalysis currentRiskAnalysis = null;
    private Risk currentRisk = null;
    private int currentUserId = 0;

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
    VBox riskAnalysisList;
    String riskAnalysisTitle;
    @FXML
    VBox riskList;

    public ArrayList<RiskAnalysis> riskAnalysisArrayList = new ArrayList<>();

    // FXML methods
    @FXML
    public void updateChange(String currentText) {

        textRedoables.add(currentText);

    }


    private void updateGUI(ChangeType type) {

        switch (type) {
            case DASHBOARD -> {

                ArrayList<Object> riskAnalysisObjects = new ArrayList<>();

                for (int i = 0; i < riskAnalysisArrayList.size(); i++) {

                    riskAnalysisObjects.add(riskAnalysisArrayList.get(i).getRiskAnalysisContainer());

                }

                List list = riskAnalysisObjects;
                //riskAnalysisList.getChildren().removeAll(list);
                riskAnalysisList.getChildren().clear();
                riskAnalysisList.getChildren().addAll(list);

            }
            case RISKANALYSIS -> {

                ArrayList<Object> riskObjects = new ArrayList<>();

                for (Risk currentRisk: currentRiskAnalysis.getRiskArrayList()) {

                    riskObjects.add(currentRisk.getRiskContainer());
                    currentRisk.close();

                }

                List list = riskObjects;
                //riskList.getChildren().removeAll(list);
                riskList.getChildren().clear();
                riskList.getChildren().addAll(list);

            }
            case RISK -> {

                for (int i = 0; i < currentRiskAnalysis.getRiskArrayList().size(); i++) {
                    currentRisk.getRiskDescription().setText(currentRisk.getDescription());
                    currentRisk.getRiskProbability().setText(currentRisk.getProbability());
                    currentRisk.getRiskConsequence().setText(currentRisk.getConsequence());
                    currentRisk.getRiskPriority().setText(Integer.toString(currentRisk.getPriority()));
                    currentRisk.getRiskRevisedProbability().setText(currentRisk.getRevisedProbability());
                    currentRisk.getRiskRevisedConsequence().setText(currentRisk.getRevisedConsequence());
                    currentRisk.getRiskCounterMeasure().setText(currentRisk.getCounterMeasure());
                }

            }
        }

        // TODO
    }

    // Handles all risk analysis matters
    public void getRiskAnalysis() {
        for (int i = 0; i < riskAnalysisArrayList.size(); i++) {
            if (riskAnalysisTitle.equals(riskAnalysisArrayList.get(i).getTitle())) {
                currentRiskAnalysis = riskAnalysisArrayList.get(i);
            }
        }
    }

    public void createRiskAnalysis() {
        RiskAnalysis newRiskAnalysis = new RiskAnalysis(currentUserId, "", riskAnalysisArrayList.size());
        newRiskAnalysis.setDate(new Date());
        riskAnalysisArrayList.add(newRiskAnalysis);
        newRiskAnalysis.getEditButton().setOnAction(e -> editRiskAnalysis(newRiskAnalysis));
        updateGUI(ChangeType.DASHBOARD);
    }

    @FXML
    public void editRiskAnalysis(RiskAnalysis rA) {

        // TODO Change tabs

        currentRiskAnalysis = rA;

        for (int i = 0; i < rA.getRiskArrayList().size(); i++) {

            currentRisk = rA.getRiskArrayList().get(i);
            currentRisk.setDescription(currentRisk.getRiskDescription().getText());
            currentRisk.setProbability(currentRisk.getRiskProbability().getText());
            currentRisk.setConsequence(currentRisk.getRiskConsequence().getText());
            currentRisk.setPriority(Integer.parseInt(currentRisk.getRiskPriority().getText()));
            currentRisk.setRevisedProbability(currentRisk.getRiskRevisedProbability().getText());
            currentRisk.setRevisedConsequence(currentRisk.getRiskRevisedConsequence().getText());
            currentRisk.setCounterMeasure(currentRisk.getRiskCounterMeasure().getText());
            currentRisk.close();

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
        currentRisk.setDescription(currentRisk.getRiskDescription().getText());
        currentRisk.setProbability(currentRisk.getRiskProbability().getText());
        currentRisk.setConsequence(currentRisk.getRiskConsequence().getText());
        currentRisk.setPriority(Integer.parseInt(currentRisk.getRiskPriority().getText()));
        currentRisk.setRevisedProbability(currentRisk.getRiskRevisedProbability().getText());
        currentRisk.setRevisedConsequence(currentRisk.getRiskRevisedConsequence().getText());
        currentRisk.setCounterMeasure(currentRisk.getRiskCounterMeasure().getText());



        // TODO
    }

    public void addRisk() {

        currentRiskAnalysis.getRiskArrayList().add(new Risk());
        currentRiskAnalysis.getRiskArrayList().get(currentRiskAnalysis.getRiskArrayList().size()-1).open();
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
