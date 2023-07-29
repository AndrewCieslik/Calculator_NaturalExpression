package com.example.model;

public class OperationModel {

    private String operation;
    private String a;
    private String b;
    private String operator;
    private String naturalExpression;

    public String getWebResult() {
        return webResult;
    }

    public void setWebResult(String webResult) {
        this.webResult = webResult;
    }

    private String webResult;

    private boolean nowSecondNumber;

    public OperationModel() {
    }

    public OperationModel(String operation) {
        this.operation = operation;
    }

    public OperationModel(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public boolean getNowSecondNumber() {
        return nowSecondNumber;
    }

    public void setNowSecondNumber(boolean nowSecondNumber) {
        this.nowSecondNumber = nowSecondNumber;
    }


    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNaturalExpression() {
        return naturalExpression;
    }

    public void setNaturalExpression(String naturalRecord) {
        this.naturalExpression = naturalRecord;
    }
}
