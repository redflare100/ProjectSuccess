package com.student.StudentPortal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

import com.student.StudentPortal.service.GradeListService;
import com.student.StudentPortal.entity.Assignment;
import com.student.StudentPortal.model.GradeList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.student.StudentPortal.view.DisplayListView;


@Controller
public class ListController {

    @Autowired private GradeListService gradeListService; 
    GradeList gradeList; 


    public ListController() {}

    public void AddGrade(String name, double grade) {
        gradeList.addGrade(name, grade);
    }
    public ArrayList<Assignment> GetInformation() {
        return gradeListService.GetGradeList(); 
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "index"; 
    }
    
}
