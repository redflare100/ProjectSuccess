package com.project-success.teacher;

@Setter
@Getter
public class Teacher {
    public int teacherId;
    private String firstName;
    private String lastName;
    private List<Course> courses;

}