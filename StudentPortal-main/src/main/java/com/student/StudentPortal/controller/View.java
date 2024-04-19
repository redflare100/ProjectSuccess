package com.student.StudentPortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.student.StudentPortal.service.GradeListServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller 
public class View {

    @Autowired private GradeListServiceImple gradeListService; 

    @GetMapping("/homepage")
    public String viewHomePage(Model model) {
        //model.addAttribute("gradeList", gradeListService.GetGradeList()); 
        return "index"; 
    }

    @GetMapping("/addgrade")
    public String ViewAddGradePage(Model model) {        
        return "add"; 
    }

    @GetMapping("/assignmentdetails")
    public String RequestDetails(Model model) {
        return "details"; 
    }
    
    @GetMapping("/assignment/duedate")
    public String ViewDueDate(Model model) {
        return "duedate"; 
    }

}
