package OOPJava.Exercise5;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

 
        Department computerScience = new Department("Computer Science");

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 1) + ":");
            System.out.print("ID: ");
            String studentID = scanner.nextLine();
            System.out.print("Họ và tên: ");
            String fullName = scanner.nextLine();
            System.out.print("Ngày sinh (yyyy-mm-dd): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Năm vào học: ");
            int admissionYear = scanner.nextInt();
            System.out.print("Điểm đầu vào: ");
            double entranceExamScore = scanner.nextDouble();
            scanner.nextLine(); 
          
           
            System.out.print("Loại sinh viên (1: Chính quy, 2: Tại chức): ");
            int studentType = scanner.nextInt();
            scanner.nextLine(); 
         
              
             
            Student student;
            if (studentType == 1) {
                student = new Student(studentID, fullName, dateOfBirth, admissionYear, entranceExamScore);
            } else {
                System.out.print("Nơi liên kết đào tạo: ");
                String trainingLocation = scanner.nextLine();
                student = new PartTimeStudent(studentID, fullName, dateOfBirth, admissionYear, entranceExamScore, trainingLocation);
            }
            System.out.print("Nhap ten hoc ki :" );
            String semesterName = scanner.nextLine();
              System.out.print("Nhập điểm trung bình cho sinh viên " + fullName + ": ");
              double averageGPA = scanner.nextDouble();
           
            student.addAcademicResult(new AcademicResult(semesterName, averageGPA));
            computerScience.addStudent(student);

            computerScience.showStudentsInfo();
    
            
        }


        scanner.close();
    }
}
