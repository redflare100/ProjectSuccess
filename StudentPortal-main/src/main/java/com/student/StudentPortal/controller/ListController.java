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
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ListController {

    @Autowired GradeListServiceImple gradeListService;
    GradeListRepository gradeListRepository; 
    GradeList gradeList = new GradeList("Samantha", "Chemistry", 101, gradeListRepository); 

    @PostMapping("/save")
    public ModelAndView AddGrade(@RequestParam("assignmentName") String assignmentName, @RequestParam("assignmentGrade") double assignmentGrade) {
        //gradeList.addGrade(assignmentName, assignmentGrade); //Doesn't work because repository is null
        System.out.println("Assignment: " + assignmentName + " Grade: " + assignmentGrade); 
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.setViewName("index"); 
        return modelAndView; 
    }
    public ArrayList<Assignment> GetInformation() {
        return gradeListService.GetGradeList(); 
    }

    @PostMapping("/detailsrequest")
    public String getdetails(@ModelAttribute("assignmentname") String name) {
        assignmentDetails(name); 
        return "redirect:/duedate";
    }
    

    @GetMapping("/api/assignmentdetails")
    public String assignmentDetails(String assignmentName) {
        String uri = "http://localhost:8081/api/CHEM101/homework1/dueDate"; 
        RestTemplate restTemplate = new RestTemplate(); 
        String result = restTemplate.getForObject(uri, String.class); 
        System.out.println("Homework 1, Due Date: " + result); 
        //gradeList.addDueDate(assignmentName, result);
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
