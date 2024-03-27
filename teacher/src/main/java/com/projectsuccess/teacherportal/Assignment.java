package com.projectsuccess.teacherportal;

import lombok.Getter;
import lombok.Setter;
import org.springframework.expression.spel.ast.Assign;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class Assignment {
    public int assignmentId;
    private String name;
    private LocalDateTime dueDate;
    private List<String> requirements;

    public Assignment() { }

    public Assignment(int assignmentId, String name, LocalDateTime dueDate, List<String> requirements) {
        this.assignmentId = assignmentId;
        this.name = name;
        this.dueDate = dueDate;
        this.requirements = requirements;
    }

    // hard coded assignment lists
    public static List<Assignment> chemistry101Assignments = new ArrayList<>(Arrays.asList(
        // empty for now
    ));

    public static List<Assignment> physics212Assignments = new ArrayList<>(Arrays.asList(
            // empty for now
    ));

    public static List<Assignment> history112Assignments = new ArrayList<>(Arrays.asList(
            // empty for now
    ));
}