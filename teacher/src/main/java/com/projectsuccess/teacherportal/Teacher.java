package com.projectsuccess.teacherportal;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Teacher {
    public int teacherId;
    private String firstName;
    private String lastName;
    private List<Course> courses;

    public static void main(String[] args) {

        Teacher[] teachers = new Teacher[5];
        for (int i = 0; i < teachers.length; i++) {
            teachers[i] = new Teacher();
            teachers[i].setTeacherId(i);
        }

    }

}