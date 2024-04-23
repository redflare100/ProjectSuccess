package com.example.gradecalculator.Controller;

import com.example.gradecalculator.Model.GradeCalculatorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class GradeCalculatorController {

    @Autowired
    private GradeCalculatorModel gradeCalculatorModel;

    @PostMapping("/gradeCalculator")
    @ResponseBody
    public String calculateGrade() {
        return gradeCalculatorModel.calculateGrade();
    }
}