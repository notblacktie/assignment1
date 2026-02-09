package assignment4.Student_registration.builder;

import assignment4.Student_registration.domain.Student;

public class StudentBuilder {
    private int id;
    private String fullName;
    private String email;
    private String faculty;

    public StudentBuilder setId(int id) { this.id = id; return this; }
    public StudentBuilder setFullName(String fullName) { this.fullName = fullName; return this; }
    public StudentBuilder setEmail(String email) { this.email = email; return this; }
    public StudentBuilder setFaculty(String faculty) { this.faculty = faculty; return this; }

    public Student build() {
        return new Student(id, fullName, email, faculty);
    }
}
