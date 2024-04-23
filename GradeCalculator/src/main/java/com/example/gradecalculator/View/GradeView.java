package com.example.gradecalculator.View;

import org.springframework.stereotype.Component;

@Component
public class GradeView {

    public String displayGrade(double totalWeightedGrade) {
        // Round the total weighted grade to the nearest whole number
        long roundedGrade = Math.round(totalWeightedGrade);

        // Determine the letter grade
        String letterGrade;
        if (totalWeightedGrade >= 90) {
            letterGrade = "A";
        } else if (totalWeightedGrade >= 80) {
            letterGrade = "B";
        } else if (totalWeightedGrade >= 70) {
            letterGrade = "C";
        } else if (totalWeightedGrade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        // Define the HTML content with the totalWeightedGrade and letter grade inserted
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Grade Calculator Result</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #add8e6;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 800px;\n" +
                "            margin: 20px auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: #e6e6fa;\n" +
                "            border-radius: 5px;\n" +
                "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        h1 {\n" +
                "            text-align: center;\n" +
                "            color: #333;\n" +
                "        }\n" +
                "        .grade-info {\n" +
                "            margin-top: 20px;\n" +
                "            text-align: center;\n" +
                "            font-size: 24px;\n" +
                "            color: #007bff;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h1>Grade Calculator Result</h1>\n" +
                "        <div class=\"grade-info\">\n" +
                "            <h1>Total Weighted Grade: " + roundedGrade + "%</h1>\n" +
                "            <h2>Letter Grade: " + letterGrade + "</h2>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";

        return htmlContent;
    }
}
