package OOPJava.Exercise5;

public class PartTimeStudent extends Student {
    private String trainingLocation;

    public PartTimeStudent(String studentID, String fullName, String dateOfBirth, int admissionYear, double entranceExamScore, String trainingLocation) {
        super(studentID, fullName, dateOfBirth, admissionYear, entranceExamScore);
        this.trainingLocation = trainingLocation;
    }
    String  getTrainingLocation() { 
        return trainingLocation;
    }

  
}
