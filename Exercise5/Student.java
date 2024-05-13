package OOPJava.Exercise5;

import java.util.ArrayList;

public class Student {
    private String studentID;
    private String fullName;
    private String dateOfBirth;
    private int admissionYear;
    private double entranceExamScore;
    private ArrayList<AcademicResult> academicResults;
    private int type;
   

    public Student(String studentID, String fullName, String dateOfBirth, int admissionYear, double entranceExamScore,int type) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.admissionYear = admissionYear;
        this.entranceExamScore = entranceExamScore;
        this.academicResults = new ArrayList<>();
        this.type = type;

      

    }
    public String getStudentID() {
        return studentID;
    }
    public String getDateOfBirth (){
        return dateOfBirth;
    }
    public int getAdmissionYear() {
        return admissionYear;
    }
    public double getEntranceExamScore() {
        return entranceExamScore;
    }
     public String getfullName() {
        return fullName;
    }


    public int getType() {
        return this.type;
    }


    public void addAcademicResult(AcademicResult result) {
        academicResults.add(result);
    }
    public void showAcademicResults() {
        System.out.println("Danh sách kết quả học tập của sinh viên " + fullName + ":");
        for (AcademicResult result : academicResults) {
            System.out.println("Học kỳ:  " + result.getSemesterName() + ", Điểm trung bình: " + result.getAverageGPA());
        }
    }



  
}
