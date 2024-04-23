package com.student.StudentPortal.service;

import com.student.StudentPortal.entity.Assignment;
import com.student.StudentPortal.repository.*;
import java.util.ArrayList; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

@Service
public class GradeListServiceImple implements GradeListService{

    ArrayList<Assignment> SamGradeList = new ArrayList<>(); 
    @Autowired private GradeListRepository gradeListRepository; 

    @Override
    public ArrayList<Assignment> GetGradeList() {
        Assignment assignment = new Assignment("Homework 1", 97); 
        SamGradeList.add(0, assignment); 
        assignment = new Assignment("Homework 2", 87); 
        SamGradeList.add(1, assignment); 
        assignment = new Assignment("Homework 3", 78); 
        SamGradeList.add(2, assignment); 
        assignment = new Assignment("Quiz 1", 92); 
        SamGradeList.add(3, assignment); 
        assignment = new Assignment("Quiz 2", 85); 
        SamGradeList.add(4, assignment); 
        assignment = new Assignment("Lab 1", 83); 
        SamGradeList.add(5, assignment); 
        assignment = new Assignment("Lab 2", 89); 
        SamGradeList.add(6, assignment); 
        assignment = new Assignment("Midterm", 78); 
        SamGradeList.add(7, assignment); 
        assignment = new Assignment("Final", 90); 
        SamGradeList.add(8, assignment); 
        
        return SamGradeList; 
        //return (ArrayList<Assignment>) gradeListRepository.findAll(); 
    }
}
