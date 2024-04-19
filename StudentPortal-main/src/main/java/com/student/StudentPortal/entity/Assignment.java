package com.student.StudentPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assignment {
    
        @Id
        String assignmentName; 
        double grade; 
        String dueDate; 
    
        public Assignment(String aName, double score) {
            assignmentName = aName; 
            grade = score; 
            dueDate = ""; 
        }   

        public static Assignment homework1 = new Assignment(
            "Homework 1", 
            97,
            ""
        ); 

        public static Assignment homework2 = new Assignment(
            "Homework 2", 
            87,
            ""
        ); 

        public static Assignment homework3 = new Assignment(
            "Homework 3", 
            89,
            ""
        ); 

        public static Assignment homework4 = new Assignment(
            "Homework 4", 
            45,
            ""
        ); 

        public static Assignment homework5 = new Assignment(
            "Homework 5", 
            96,
            ""
        ); 
    }
    
