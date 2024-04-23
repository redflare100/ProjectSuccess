package com.projectsuccess.teacherportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/api/{courseName}")
    public Course getCourse(@PathVariable String courseName) {
        return teacherService.retrieveCourse(courseName);
    }

    @GetMapping("/api/{courseName}/{assignmentName}")
    public Assignment getAssignment(@PathVariable String courseName, @PathVariable String assignmentName) {
        return teacherService.retrieveAssignment(courseName, assignmentName);
    }

    @GetMapping("/api/{courseName}/{assignmentName}/dueDate")
    public String getAssignmentDueDate(@PathVariable String courseName, @PathVariable String assignmentName) {
        return teacherService.retrieveAssignmentDueDate(courseName, assignmentName);
    }

    @GetMapping("/api/{courseName}/{assignmentName}/weight")
    public double getAssignmentWeight(@PathVariable String courseName, @PathVariable String assignmentName) {
        return teacherService.retrieveAssignmentWeight(courseName, assignmentName);
    }
}
