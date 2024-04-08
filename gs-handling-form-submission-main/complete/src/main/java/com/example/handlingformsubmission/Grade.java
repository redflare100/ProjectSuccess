package com.example.handlingformsubmission;

public class Grade {

	private Tag tag;
	private double rawGrade;

	//Grade constructor to gather needed info in one place for calculations
	Grade(String tag, double rawGrade, double weight){
		this.tag.setName(tag);
		this.tag.setWeight(weight);
		this.rawGrade = rawGrade;
	}

	// goes into Tag.java and returns the needed name of the tag
	public String getTagName() {
		return tag.getName();
	}

	// the raw grade given to us by the student
	public double getRawGrade() {
		return rawGrade;
	}

	// goes into tag to get that assignment types weight to be used in calculations in GradeCalculator
	public double getTagWeight(){
		return tag.getWeight();
	}

}
