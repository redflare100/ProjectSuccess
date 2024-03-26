package com.example.handlingformsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/assignment")
        public String getAssignmentDetails(@RequestParam int assignmentId) {
        return "" + assignmentId;
    }

}
