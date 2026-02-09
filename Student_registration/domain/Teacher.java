package assignment4.Student_registration.domain;

public class Teacher extends Person {
    private String department;

    public Teacher(int id, String fullName, String email, String department) {
        super(id, fullName, email);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return super.toString() + " | Department: " + department;
    }
}
