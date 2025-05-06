package com.kaveesha.fdcalculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class FDService {
    public BigDecimal calculateMaturityAmount(BigDecimal principal, double rate, int months, boolean renewable) {
        double r = rate / 100.00;

        if(renewable)
            // Compounding once at the end of the term
            return principal.multiply(BigDecimal.valueOf(1 + r));
        else {
            // Simple interest just once
            return principal.add(principal.multiply(BigDecimal.valueOf(r)));
        }
    }
    public BigDecimal calculateFDGrowthOverTime(BigDecimal principal, double rate, int fdDurationMonths, int targetMonths, boolean reinvestWithInterest) {
        BigDecimal currentAmount = principal;
        int cycles = targetMonths / fdDurationMonths;
        double r = rate / 100.0;
    
        for (int i = 0; i < cycles; i++) {
            if (reinvestWithInterest) {
                currentAmount = currentAmount.multiply(BigDecimal.valueOf(1 + r));
            } else {
                currentAmount = currentAmount.add(principal.multiply(BigDecimal.valueOf(r)));
            }
        }
    
        return currentAmount;
    }
    
}
