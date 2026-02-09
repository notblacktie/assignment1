package assignment4.Student_registration.domain;

public class Enrollment {
    private Course course;
    private EnrollmentStatus status;
    private Double grade;
    private long createdAtMillis;

    public Enrollment(Course course, EnrollmentStatus status) {
        this.course = course;
        this.status = status;
        this.grade = null;
        this.createdAtMillis = System.currentTimeMillis();
    }

    public Course getCourse() { return course; }
    public EnrollmentStatus getStatus() { return status; }
    public Double getGrade() { return grade; }
    public long getCreatedAtMillis() { return createdAtMillis; }

    public void setActive() {
        this.status = EnrollmentStatus.ACTIVE;
    }

    public void setWaitlisted() {
        this.status = EnrollmentStatus.WAITLISTED;
    }

    public void drop() {
        this.status = EnrollmentStatus.DROPPED;
    }

    public void completeWithGrade(double grade) {
        this.grade = grade;
        this.status = EnrollmentStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return course.getCourseName() + " | Status: " + status + " | Grade: " + (grade == null ? "-" : grade);
    }
}
