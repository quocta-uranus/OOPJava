package OOPJava.Exercise4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); 

        ArrayList<Student> students = new ArrayList<>();

   
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter student #" + (i + 1) + " information:");

            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();

            System.out.print("Date of Birth (dd/MM/YYYY): ");
            String doB = scanner.nextLine();

            System.out.print("Sex: ");
            String sex = scanner.nextLine();

            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("University Name: ");
            String universityName = scanner.nextLine();

            System.out.print("Grade Level: ");
            String gradeLevel = scanner.nextLine();

            // Determine if the student is GoodStudent or NormalStudent
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
}


   