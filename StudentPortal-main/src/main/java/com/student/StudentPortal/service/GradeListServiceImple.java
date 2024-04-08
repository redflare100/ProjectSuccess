package com.student.StudentPortal.service;

import com.student.StudentPortal.entity.Assignment;
import com.student.StudentPortal.repository.*;
import java.util.ArrayList; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

@Service
public class GradeListServiceImple implements GradeListService{

    @Autowired private GradeListRepository gradeListRepository; 

    @Override
    public ArrayList<Assignment> GetGradeList() {
        return (ArrayList<Assignment>) gradeListRepository.findAll(); 
    }
}
