package com.kaveesha.fdcalculator.controller;

import com.kaveesha.fdcalculator.model.FDComparisonResult;
import com.kaveesha.fdcalculator.model.FDForm;
import com.kaveesha.fdcalculator.service.FDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Comparator;

@Controller
public class FDController {
    @Autowired
    private FDService fdService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("fdForm", new FDForm());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute FDForm fdForm,
            @RequestParam(required = false, defaultValue = "calculator") String activeTab, Model model) {
        BigDecimal result = fdService.calculateFDGrowthOverTime(
                fdForm.getAmount(),
                fdForm.getInterestRate(),
                fdForm.getFdDurationMonths(),
                fdForm.getTargetMonths(),
                fdForm.isReinvestWithInterest());
        model.addAttribute("result", result);
        model.addAttribute("fdForm", fdForm);
        model.addAttribute("activeTab", activeTab);
        return "index";
    }

    @PostMapping("/compare")
    public String compareFds(
            @RequestParam int targetMonths,
            @RequestParam List<BigDecimal> principals,
            @RequestParam List<Integer> durations,
            @RequestParam List<Double> rates,
            @RequestParam(required = false, defaultValue = "comparison") String activeTab,
            Model model) {

        boolean reinvestWithInterest = true;

        List<FDComparisonResult> comparisonResults = fdService.compareMultipleOptions(
                targetMonths,
                principals,
                durations,
                rates,
                reinvestWithInterest);

        // Find max final amount to highlight
        BigDecimal max = comparisonResults.stream()
                .map(FDComparisonResult::getFinalAmount)
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);

        model.addAttribute("comparisonResults", comparisonResults);
        model.addAttribute("maxFinalAmount", max);
        model.addAttribute("fdForm", new FDForm());
        model.addAttribute("activeTab", activeTab); // ✅ pass tab status to frontend
        return "index";
    }

}
