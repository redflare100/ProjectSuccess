package com.projectsuccess.teacherportal;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    Teacher teacher = Teacher.teacher;

    // constant variables for page names
    private final String TEACHER_PORTAL = "teacherPortal";
    private final String ASSIGNMENT_PAGE = "assignmentDetails";
    private final String ASSIGNMENT_NOT_FOUND = "assignmentNotFound";
    private final String COURSE_PAGE = "courseDetails";
    private final String COURSE_NOT_FOUND = "courseNotFound";

    private final String GRADE_CALCULATOR_URI = "http://localhost:8082";

    public Course retrieveCourse(String courseName) {
        Course course = null;
        for (Course c : Course.courseList) {
            if (courseName.equals(c.getTitle())) {
                course = c;
                break;
            }
        }

        return course;
    }

    public Assignment retrieveAssignment(String courseName, String assignmentName) {
        Course course = retrieveCourse(courseName);
        if (course == null) {
            return null;
        }

        return course.findAssignment(assignmentName);
    }

    public String retrieveAssignmentDueDate(String courseName, String assignmentName) {
        Assignment assignment = retrieveAssignment(courseName, assignmentName);
        LocalDateTime dueDate = (assignment == null)
                ? LocalDateTime.now().plusWeeks(2)  // current time plus two weeks
                : assignment.getDueDate();          // assignment due date

        return dueDate.toString();
    }

    public double retrieveAssignmentWeight(String courseName, String assignmentName) {
        Assignment assignment = retrieveAssignment(courseName, assignmentName);
        double assignmentWeight = (assignment == null)
                ? Math.random() * 0.5       // random number, range: [0.0, 0.5]
                : assignment.getWeight();   // assignment weight

        // round to 3 decimal places
        return Math.round(assignmentWeight*1000.0)/1000.0;
    }


    public double retrieveCourseAverageGrade(String courseName) {
        try {
            // TODO: configure the API endpoint inputs
            // example endpoint: "http://localhost:8082/average?course=CHEM101"
            String uri = String.format("%s/average?course=%s", GRADE_CALCULATOR_URI, courseName);

            // TODO: call the API endpoint and retrieve the data
            RestTemplate restTemplate = new RestTemplate();
            Object result = restTemplate.getForObject(uri, Object.class);

            // TODO: parse the data and perform calculations if necessary
            // ...

            return 0.78;    // dummy value to replace later when API endpoint is implemented
        } catch (Exception e) {
            System.out.println("Grade Calculator API Endpoint 'assignmentAverages' not implemented");
            return Math.random();
        }
    }

    public double retrieveAssignmentAverageGrade(String courseName, String assignmentName) {
        try {
            // TODO: configure the API endpoint inputs
            // example endpoint: "http://localhost:8082/average?course=CHEM101&?assignment=Homework%201"
            String uri = String.format("%s/average?course=%s&assignment=%s", GRADE_CALCULATOR_URI, courseName, assignmentName);

            // TODO: call the API endpoint and retrieve the data
            RestTemplate restTemplate = new RestTemplate();
            Object result = restTemplate.getForObject(uri, Object.class);

            // TODO: parse the data and perform calculations if necessary
            // ...

            return 0.78;    // dummy value to replace later when API endpoint is implemented
        } catch (Exception e) {
            System.out.println("Grade Calculator API Endpoint 'assignmentAverages' not implemented");
            return Math.random();
        }
    }


    public String retrieveTeacherPortal(Model model) {
        List<Double> courseAverageGrades = new ArrayList<>();
        for (Course c : teacher.getCourses()) {
            double courseAverage = retrieveCourseAverageGrade(c.getTitle());
            courseAverageGrades.add(courseAverage);
        }

        model.addAttribute("id", teacher.getTeacherId());
        model.addAttribute("name", teacher.getFullName());
        model.addAttribute("courses", teacher.getCourses());
        model.addAttribute("courseAverages", courseAverageGrades);

        return TEACHER_PORTAL;
    }

    /**
     *
     *  if course is invalid,
     *      return the missing course page
     *  if the course is valid,
     *      add the necessary attributes to the model and
     *      return the course page
     *
     * @param courseName name of the course to be found
     * @param model model used for the display
     * @return page to be displayed
     *
     */
    public String retrieveCourseDetails(String courseName, Model model) {
        Course course = retrieveCourse(courseName);
        if (course == null) {
            return COURSE_NOT_FOUND;
        }

        List<Double> assignmentAverageGrades = new ArrayList<>();
        for (Assignment a : course.getAssignments()) {
            double assignmentAverage = retrieveAssignmentAverageGrade(course.getTitle(), a.getName());
            assignmentAverageGrades.add(assignmentAverage);
        }

        double courseAverageGrade = retrieveCourseAverageGrade(courseName);

        model.addAttribute("id", course.getCourseId());
        model.addAttribute("courseTitle", course.getTitle());
        model.addAttribute("section", course.getSection());
        model.addAttribute("assignments", course.getAssignments());
        model.addAttribute("assignmentAverages", assignmentAverageGrades);
        model.addAttribute("courseAverage", courseAverageGrade);

        return COURSE_PAGE;
    }

    /**
     *
     *  if course is invalid,
     *      return the missing course page
     *  if assignment is invalid,
     *      return the missing assignment page
     *  if both course and assignment are valid,
     *      add the necessary attributes to the model and
     *      return the correct page
     *
     * @param courseName name of the course to be found
     * @param assignmentName name of the assignment to be found
     * @param model model used for the display
     * @return page to be displayed
     *
     */
    public String retrieveAssignmentDetails(String courseName, String assignmentName, Model model) {
        Course course = retrieveCourse(courseName);
        if (course == null) {
            return COURSE_NOT_FOUND;
        }

        Assignment assignment = course.findAssignment(assignmentName);
        if (assignment == null) {
            return ASSIGNMENT_NOT_FOUND;
        }

        double assignmentAverageGrade = retrieveAssignmentAverageGrade(courseName, assignmentName);

        model.addAttribute("name", assignment.getName());
        model.addAttribute("id", assignment.getAssignmentId());
        model.addAttribute("dueDate", assignment.getDueDate());
        model.addAttribute("requirements", assignment.getRequirements());
        model.addAttribute("assignmentAverage", assignmentAverageGrade);

        return ASSIGNMENT_PAGE;
    }
}