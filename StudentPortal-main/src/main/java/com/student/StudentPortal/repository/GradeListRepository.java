package com.student.StudentPortal.repository;

import com.student.StudentPortal.entity.Assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface GradeListRepository extends CrudRepository<Assignment, String>{
    Assignment findByAssignmentName(String assignmentName);
}
