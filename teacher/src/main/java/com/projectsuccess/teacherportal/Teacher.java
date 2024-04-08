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


    public static void main(String[] args) {

        // hard coded data
        Teacher stemTeacher = new Teacher(
                0,
                "Walter",
                "White",
                new ArrayList<>(Arrays.asList(
                    Course.chemistry101,
                    Course.physics212
                ))
        );

        Teacher historyTeacher = new Teacher(
                1,
                "Simon",
                "Bolivar",
                new ArrayList<>(Arrays.asList(
                    Course.history112
                ))
        );

    }

}