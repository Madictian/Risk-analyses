package main;

public class Risk {
    private String description;

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


    private String probability;
    private String consequence;
    private int priority;
    private String revisedProbability;
    private String revisedConsequence;
    private String counterMeasure;
}
