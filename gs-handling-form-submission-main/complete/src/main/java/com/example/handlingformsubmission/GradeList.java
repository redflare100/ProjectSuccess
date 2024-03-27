package com.example.handlingformsubmission;

import java.util.ArrayList;
import java.util.List;

public class GradeList {
	//A list of a students grades
    private List<Grade> grades;

	//Constructor for the list
    public GradeList() {
        this.grades = new ArrayList<>();
    }

	//Adds a grade to the list
    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

	//Need to add to documentation but is implied
	//Gets the list of a students grades to be calculated
    public List<Grade> getGrades() {
        return grades;
    }
}