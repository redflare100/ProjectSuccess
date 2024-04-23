package com.projectsuccess.teacherportal;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class Course {
    public int courseId;
    private String prefix;
    private int number;
    private int section;
    private List<Assignment> assignments;

    public Course() { }

    public Course(int courseId, String prefix, int number, int section, List<Assignment> assignments) {
        this.courseId = courseId;
        this.prefix = prefix;
        this.number = number;
        this.section = section;
        this.assignments = assignments;
    }

    // hard coded course details
    public static Course chemistry101 = new Course(
            0,
            "CHEM",
            101,
            1,
            Assignment.chemistry101Assignments
    );

    public static Course physics212 = new Course(
            1,
            "PHYS",
            212,
            3,
            Assignment.physics212Assignments
    );

    public static Course history112 = new Course(
            2,
            "HIS",
            112,
            2,
            Assignment.history112Assignments
    );


    // combine all courses in to one list
    public static List<Course> courseList = new ArrayList<>(Arrays.asList(
            chemistry101,
            physics212,
            history112
    ));

}