package com.kaveesha.fdcalculator.controller;

import com.kaveesha.fdcalculator.model.FDForm;
import com.kaveesha.fdcalculator.service.FDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
    public String calculate(@ModelAttribute FDForm fdForm, Model model) {
        BigDecimal result  = fdService.calculateFDGrowthOverTime(
            fdForm.getAmount(),
            fdForm.getInterestRate(),
            fdForm.getFdDurationMonths(),
            fdForm.getTargetMonths(),
            fdForm.isReinvestWithInterest()
        );
        model.addAttribute("result", result );
        model.addAttribute("fdForm", fdForm);
        return "index";
    }
}
