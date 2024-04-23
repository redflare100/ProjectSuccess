package com.example.handlingformsubmission;

import java.util.Map;

public class GradeView {
    public static void displayGradeResult(double overallWeightedGrade, Map<String, Double> weightedGrades) {
        // Display overall weighted grade
        System.out.println("Overall Weighted Grade: " + overallWeightedGrade);

        // Display each tag's weighted grade
        System.out.println("Weighted Grades:");
        for (Map.Entry<String, Double> entry : weightedGrades.entrySet()) {
            System.out.println("Tag: " + entry.getKey() + ", Weighted Grade: " + entry.getValue());
        }
    }
}

