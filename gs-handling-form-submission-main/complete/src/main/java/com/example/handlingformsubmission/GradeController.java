package com.example.handlingformsubmission;

import java.util.Map;

public class GradeController {
    private GradeList gradeList;
    private GradeModel gradeModel;

    public GradeController(GradeList gradeList, GradeModel gradeModel) {
        this.gradeList = gradeList;
        this.gradeModel = gradeModel;
    }

    public void addGrade(Grade grade) {
        gradeList.addGrade(grade);
    }

    public void calculateGrade() {
        Map<String, Double> weightedGrades = gradeModel.calculateGrade();
        double overallWeightedGrade = gradeModel.getOverallWeightedGrade();

        // Pass data to the view
        GradeView.displayGradeResult(overallWeightedGrade, weightedGrades);
    }
}

