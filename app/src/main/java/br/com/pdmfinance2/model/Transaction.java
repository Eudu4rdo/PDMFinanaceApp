package br.com.pdmfinance2.model;

public class Transaction {
    private String Description;
    private String Tipo;
    private Float Value;

    public Transaction(String description, String tipo, Float value) {
        Description = description;
        Tipo = tipo;
        Value = value;
    }

    public String getDescription() {
        return Description;
    }

    public String getTipo() {
        return Tipo;
    }

    public Float getValue() {
        return Value;
    }
}
