import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GradeCalculatorService {

    private final String STUDENT_PORTAL_URL = "http://localhost:8080"; // URL of StudentPortal
    private final String TEACHER_PORTAL_URL = "http://localhost:8081"; // URL of TeacherPortal

    @Autowired
    private RestTemplate restTemplate;

    public double calculateGrade(AssignmentList studentAssignments) {
        // Retrieve the GradeList from the StudentPortal
        ArrayList<Assignment> studentGradeList = restTemplate.getForObject(STUDENT_PORTAL_URL + "/gradeList", ArrayList.class);

        // Retrieve the Course from the TeacherPortal
        Course course = restTemplate.getForObject(TEACHER_PORTAL_URL + "/course/{courseId}", Course.class, studentAssignments.getCourseId());

        // Get the AssignmentList for the course
        List<Assignment> teacherAssignments = course.getAssignments();

        double totalWeightedGrade = 0.0;
        double totalWeight = 0.0;

        // Iterate over the teacherAssignments to calculate the weighted grade
        for (Assignment teacherAssignment : teacherAssignments) {
            // Find the matching assignment in the studentGradeList
            Assignment studentAssignment = findMatchingAssignment(studentGradeList, teacherAssignment.getAssignmentName());

            if (studentAssignment != null) {
                // Get the weight for the assignment from the AssignmentList
                double weight = getWeightForAssignment(studentAssignments.getAssignments(), teacherAssignment.getAssignmentName());

                // Calculate the weighted grade
                totalWeightedGrade += studentAssignment.getGrade() * weight;
                totalWeight += weight;
            }
        }

        // Calculate the final weighted grade
        if (totalWeight > 0) {
            return totalWeightedGrade / totalWeight;
        } else {
            return 0.0; // Return 0 if no assignments found or total weight is 0
        }
    }

    // Helper method to find a matching assignment in the studentGradeList
    private Assignment findMatchingAssignment(ArrayList<Assignment> studentGradeList, String assignmentName) {
        for (Assignment assignment : studentGradeList) {
            if (assignment.getAssignmentName().equals(assignmentName)) {
                return assignment;
            }
        }
        return null;
    }

    // Helper method to get the weight for an assignment from the AssignmentList
    private double getWeightForAssignment(List<AssignmentInfo> assignmentList, String assignmentName) {
        for (AssignmentInfo assignmentInfo : assignmentList) {
            if (assignmentInfo.getAssignmentName().equals(assignmentName)) {
                return assignmentInfo.getWeight();
            }
        }
        return 0.0; // Return 0 if weight not found
    }
}
