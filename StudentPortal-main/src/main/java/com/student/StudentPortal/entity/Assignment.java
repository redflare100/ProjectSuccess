package com.student.StudentPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
    }
    
