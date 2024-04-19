package com.student.StudentPortal.model;

import com.student.StudentPortal.entity.Assignment;
import com.student.StudentPortal.repository.GradeListRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.student.StudentPortal.service.GradeListServiceImple;

public class GradeList {

    @Autowired
    GradeListRepository gradeListRepository;
    String studentName; 
    String courseName; 
    int courseNumber;
    //@Autowired GradeListServiceImple gradeListService; 
    //ArrayList<Assignment> gradeList = gradeListService.GetGradeList(); 

    public GradeList(String studName, String courName, int courNum, GradeListRepository gradeListRepo) {
        this.gradeListRepository = gradeListRepo; 
        this.studentName = studName; 
        this.courseName = courName; 
        this.courseNumber = courNum;
    }

    // Add a grade to the list of grades
    public void addGrade(String name, double grade) {
        Assignment newAssignment = new Assignment(name, grade); 
        gradeListRepository.save(newAssignment);
        //GradeList.add(newAssignment); 
        System.out.println("Assignment: " + name + " Grade: " + grade);  
    }

    // Get the grade of the assignment
    public double getGrade(String assignmentName) {
        //double grade; 
        // for(int i = 0; i < gradeList.size(); i++) {
        //     if(gradeList.get(i).getAssignmentName() == assignmentName) {
        //         grade = gradeList.get(i).getGrade(); 
        //     }
        // }
        // return grade; 
        return gradeListRepository.findByAssignmentName(assignmentName).getGrade(); 
    }

    // Edit the name of the assignment
    public void editGrade(String assignmentName, double grade) {
        // for(int i = 0; i < gradeList.size(); i++) {
        //     if(gradeList.get(i).getAssignmentName() == assignmentName) {
        //         gradeList.get(i).setGrade(grade);
        //     }
        // }
        Assignment work = gradeListRepository.findByAssignmentName(assignmentName); 
        work.setGrade(grade);
        gradeListRepository.save(work); 
    }

    // Edit the assignment name
    public void editAssignmentName(String assignmentName, String newAssignmentName) {
        // for(int i = 0; i < gradeList.size(); i++) {
        //     if(gradeList.get(i).getAssignmentName() == assignmentName) {
        //         gradeList.get(i).setAssignmentName(grade);
        //     }
        // }
        Assignment work = gradeListRepository.findByAssignmentName(assignmentName); 
        work.setAssignmentName(newAssignmentName);
        gradeListRepository.save(work); 
    }

    // Deletes the assignment 
    public void deleteGrade(String assignmentName) {
        // for(int i = 0; i < gradeList.size(); i++) {
        //     if(gradeList.get(i).getAssignmentName() == assignmentName) {
        //         gradeList.remove(i); 
        //     }
        // }
        gradeListRepository.deleteById(assignmentName);
    }

    public ArrayList<Assignment> retrieveGradeList() {
        return (ArrayList<Assignment>) gradeListRepository.findAll(); 
    }

    public void addDueDate(String assignmentName, String dueDate) {
        // for(int i = 0; i < gradeList.size(); i++) {
        //     if(gradeList.get(i).getAssignmentName() == assignmentName) {
        //         gradeList.get(i).setDueDate(dueDate);
        //     }
        // }
        Assignment work = gradeListRepository.findByAssignmentName(assignmentName); 
        work.setDueDate(dueDate);
        gradeListRepository.save(work); 
    }
}
