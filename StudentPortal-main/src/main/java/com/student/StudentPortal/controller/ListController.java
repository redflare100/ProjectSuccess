package com.student.StudentPortal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

import com.student.StudentPortal.service.GradeListService;
import com.student.StudentPortal.service.GradeListServiceImple;
import com.student.StudentPortal.entity.Assignment;
import com.student.StudentPortal.model.GradeList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import com.student.StudentPortal.repository.GradeListRepository;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class ListController {

    @Autowired private GradeListServiceImple gradeListService;
    GradeList gradeList = new GradeList("Samantha", "Chemistry", 101); 

    @PostMapping("/save")
    public String AddGrade(@ModelAttribute("name") String name, @ModelAttribute("grade") Double grade) {
        gradeList.addGrade(name, grade);
        //System.out.println("Assignment: " + name + " Grade: " + grade); 
        return "redirect:/index"; 
    }
    public ArrayList<Assignment> GetInformation() {
        return gradeListService.GetGradeList(); 
    }

    @PostMapping("detailsrequest")
    public String getdetails(@ModelAttribute("assignmentname") String name) {
        assignmentDetails(name); 
        return "redirect:/duedate";
    }
    

    @GetMapping("/api/assignmentdetails")
    public String assignmentDetails(String assignmentName) {
        String uri = "http://localhost:8081/api/CHEM101/"+assignmentName+"dueDate"; 
        RestTemplate restTemplate = new RestTemplate(); 
        String result = restTemplate.getForObject(uri, String.class); 
        gradeList.addDueDate(assignmentName, result);
        return result; 
    }

    @PostMapping("http://localhost:8082/api/gradecalculator")
    public String gradeCalculator(String assignmentName) {
        String uri = "http://localhost:8082/api/gradecalculator"; 
        RestTemplate restTemplate = new RestTemplate(); 
        String result = restTemplate.getForObject(uri, String.class); 
        return result; 
    }

}
