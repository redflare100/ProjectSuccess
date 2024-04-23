package com.student.StudentPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList; 
import com.student.StudentPortal.entity.Assignment;
import com.student.StudentPortal.service.GradeListService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GradeListController {
    @Autowired private GradeListService gradeListService;

    @GetMapping("/api/gradeList")
    public ArrayList<Assignment> GiveGradeList() {
        return gradeListService.GetGradeList(); 
    }
}
