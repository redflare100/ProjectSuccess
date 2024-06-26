package com.projectsuccess.teacherportal;


import org.springframework.stereotype.Service;

@Service
public class TeacherService {


    public static Assignment retrieveAssignmentDetails(int assignmentId) {
        Assignment assignment = null;

        for (Assignment a : Assignment.allAssignments) {
            if (a.assignmentId == assignmentId) {
                assignment = a;
                break;
            }
        }
        
        return assignment;
    }

    public static Course retrieveCourseDetails(int courseId) {
        Course course = null;
        for (Course c : Course.courseList) {
            if (c.courseId == courseId) {
                course = c;
                break;
            }
        }

        return course;
    }

}
