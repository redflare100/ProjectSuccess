package com.project-success.teacher;

@Setter
@Getter
public class Course {
    public int teacherId;
    private String prefix;
    private int number;
    private int section;
    private List<Assignment> assignments;

}