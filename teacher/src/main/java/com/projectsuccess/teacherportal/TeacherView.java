package com.projectsuccess.teacherportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class TeacherView {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public String teacherPortal(Model model) {
        return teacherService.retrieveTeacherPortal(model);
    }

    @GetMapping("/{courseName}")
    public String courseDetails(@PathVariable String courseName, Model model) {
        return teacherService.retrieveCourseDetails(courseName, model);
    }

    @GetMapping("/{courseName}/{assignmentName}")
    public String assignmentDetails(@PathVariable String courseName, @PathVariable String assignmentName, Model model) {
        return teacherService.retrieveAssignmentDetails(courseName, assignmentName, model);
    }


}
