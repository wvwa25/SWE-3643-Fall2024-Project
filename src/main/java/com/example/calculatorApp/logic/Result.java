package com.example.calculatorApp.logic;

public class Result {
    private String result = "";
    private boolean isSuccess;
    private String operation;
    private String error;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getOperation() {
        return operation;
    }

    // for example, "1.25 + 3.8 ="
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getError() {
        return error;
    }

    // for example, "" or "Not A Number"
    public void setError(String error) {
        this.error = error;
    }
}