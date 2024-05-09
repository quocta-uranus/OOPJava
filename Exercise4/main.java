package OOPJava.Exercise4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap so hoc sinh:");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            try {
                System.out.println("Nhap thong tin hoc sinh # " + (i + 1) + ":");

                System.out.print("Full Name: ");
                String fullName = scanner.nextLine();
                if (!isValidFullName(fullName)) {
                    System.out.println("Invalid full name length! (10-50 characters)");
                    i--;
                    continue;
                }

                System.out.print("Date of Birth (dd/MM/YYYY): ");
                String doB = scanner.nextLine();
                if (!isValidDOB(doB)) {
                    System.out.println("Dinh dang ngay sinh k hop le !(dd/MM/YYYY)");
                    i--; 
                    continue;
                }

                System.out.print("Sex: ");
                String sex = scanner.nextLine();

                System.out.print("Phone Number: ");
                String phoneNumber = scanner.nextLine();
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Dinh dang sdt k hop le! (Start with 090, 098, 091, 031, 035, or 038)");
                    i--; 
                    continue;
                }

                System.out.print("University Name: ");
                String universityName = scanner.nextLine();

                System.out.print("Grade Level: ");
                String gradeLevel = scanner.nextLine();

                System.out.print("Student Type (Good/Normal): ");
                String studentType = scanner.nextLine();

                if (studentType.equalsIgnoreCase("Good")) {
                    System.out.print("GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Best Reward Name: ");
                    String bestRewardName = scanner.nextLine();

                    students.add(new GoodStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, gpa, bestRewardName));
                } else if (studentType.equalsIgnoreCase("Normal")) {
                    System.out.print("English Score: ");
                    int englishScore = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Entry Test Score: ");
                    int entryTestScore = scanner.nextInt();
                    scanner.nextLine();

                    students.add(new NormalStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, englishScore, entryTestScore));
                } else {
                    System.out.println("Invalid student type. Please enter either 'Good' or 'Normal'.");
                    i--; 
                }
            } catch (Exception e) {
                System.out.println("Input files have unknown errors !!!");
                scanner.close(); 
                return;
            }
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int fullNameComparison = s2.fullName.compareTo(s1.fullName);
                if (fullNameComparison != 0) {
                    return fullNameComparison;
                } else {
                    return s1.phoneNumber.compareTo(s2.phoneNumber);
                }
            }
        });

        for (Student student : students) {
            student.showMyInfo();
            System.out.println("-----------------------");
        }

        scanner.close();
    }

   
    private static boolean isValidFullName(String fullName) {
        return fullName.length() >= 10 && fullName.length() <= 50;
    }

    
    private static boolean isValidDOB(String doB) {
        return doB.matches("\\d{2}/\\d{2}/\\d{4}");
    }


    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("(090|098|091|031|035|038)\\d{7}");
    }
}
