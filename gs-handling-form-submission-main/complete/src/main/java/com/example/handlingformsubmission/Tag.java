package com.example.handlingformsubmission;

public class Tag {

	//the name of the tag AKA the type of assignment this is
	private String name;
	//the weight of that assignment.
	private double weight;

	//Getter method for name
	public String getName() {
		return name;
	}

	//getter method for weight
	public double getWeight(){
		return weight;
	}

	//Need to add these to documentation since i forgot i changed them to private
	//setter method for the name, used in Grade.java
	public void setName(String name) {
		this.name = name;
	}

	//setter method for weight, used in Grade.java
	public void setWeight(double weight){
		this.weight = weight;
	}
}
