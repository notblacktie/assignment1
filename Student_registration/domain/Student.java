package assignment4.Student_registration.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Person {
    private String faculty;
    private final List<Enrollment> enrollments;

    public Student(int id, String fullName, String email, String faculty) {
        super(id, fullName, email);
        this.faculty = faculty;
        this.enrollments = new java.util.ArrayList<>();
    }

    public String getFaculty() { return faculty; }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }


    public List<Enrollment> getEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }

    public void addEnrollment(Enrollment enrollment) {
        this.enrollments.add(enrollment);
    }

    public Enrollment findEnrollmentByCourseId(int courseId) {
        for (Enrollment e : enrollments) {
            if (e.getCourse().getCourseId() == courseId) return e;
        }
        return null;
    }

    public boolean hasActiveOrWaitlistedEnrollment(int courseId) {
        Enrollment e = findEnrollmentByCourseId(courseId);
        if (e == null) return false;
        return e.getStatus() == EnrollmentStatus.ACTIVE || e.getStatus() == EnrollmentStatus.WAITLISTED;
    }

    @Override
    public String toString() {
        return super.toString() + " | Faculty: " + faculty + " | Enrollments: " + enrollments.size();
    }
}
