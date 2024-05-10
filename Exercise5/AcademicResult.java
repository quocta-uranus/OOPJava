package OOPJava.Exercise5;

public class AcademicResult {
    private String semesterName;
    private double averageGPA;

    public AcademicResult(String semesterName, double averageGPA) {
        this.semesterName = semesterName;
        this.averageGPA = averageGPA;
    }
    double getAverageGPA() {
        return averageGPA;
    }
    String getSemesterName() {
        return semesterName;
    }


}