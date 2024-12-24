package com.example.calculatorApp.web.controllers;

// Template object for http requests to OperationController
public class OperationRequest {
    private String values;
    private String operationType;

    public String getValues() {
        return values;
    }

    public String getOperationType() {
        return operationType;
    }
}

