package com.kaveesha.fdcalculator.model;

import java.math.BigDecimal;

public class FDForm {
    private BigDecimal amount;
    private double interestRate;
    private int fdDurationMonths;
    private int targetMonths;
    private boolean reinvestWithInterest;

    //Getters and Setters
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getFdDurationMonths() {
        return fdDurationMonths;
    }

    public void setFdDurationMonths(int fdDurationMonths) {
        this.fdDurationMonths = fdDurationMonths;
    }

    public int getTargetMonths() {
        return targetMonths;
    }

    public void setTargetMonths(int targetMonths) {
        this.targetMonths = targetMonths;
    }

    public boolean isReinvestWithInterest() {
        return reinvestWithInterest;
    }

    public void setReinvestWithInterest(boolean reinvestWithInterest) {
        this.reinvestWithInterest = reinvestWithInterest;
    }
}
