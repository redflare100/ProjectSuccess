package com.example.handlingformsubmission;

import java.util.Map;
import java.util.HashMap;

public class GradeCalculator {

    public Map<String, Double> calculateWeightedGrades(GradeList gradeList) {
        Map<String, Double> weightedGrades = new HashMap<>();

        for (Grade grade : gradeList.getGrades()) {
            String tagName = grade.getTagName();
            double rawGrade = grade.getRawGrade();
            double tagWeight = grade.getTagWeight();

            // If the tag already exists in the map, add the weighted grade to it
            if (weightedGrades.containsKey(tagName)) {
                double currentWeightedGrade = weightedGrades.get(tagName);
                weightedGrades.put(tagName, currentWeightedGrade + (rawGrade * tagWeight));
            } else {
                // If the tag doesn't exist in the map, add it with the initial weighted grade
                weightedGrades.put(tagName, rawGrade * tagWeight);
            }
        }

        return weightedGrades;
    }
}

