package assignment4.Student_registration.domain;

public class Course {
    private int courseId;
    private String courseName;
    private Teacher teacher;
    private int capacity;

    public Course(int courseId, String courseName, Teacher teacher, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
        this.capacity = capacity;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public Teacher getTeacher() { return teacher; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format(
                "Course [%d]: %s | Teacher: %s | Capacity: %d",
                courseId, courseName, teacher.getFullName(), capacity
        );
    }
}
