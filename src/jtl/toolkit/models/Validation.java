package jtl.toolkit.models;

import java.util.ArrayList;

public class Validation {
    public String componentType;
    public Integer componentLevel;
    public Boolean validationResult;
    public String validationMessage;
    public ArrayList<String> statsInError;
    public ArrayList<String> reasonsForError;
    
    public Validation() {
        this.componentType = "";
        this.componentLevel = 0;
        this.validationResult = true;
        this.validationMessage = "";
        this.statsInError = new ArrayList<>();
        this.reasonsForError = new ArrayList<>();
    }
}
