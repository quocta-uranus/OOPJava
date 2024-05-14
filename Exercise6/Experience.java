package OOPJava.Exercise6;

 class Experience extends Employee {
    int ExpInYear;
    String ProSkill;

    public Experience(String ID, String fullName, String birthDay, String phone, String email, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, 0); 
        ExpInYear = expInYear;
        ProSkill = proSkill;
    }
    

    

    
    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("Experience In Year: " + ExpInYear);
        System.out.println("Professional Skill: " + ProSkill);
    }
}
