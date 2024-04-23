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
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@RestController
public class ListController {

    GradeListServiceImple gradeListService;
    @Autowired GradeListRepository gradeListRepository; 
    //GradeList gradeList = new GradeList("Samantha", "Chemistry", 101, gradeListRepository); 
    //ArrayList<Assignment> gradeList = gradeListService.GetGradeList(); 

    @PostMapping("/save")
    public ModelAndView AddGrade(@RequestParam("assignmentName") String assignmentName, @RequestParam("assignmentGrade") double assignmentGrade) {
        //gradeList.addGrade(assignmentName, assignmentGrade); //Doesn't work because repository is null
        Assignment newAssignment = new Assignment(assignmentName, assignmentGrade); 
        //gradeList.add(newAssignment); 
        System.out.println("Assignment: " + assignmentName + " Grade: " + assignmentGrade); 
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.setViewName("index"); 
        return modelAndView; 
    }
    public ArrayList<Assignment> GetInformation() {
        return gradeListService.GetGradeList(); 
    }

    @PostMapping("/detailsrequest")
    public ModelAndView getdetails(@RequestParam("assignmentName") String assignmentName) {
        System.out.println("Assignment Name: " + assignmentName); 
        assignmentDetails(assignmentName); 
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.setViewName("duedate");
        return modelAndView; 
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

    @PostMapping("http://localhost:8082/gradeCalculator")
    public String gradeCalculator() {
        String uri = "http://localhost:8082/gradeCalculator"; 
        RestTemplate restTemplate = new RestTemplate(); 
        String result = restTemplate.postForObject(uri, null, String.class); 
        return result; 
    }

}
