package OOPJava.Exercise4;

import java.util.ArrayList;

public abstract class Student {
    protected String fullName;
    protected String doB;
    protected String sex;
    protected String phoneNumber;
    protected String universityName;
    protected String gradeLevel;

    public Student(String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel) {
        this.fullName = fullName;
        this.doB = doB;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
    }
    String getFullName() {
        return fullName;
    }

    String getDoB() {
        return doB;
    }

    String getSex() {
        return sex;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getUniversityName() {
        return universityName;
    }

    String getGradeLevel() {
        return gradeLevel;
    }

    public abstract void showMyInfo();
}
