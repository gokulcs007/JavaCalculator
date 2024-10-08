package com.sample.javadesign;

public class Numbers {

    private int number1;
    private int number2;
    private String operation;
    private String inputString; // New field for string input


    // Getters and Setters
    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public String setOperation(String operation) {
        this.operation = operation;
        return  operation;
    }
    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

}
