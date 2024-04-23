package com.projectsuccess.teacherportal;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Teacher {
    public int teacherId;
    private String firstName;
    private String lastName;
    private List<Course> courses;

    public Teacher() {

    }

    public Teacher(int teacherId, String firstName, String lastName, List<Course> courses) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public String getFullName() {
        return this.getFirstName()+" "+this.getLastName();
    }

    public static Teacher teacher = new Teacher(
            0,
            "Walter",
            "White",
            new ArrayList<>(Arrays.asList(
                    Course.chemistry101,
                    Course.physics212,
                    Course.history112
            ))
    );

}