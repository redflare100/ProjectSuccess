package com.example.gradecalculator.Model;

import com.example.gradecalculator.Service.GradeCalculatorService;
import com.example.gradecalculator.View.GradeView;
import org.springframework.stereotype.Component;

@Component
public class GradeCalculatorModel {

    private final GradeCalculatorService gradeCalculatorService;
    private final GradeView gradeView;

    public GradeCalculatorModel(GradeCalculatorService gradeCalculatorService, GradeView gradeView) {
        this.gradeCalculatorService = gradeCalculatorService;
        this.gradeView = gradeView;
    }

    public String calculateGrade() {
        double totalWeightedGrade = gradeCalculatorService.calculateGrade();
        return gradeView.displayGrade(totalWeightedGrade);
    }
}