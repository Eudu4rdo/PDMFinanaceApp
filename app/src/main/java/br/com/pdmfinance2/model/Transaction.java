package br.com.pdmfinance2.model;

public class Transaction {
    private String Description;
    private Float Value;

    public Transaction(String description, Float value) {
        Description = description;
        Value = value;
    }
    public String getDescription() {
        return Description;
    }

    public Float getValue() {
        return Value;
    }
}
