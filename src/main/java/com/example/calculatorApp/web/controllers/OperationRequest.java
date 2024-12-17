package com.example.calculatorApp.web.controllers;

public class OperationRequest {
    private String values;
    private String operationType;

    // Getters and Setters
    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}

