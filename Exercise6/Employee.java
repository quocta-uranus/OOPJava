package OOPJava.Exercise6;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    protected String ID;
    protected String FullName;
    protected String BirthDay;
    protected String Phone;
    protected String Email;
    protected int Employee_type;
    protected int Employee_count;
    protected List<Certificate> certificates;

    public Employee(String ID, String fullName, String birthDay, String phone, String email, int employee_type) {
        this.ID = ID;
        FullName = fullName;
        BirthDay = birthDay;
        Phone = phone;
        Email = email;
        Employee_type = employee_type;
        Employee_count = 0;
        certificates = new ArrayList<>();
    }

    public void ShowInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Full Name: " + FullName);
        System.out.println("Birth Day: " + BirthDay);
        System.out.println("Phone: " + Phone);
        System.out.println("Email: " + Email);
        System.out.println("Employee Type: " + Employee_type);
        System.out.println("Employee Count: " + Employee_count);
        for (Certificate cert : certificates) {
            cert.ShowCertificateInfo();
        }
    }

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
    }
}
