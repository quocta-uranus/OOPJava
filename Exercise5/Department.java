package OOPJava.Exercise5;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private ArrayList<Student> students;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public int getTotalRegularStudents() {
        int countRegularStudents = 0;
        for (Student student : students) {
            if (student instanceof Student && student.getType() == 1) {
                countRegularStudents++;
            }
        }
        return countRegularStudents;
    }
    public List<PartTimeStudent> getAffiliatedPartTimeStudents(String trainingLocation) {
        List<PartTimeStudent> affiliatedPartTimeStudents = new ArrayList<>();
        for (Student student : students) {
            if (student instanceof PartTimeStudent) {
                PartTimeStudent partTimeStudent = (PartTimeStudent) student;
                String trainingLocationLowerCase = trainingLocation.toLowerCase();

                if (partTimeStudent.getTrainingLocation().toLowerCase().equals(trainingLocationLowerCase)) {
                    affiliatedPartTimeStudents.add(partTimeStudent);
                }
            }
        }
        return affiliatedPartTimeStudents;
    }
    public void showStudentsInfo() {
        System.out.println("Thông tin và điểm của sinh viên trong khoa " + departmentName + ":");
        for (Student student : students) {
            System.out.println("ID: " + student.getStudentID());
            System.out.println("Họ và tên: " + student.getfullName());
            System.out.println("Ngày sinh: " + student.getDateOfBirth());
            System.out.println("Năm vào học: " + student.getAdmissionYear());
            System.out.println("Điểm đầu vào: " + student.getEntranceExamScore());
           
            if (student instanceof PartTimeStudent) {
                PartTimeStudent partTimeStudent = (PartTimeStudent) student;
                System.out.println("Nơi liên kết đào tạo: " + partTimeStudent.getTrainingLocation());
            }
            student.showAcademicResults();
            
            System.out.println(); 
        }
    }
}
