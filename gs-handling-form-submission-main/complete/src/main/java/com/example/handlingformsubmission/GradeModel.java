package com.example.handlingformsubmission;

import java.util.Map;

public class GradeModel {
    private GradeCalculator gradeCalculator;
    private double overallWeightedGrade;
    private GradeList gradeList;

    public GradeModel(GradeCalculator gradeCalculator, GradeList gradeList) {
        this.gradeCalculator = gradeCalculator;
        this.gradeList = gradeList;
    }

    public Map<String, Double> calculateGrade() {
        Map<String, Double> weightedGrades = gradeCalculator.calculateWeightedGrades(gradeList);
        // Calculate overall weighted grade
        overallWeightedGrade = calculateOverallWeightedGrade(weightedGrades);
        return weightedGrades;
    }

    private double calculateOverallWeightedGrade(Map<String, Double> weightedGrades) {
        double totalWeightedGrade = 0.0;
        double totalWeight = 0.0;

        for (double grade : weightedGrades.values()) {
            totalWeightedGrade += grade;
        }

        for (Grade grade : gradeList.getGrades()) {
            totalWeight += grade.getTagWeight();
        }

        // Calculate the overall weighted grade
        if (totalWeight > 0) {
            return totalWeightedGrade / totalWeight;
        } else {
            return 0.0; // Handle division by zero or empty grade list
        }
    }

    public double getOverallWeightedGrade() {
        return overallWeightedGrade;
    }
}
