package OOPJava.Exercise6;

class Fresher extends Employee {
    String Graduation_date;
    String Graduation_rank;
    String Education;

    public Fresher(String ID, String fullName, String birthDay, String phone, String email, String graduation_date, String graduation_rank, String education) {
        super(ID, fullName, birthDay, phone, email, 1); 
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        Education = education;
    }
    
   
    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("Graduation Date: " + Graduation_date);
        System.out.println("Graduation Rank: " + Graduation_rank);
        System.out.println("Education: " + Education);
    }
}
