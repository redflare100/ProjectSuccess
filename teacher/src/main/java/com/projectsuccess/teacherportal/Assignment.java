package com.projectsuccess.teacherportal;

import lombok.Getter;
import lombok.Setter;
import org.springframework.expression.spel.ast.Assign;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            new Assignment(
                    0,
                    "Homework 1",
                    LocalDateTime.now().plusWeeks(1),
                    new ArrayList<>(Arrays.asList(
                            "Submit within the next week",
                            "Submit as a PDF"
                    ))
            ),
            new Assignment(
                    1,
                    "Homework 2",
                    LocalDateTime.now().plusWeeks(2),
                    new ArrayList<>(Arrays.asList(
                            "Submit within the next two weeks",
                            "Submit as a PDF"
                    ))
            )
    ));

    public static List<Assignment> physics212Assignments = new ArrayList<>(Arrays.asList(
            // empty for now
    ));

    public static List<Assignment> history112Assignments = new ArrayList<>(Arrays.asList(
            new Assignment(
                    2,
                    "Project 1",
                    LocalDateTime.now().plusWeeks(2).plusDays(3),
                    new ArrayList<>(Arrays.asList(
                            "Submit within the next two and a half weeks",
                            "Submit as a Powerpoint",
                            "Work with up to 3 group mates"
                    ))
            )

    ));

    // combine all assignment lists into one using Streams
    public static List<Assignment> allAssignments = Stream.of(
            chemistry101Assignments,
            physics212Assignments,
            history112Assignments
    )
    .flatMap(Collection::stream)
    .collect(Collectors.toList());
}