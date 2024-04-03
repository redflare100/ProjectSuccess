package com.projectsuccess.teacherportal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TeacherController {

    @GetMapping("/assignment")
    public String assignmentDetails(
            @RequestParam(name = "assignmentId", defaultValue = "0") int assignmentId,
            Model model
    ) {
        Assignment assignment = TeacherService.retrieveAssignmentDetails(assignmentId);

        model.addAttribute("assignmentId", assignmentId);
        return "assignmentDetails";
    }

}
