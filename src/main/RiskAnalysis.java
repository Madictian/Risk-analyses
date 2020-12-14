package main;

import java.util.ArrayList;
import java.util.Date;

public class RiskAnalysis {
    private int ID;

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

    private int userID;
    private String title;
    private ArrayList<Risk> riskArrayList = new ArrayList<Risk>();
    private Date date = new Date();
}
