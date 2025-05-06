package com.kaveesha.fdcalculator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kaveesha.fdcalculator.model.FDComparisonResult;

@Service
public class FDService {
    public BigDecimal calculateMaturityAmount(BigDecimal principal, double rate, int months, boolean renewable) {
        double r = rate / 100.00;

        if (renewable)
            // Compounding once at the end of the term
            return principal.multiply(BigDecimal.valueOf(1 + r));
        else {
            // Simple interest just once
            return principal.add(principal.multiply(BigDecimal.valueOf(r)));
        }
    }

    public BigDecimal calculateFDGrowthOverTime(BigDecimal principal, double rate, int fdDurationMonths,
            int targetMonths, boolean reinvestWithInterest) {
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

    public List<FDComparisonResult> compareMultipleOptions(
            int targetMonths,
            List<BigDecimal> principals,
            List<Integer> durations,
            List<Double> rates,
            boolean reinvestWithInterest) {
        List<FDComparisonResult> results = new ArrayList<>();

        for (int i = 0; i < principals.size(); i++) {
            BigDecimal finalAmount = calculateFDGrowthOverTime(
                    principals.get(i),
                    rates.get(i),
                    durations.get(i),
                    targetMonths,
                    reinvestWithInterest);

            results.add(new FDComparisonResult(
                    principals.get(i),
                    durations.get(i),
                    rates.get(i),
                    finalAmount));
        }

        return results;
    }

}
