package OOPJava.Exercise5;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Department computerScience = new Department("Computer Science");

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. Xác định tổng số sinh viên chính quy của khoa");
            System.out.println("3. Danh sách sinh viên tại chức tại nơi liên kết đào tạo cho trước");

            System.out.println("0. Thoát");

            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dấu new line sau khi đọc số nguyên

            switch (choice) {
                case 1:
                    inputStudentInfo(scanner, computerScience);
                    break;
                case 2:
                    int totalRegularStudents = computerScience.getTotalRegularStudents();
                    System.out.println("Tổng số sinh viên chính quy của khoa: " + totalRegularStudents);
                    break;
               case 3:
                    System.out.print("Nhập nơi liên kết đào tạo: ");
                    String trainingLocation = scanner.nextLine();
                    List<PartTimeStudent> affiliatedPartTimeStudents = computerScience.getAffiliatedPartTimeStudents(trainingLocation);
                    if (affiliatedPartTimeStudents.isEmpty()) {
                        System.out.println("Không có sinh viên tại chức tại nơi liên kết đào tạo này.");
                    } else {
                        System.out.println("Danh sách sinh viên tại chức tại nơi liên kết đào tạo " + trainingLocation + ":");
                        for (PartTimeStudent student : affiliatedPartTimeStudents) {
                            System.out.println(student.getfullName());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void inputStudentInfo(Scanner scanner, Department department) {
        System.out.print("Nhập số lượng sinh viên: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Đọc dấu new line sau khi đọc số nguyên

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 1) + ":");
            System.out.print("ID: ");
            String studentID = scanner.nextLine();

            System.out.print("Họ và tên: ");
            String fullName = scanner.nextLine();
            if (!isValidFullName(fullName)) {
                System.out.println("Invalid full name length! (10-50 characters)");
                i--;
                continue;
            }

            System.out.print("Ngày sinh (yyyy-mm-dd): ");
            String dateOfBirth = scanner.nextLine();
            if (!isValidDOB(dateOfBirth)) {
                System.out.println("Dinh dang ngay sinh k hop le !(dd/MM/YYYY)");
                i--; 
                continue;
            }

            System.out.print("Năm vào học: ");
            int admissionYear = scanner.nextInt();
            if (!isValidAdmissionYear(admissionYear)) {
                System.out.println("Invalid admission year! Year must be between 1900 and current year.");
                i--;
                continue;
            }

            System.out.print("Điểm đầu vào: ");
            double entranceExamScore = scanner.nextDouble();
            scanner.nextLine(); // Đọc dấu new line sau khi đọc số thực
            if (!isValidEntranceExamScore(entranceExamScore)) {
                System.out.println("Invalid entrance exam score! Score must be between 0 and 10.");
                i--;
                continue;
            }

            System.out.print("Loại sinh viên (1: Chính quy, 2: Tại chức): ");
            int type = scanner.nextInt();
            scanner.nextLine(); // Đọc dấu new line sau khi đọc số nguyên
            
            Student student;
            if (type == 1) {
                student = new Student(studentID, fullName, dateOfBirth, admissionYear, entranceExamScore,type);
            } else if (type == 2) {
                System.out.print("Nơi liên kết đào tạo: ");
                String trainingLocation = scanner.nextLine();
                student = new PartTimeStudent(studentID, fullName, dateOfBirth, admissionYear, entranceExamScore, trainingLocation,type);
            } else {
                System.out.println("Lựa chọn không hợp lệ. Không tạo sinh viên.");
                continue;
            }

            System.out.print("Nhập tên học kỳ: ");
            String semesterName = scanner.nextLine();

            System.out.print("Nhập điểm trung bình cho sinh viên " + fullName + ": ");
            double averageGPA = scanner.nextDouble();
            if (!isValidEntranceExamScore(averageGPA)) {
                System.out.println("Invalid average GPA! GPA must be between 0 and 10.");
                i--;
                continue;
            }

            student.addAcademicResult(new AcademicResult(semesterName, averageGPA));
            department.addStudent(student);
        }
    }

    private static boolean isValidFullName(String fullName) {
        return fullName.length() >= 10 && fullName.length() <= 50;
    }

    private static boolean isValidDOB(String  dateOfBirth ) {
        return dateOfBirth.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    private static boolean isValidAdmissionYear(int admissionYear) {
        int currentYear = java.time.Year.now().getValue();
        return admissionYear >= 1900 && admissionYear <= currentYear;
    }

    private static boolean isValidEntranceExamScore(double entranceExamScore) {
        return entranceExamScore >= 0 && entranceExamScore <= 10;
    }
}
