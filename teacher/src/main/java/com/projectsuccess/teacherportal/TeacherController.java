package com.projectsuccess.teacherportal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TeacherController {

    @GetMapping("/assignment")
    public String assignmentDetails(
            @RequestParam(name = "assignmentId", defaultValue = "0", required = false) int assignmentId,
            Model model
    ) {
        Assignment assignment = TeacherService.retrieveAssignmentDetails(assignmentId);
        if (assignment == null) {
            return "missingAssignment";
        }

        model.addAttribute("name", assignment.getName());
        model.addAttribute("id", assignment.getAssignmentId());
        model.addAttribute("dueDate", assignment.getDueDate());
        model.addAttribute("requirements", assignment.getRequirements());

        return "assignmentDetails";
    }

    @GetMapping("/course")
    public String courseDetails(
            @RequestParam(name = "courseId", defaultValue = "0") int courseId,
            Model model
    ) {
        Course course = TeacherService.retrieveCourseDetails(courseId);
        if (course == null) {
            return "missingCourse";
        }

        String courseTitle = course.getPrefix() + course.getNumber();
        model.addAttribute("id", course.getCourseId());
        model.addAttribute("courseTitle", courseTitle);
        model.addAttribute("section", course.getSection());
        model.addAttribute("assignments", course.getAssignments());

        return "courseDetails";
    }

}
