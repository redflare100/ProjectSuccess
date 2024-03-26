package com.project-success.teacher;

@Setter
@Getter
public class Assignment {
    public int assignmentId;
    private String name;
    private LocalDateTime dueDate;
    private List<String> requirements;

}