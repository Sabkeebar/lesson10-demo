package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Money implements ValueObject {
    private String currencyCode; // USD, EUR, etc
    private Double amount;

    public Money() {
    }

    public Money(String currencyCode, Double amount) {
        this.currencyCode = currencyCode;
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
