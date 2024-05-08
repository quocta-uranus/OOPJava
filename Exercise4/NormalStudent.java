package OOPJava.Exercise4;

public class NormalStudent extends Student {
    private int englishScore;
    private int entryTestScore;

    public NormalStudent(String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel, int englishScore, int entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void showMyInfo() {
        System.out.println("Normal Student Information:");
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + doB);
        System.out.println("Sex: " + sex);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("University Name: " + universityName);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("English Score: " + englishScore);
        System.out.println("Entry Test Score: " + entryTestScore);
    }
}

