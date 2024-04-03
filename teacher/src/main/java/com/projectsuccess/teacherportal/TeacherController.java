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

}
