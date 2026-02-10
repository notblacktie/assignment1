package domain;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String faculty;
    private List<Enrollment> enrollments;

    public Student(int id, String fullName, String email, String faculty) {
        super(id, fullName, email);
        this.faculty = faculty;
        this.enrollments = new ArrayList<>();
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
