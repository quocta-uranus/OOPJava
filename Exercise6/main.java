package OOPJava.Exercise6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Show All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    showAllEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        
        scanner.close();
    }

    private static void addEmployee() {
        System.out.println("Choose employee type:");
        System.out.println("0: Experience");
        System.out.println("1: Fresher");
        System.out.println("2: Intern");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
    
        String id, name, birth, phone, email;
        System.out.print("ID: ");
        id = scanner.nextLine();
        if (findEmployeeById(id) != null) {
            System.out.println("Employee with ID " + id + " already exists!");
            return;
        }
    
        while (true) {
        
            System.out.print("Full Name: ");
            name = scanner.nextLine();
            if (!isValidFullName(name)) {
                System.out.println("Invalid full name! Please try again.");
              

            } else {
                break;
            }
        }
       
      
        System.out.print("Birth Day (dd/MM/yyyy): ");
        birth = scanner.nextLine();
        while (true) {
            if (!isValidDOB(birth)) {
                System.out.println("Invalid birth day format! Use dd/MM/yyyy. Please try again.");
                System.out.print("Birth Day (dd/MM/yyyy): ");

                birth = scanner.nextLine();

            } else {
                break;
            }
        }
      
        System.out.print("Phone: ");
        phone = scanner.nextLine();
        while (true) {
            if (!isValidPhoneNumber(phone)) {
                System.out.println("Invalid phone number format! Use 10 digits starting with 090, 098, 091, 031, 035, or 038. Please try again.");
                System.out.print("Phone: ");

                phone = scanner.nextLine();
            } else {
                break;
            }
        }
    
    
        System.out.print("Email: ");
        email = scanner.nextLine();
        while (true) {
            if (!isValidGmail(email)) {
                System.out.println("Invalid email format! Must be a Gmail address. Please try again.");
                email = scanner.nextLine();
            } else {
                break;
            }
        }
        
    
        Employee employee = null;
    
        switch (choice) {
            case 0:
                System.out.print("Experience In Year: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                System.out.print("Professional Skill: ");
                String proSkill = scanner.nextLine();
                employee = new Experience(id, name, birth, phone, email, expInYear, proSkill);
                addCertificate(employee); 
                break;
            case 1:
                System.out.print("Graduation Date: ");
                String gradDate = scanner.nextLine();
                System.out.print("Graduation Rank: ");
                String gradRank = scanner.nextLine();
                System.out.print("Education: ");
                String education = scanner.nextLine();
                employee = new Fresher(id, name, birth, phone, email, gradDate, gradRank, education);
                addCertificate(employee); 
                break;
            case 2:
                System.out.print("Majors: ");
                String majors = scanner.nextLine();
                System.out.print("Semester: ");
                String semester = scanner.nextLine();
                System.out.print("University Name: ");
                String uniName = scanner.nextLine();
                employee = new Intern(id, name, birth, phone, email, majors, semester, uniName);
                addCertificate(employee); 
                break;
            default:
                System.out.println("Invalid choice!");
        }
    
        if (employee != null) {
            employees.add(employee);
            System.out.println("Employee added successfully!");
        }
    }
    

   private static void updateEmployee() {
    System.out.print("Enter Employee ID to update: ");
    String id = scanner.nextLine();
    Employee employee = findEmployeeById(id);
    if (employee == null) {
        System.out.println("Employee with ID " + id + " not found!");
        return;
    }

    System.out.println("Choose employee type to update:");
    System.out.println("0: Experience");
    System.out.println("1: Fresher");
    System.out.println("2: Intern");
    int choice = scanner.nextInt();
    scanner.nextLine(); 
    String name, birth, phone, email;
    while (true) {
        
        System.out.print("Full Name(" + employee.FullName + "): ");
        name = scanner.nextLine();
        if (!isValidFullName(name)) {
            System.out.println("Invalid full name! Please try again.");
          

        } else {
            break;
        }
    }
    
    if (!name.isEmpty()) {
        employee.FullName = name;
    }
    System.out.print("Birth Day (" + employee.BirthDay + "): ");
    birth = scanner.nextLine();
    if (!birth.isEmpty()) {
        employee.BirthDay = birth;
    }
    System.out.print("Phone (" + employee.Phone + "): ");
    phone = scanner.nextLine();
    if (!phone.isEmpty()) {
        employee.Phone = phone;
    }
    System.out.print("Email (" + employee.Email + "): ");
    email = scanner.nextLine();
    if (!email.isEmpty()) {
        employee.Email = email;
    }

    if (employee instanceof Experience && choice == 0) {
        Experience expEmployee = (Experience) employee;
        System.out.print("Experience In Year (" + expEmployee.ExpInYear + "): ");
        int expInYear = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        if (expInYear != 0) {
            expEmployee.ExpInYear = expInYear;
        }
        System.out.print("Professional Skill (" + expEmployee.ProSkill + "): ");
        String proSkill = scanner.nextLine();
        if (!proSkill.isEmpty()) {
            expEmployee.ProSkill = proSkill;
        }
        System.out.println("Employee updated successfully!");
    } else if (employee instanceof Fresher && choice == 1) {
        Fresher freshEmployee = (Fresher) employee;
        System.out.print("Graduation Date (" + freshEmployee.Graduation_date + "): ");
        String gradDate = scanner.nextLine();
        if (!gradDate.isEmpty()) {
            freshEmployee.Graduation_date = gradDate;
        }
        System.out.print("Graduation Rank (" + freshEmployee.Graduation_rank + "): ");
        String gradRank = scanner.nextLine();
        if (!gradRank.isEmpty()) {
            freshEmployee.Graduation_rank = gradRank;
        }
        System.out.print("Education (" + freshEmployee.Education + "): ");
        String education = scanner.nextLine();
        if (!education.isEmpty()) {
            freshEmployee.Education = education;
        }
        System.out.println("Employee updated successfully!");
    } else if (employee instanceof Intern && choice == 2) {
        Intern internEmployee = (Intern) employee;
        System.out.print("Majors (" + internEmployee.Majors + "): ");
        String majors = scanner.nextLine();
        if (!majors.isEmpty()) {
            internEmployee.Majors = majors;
        }
        System.out.print("Semester (" + internEmployee.Semester + "): ");
        String semester = scanner.nextLine();
        if (!semester.isEmpty()) {
            internEmployee.Semester = semester;
        }
        System.out.print("University Name (" + internEmployee.University_name + "): ");
        String uniName = scanner.nextLine();
        if (!uniName.isEmpty()) {
            internEmployee.University_name = uniName;
        }
        System.out.println("Employee updated successfully!");
    } else {
        System.out.println("Invalid employee type or choice!");
    }

}


    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String id = scanner.nextLine();
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with ID " + id + " not found!");
        } else {
            employees.remove(employee);
            System.out.println("Employee with ID " + id + " deleted successfully!");
        }
    }

    private static void showAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            System.out.println("All Employees:");
            for (Employee employee : employees) {
                employee.ShowInfo();
                System.out.println("-----------------------");
            }
        }
    }

    private static Employee findEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.ID.equals(id)) {
                return employee;
            }
        }
        return null;
    }
    private static boolean isValidFullName(String name) {
        return name.length() >= 10 && name.length() <= 50;
    }

    private static boolean isValidDOB(String  birth ) {
        return birth.matches("\\d{2}/\\d{2}/\\d{4}");
    }
    private static boolean isValidPhoneNumber(String phone) {
        return phone.matches("(090|098|091|031|035|038)\\d{7}");
    }
    private static boolean isValidGmail(String email) {
       
        String gmailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:gmail)\\.(?:com)$";
        return email.matches(gmailPattern);
    }
    private static void addCertificate(Employee employee) {
        System.out.println("Enter Certificate Information:");
        
        System.out.print("Certificate ID: ");
        String certificatedID = scanner.nextLine();
        
        System.out.print("Certificate Name: ");
        String certificateName = scanner.nextLine();
        
        System.out.print("Certificate Rank: ");
        String certificateRank = scanner.nextLine();
        
        System.out.print("Certificate Date: ");
        String certificatedDate = scanner.nextLine();
      
        Certificate certificate = new Certificate(certificatedID, certificateName, certificateRank, certificatedDate);
        
   
        employee.addCertificate(certificate);
    }
    

}
