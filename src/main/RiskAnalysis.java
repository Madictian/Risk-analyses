package main;

import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Date;

public class RiskAnalysis {

    private int userID;
    private String title;
    private ArrayList<Risk> riskArrayList = new ArrayList<Risk>();
    private Date date = new Date();

    private int ID;


    @FXML
    TextField riskAnalysisTitle = new TextField("Ny risiko analyse");
    @FXML
    TextField riskAnalysisDate = new TextField("Idag");
    @FXML
    Button viewButton = new Button("View");
    @FXML
    Button editButton = new Button("Edit");
    @FXML
    HBox riskAnalysisContainer = new HBox(riskAnalysisTitle, riskAnalysisDate, viewButton, editButton);

    public HBox getRiskAnalysisContainer() {
        return riskAnalysisContainer;
    }

    public RiskAnalysis() {
        risky();
    }

    public Button getEditButton() {
        return editButton;
    }

    public void risky(){
        riskAnalysisContainer = new HBox();
        riskAnalysisContainer.setMinSize(656.0, 25.0);
        riskAnalysisContainer.setMaxSize(656.0, 25.0);



        editButton = new Button("Edit");
        editButton.setPrefSize(89.0, 17.0);

        viewButton = new Button("View");
        viewButton.setPrefSize(89.0, 17.0);


        riskAnalysisTitle = new TextField("Title");
        riskAnalysisTitle.setPrefSize(296.0, 25.0);


        riskAnalysisDate = new TextField("Idag");
        riskAnalysisDate.setPrefSize(187.0, 25.0);


        riskAnalysisContainer.getChildren().addAll(riskAnalysisTitle,riskAnalysisDate,editButton,viewButton);
    }


    @FXML
    VBox riskListContainer = new VBox(/*TODO find a way to input arraylist*//*(getRiskArrayList())*/);

    public RiskAnalysis(int userID, String title, int ID) {
        this.userID = userID;
        this.title = title;
        this.ID = ID;
        risky();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Risk> getRiskArrayList() {
        return riskArrayList;
    }

    public void add(Risk risk) {
        riskArrayList.add(risk);
    }
    public void remove(Risk risk) {
        riskArrayList.remove(risk);
    }
    public boolean isEmpty() {
        return riskArrayList.isEmpty();
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
