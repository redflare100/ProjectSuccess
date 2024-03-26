package com.projectsuccess.teacherportal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {

    @GetMapping("/assignment")
        public String getAssignmentDetails(@RequestParam int assignmentId) {
        return "" + assignmentId;
    }

}
