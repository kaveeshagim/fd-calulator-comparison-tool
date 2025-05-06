package com.kaveesha.fdcalculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class FDService {
    public BigDecimal calculateMaturityAmount(BigDecimal principal, double rate, int months, boolean renewable) {
        int t = months / 12;
        double r = rate / 100.00;

        if(renewable)
            return principal.multiply(BigDecimal.valueOf(Math.pow(1 + r, t)));
        else {
            return principal.add(principal.multiply(BigDecimal.valueOf(r * t)));
        }
    }
}
