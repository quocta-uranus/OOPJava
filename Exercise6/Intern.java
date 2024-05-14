package OOPJava.Exercise6;

public class Intern extends Employee {
     String Majors;
     String Semester;
     String University_name;

    public Intern(String ID, String fullName, String birthDay, String phone, String email, String majors, String semester, String university_name) {
        super(ID, fullName, birthDay, phone, email, 2); // 
        Majors = majors;
        Semester = semester;
        University_name = university_name;
    }
   

    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("Majors: " + Majors);
        System.out.println("Semester: " + Semester);
        System.out.println("University Name: " + University_name);
    }
}
