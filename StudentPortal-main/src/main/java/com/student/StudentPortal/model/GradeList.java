package com.student.StudentPortal.model;

import com.student.StudentPortal.entity.Assignment;
import com.student.StudentPortal.repository.GradeListRepository;
import java.util.ArrayList;

public class GradeList {

    GradeListRepository gradeListRepository;
    String studentName; 
    String courseName; 
    int courseNumber;

    public GradeList() {}

    public GradeList(String studName, String courName, int courNum) {
        this.studentName = studName; 
        this.courseName = courName; 
        this.courseNumber = courNum;
    }

    public GradeList(GradeListRepository gradeListRepo) {
        this.gradeListRepository = gradeListRepo; 
    }

    // Add a grade to the list of grades
    public void addGrade(String name, double grade) {
        Assignment newAssignment = new Assignment(name, grade); 
        //gradeListRepository.add(newAssignment); 
        gradeListRepository.save(newAssignment); 
    }

    // Get the grade of the assignment
    public double getGrade(String assignmentName) {
        return gradeListRepository.findByAssignmentName(assignmentName).getGrade(); 
    }

    // Edit the name of the assignment
    public void editGrade(String assignmentName, double grade) {
        Assignment work = gradeListRepository.findByAssignmentName(assignmentName); 
        work.setGrade(grade);
        gradeListRepository.save(work); 
    }

    // Edit the assignment name
    public void editAssignmentName(String assignmentName, String newAssignmentName) {
        Assignment work = gradeListRepository.findByAssignmentName(assignmentName); 
        work.setAssignmentName(newAssignmentName);
        gradeListRepository.save(work); 
    }

    // Deletes the assignment 
    public void deleteGrade(String assignmentName) {
        gradeListRepository.deleteById(assignmentName);
    }

    public ArrayList<Assignment> retrieveGradeList() {
        return (ArrayList<Assignment>) gradeListRepository.findAll(); 
    }

    public void addDueDate(String assignmentName, String dueDate) {
        Assignment work = gradeListRepository.findByAssignmentName(assignmentName); 
        work.setDueDate(dueDate);
        gradeListRepository.save(work); 
    }
}
