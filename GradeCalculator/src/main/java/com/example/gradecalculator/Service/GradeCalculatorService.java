package com.example.gradecalculator.Service;

import com.example.gradecalculator.Imports.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GradeCalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(GradeCalculatorService.class);

    private final String STUDENT_PORTAL_URL = "http://localhost:8080"; // URL of StudentPortal
    private final String TEACHER_PORTAL_URL = "http://localhost:8081"; // URL of TeacherPortal

    private RestTemplate restTemplate = new RestTemplate();

    public double calculateGrade() {
        // Retrieve the GradeList from the StudentPortal on port 8080
        ResponseEntity<List<Assignment>> responseEntity = restTemplate.exchange(
                STUDENT_PORTAL_URL + "/api/gradeList",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Assignment>>() {});

        List<Assignment> studentGradeList = responseEntity.getBody();
        if (studentGradeList == null) { //Checks if the studentGradeList exists
            logger.error("Failed to retrieve student grade list.");
            return 0.0;
        }

        double totalWeightedGrade = 0.0;
        double totalWeight = 0.0;

        for (Assignment assignment : studentGradeList) {
            // Retrieve the weight of the assignment from the TeacherPortal on port 8081
            ResponseEntity<Double> weightResponseEntity = restTemplate.exchange(
                    TEACHER_PORTAL_URL + "/api/{courseName}/{assignmentName}/weight",
                    HttpMethod.GET,
                    null,
                    Double.class,
                    "CHEM101", assignment.getAssignmentName());

            Double assignmentWeight = weightResponseEntity.getBody();
            if (assignmentWeight == null) { //Error Checking for Weights, make sure students aren't adding useless grades
                logger.error("Failed to retrieve weight for assignment: {}", assignment.getAssignmentName());
                continue; // Skip to the next assignment if weight is not available
            }

            // Calculate the weighted grade for the assignment
            double weightedGrade = assignment.getGrade() * assignmentWeight;
            totalWeightedGrade += weightedGrade;
            totalWeight += assignmentWeight;

            logger.info("Assignment Name: {}, Grade: {}, Weight: {}", assignment.getAssignmentName(), assignment.getGrade(), assignmentWeight);
        }

        // Calculate the final weighted grade
        if (totalWeight > 0) {
            return totalWeightedGrade / totalWeight;
        } else {
            return 0.0; // Return 0 if no assignments found or total weight is 0
        }
    }
}
