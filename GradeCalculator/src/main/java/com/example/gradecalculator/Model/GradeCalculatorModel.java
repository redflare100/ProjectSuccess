import org.springframework.stereotype.Component;

@Component
public class GradeCalculatorModel {

    private final GradeCalculatorService gradeCalculatorService;

    public GradeCalculatorModel(GradeCalculatorService gradeCalculatorService) {
        this.gradeCalculatorService = gradeCalculatorService;
    }

    public double calculateGrade(AssignmentList studentAssignments) {
        return gradeCalculatorService.calculateGrade(studentAssignments);
    }
}
