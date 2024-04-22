package com.student.StudentPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList; 
import com.student.StudentPortal.entity.Assignment;
import com.student.StudentPortal.service.GradeListService;

@Controller
public class GradeListController {
    private GradeListService gradeListService;

    public ArrayList<Assignment> GiveGradeList() {
        return gradeListService.GetGradeList(); 
    }
}
