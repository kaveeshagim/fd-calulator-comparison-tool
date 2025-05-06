package com.kaveesha.fdcalculator.model;

import java.math.BigDecimal;

public class FDComparisonResult {
    private BigDecimal principal;
    private int duration;
    private double rate;
    private BigDecimal finalAmount;

    public FDComparisonResult(BigDecimal principal, int duration, double rate, BigDecimal finalAmount) {
        this.principal = principal;
        this.duration = duration;
        this.rate = rate;
        this.finalAmount = finalAmount;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public int getDuration() {
        return duration;
    }

    public double getRate() {
        return rate;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }
}
