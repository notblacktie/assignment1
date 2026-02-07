package app;

import domain.Course;
import domain.Enrollment;
import domain.EnrollmentStatus;
import domain.Grade;
import domain.Student;
import domain.Teacher;
import factory.GradingStrategyFactory;
import service.CourseService;
import service.EnrollmentService;
import service.StudentService;
import service.TeacherService;
import strategy.GradingStrategy;
import util.IdGenerator;

public class DemoRunner {
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public DemoRunner(StudentService studentService,
                      TeacherService teacherService,
                      CourseService courseService,
                      EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    public void run() {
        IdGenerator idGenerator = new IdGenerator();

        Teacher teacher = new Teacher(idGenerator.nextId(), "Dr. Ada Lovelace", "ada@uni.edu", "Computer Science");
        teacherService.create(teacher);

        Course course = new Course(idGenerator.nextId(), "OOP Fundamentals", "Mon 10:00", teacher);
        courseService.create(course);

        Student student = new Student(idGenerator.nextId(), "Grace Hopper", "grace@uni.edu", "Software Engineering");
        studentService.create(student);

        Enrollment enrollment = new Enrollment(idGenerator.nextId(), student.getId(), course.getId(), EnrollmentStatus.ACTIVE);
        enrollmentService.create(enrollment);

        enrollmentService.addGrade(enrollment.getId(), new Grade(idGenerator.nextId(), "Midterm", 43, 50));
        enrollmentService.addGrade(enrollment.getId(), new Grade(idGenerator.nextId(), "Final", 41, 50));

        GradingStrategyFactory factory = new GradingStrategyFactory();
        GradingStrategy letterStrategy = factory.create("LETTER");
        GradingStrategy passFailStrategy = factory.create("PASS_FAIL");

        double percent = enrollmentService.calculatePercentage(enrollment.getId());
        System.out.println("=== CREATE/READ DEMO ===");
        System.out.println("Student: " + studentService.read(student.getId()).getFullName());
        System.out.println("Course: " + courseService.read(course.getId()).getTitle());
        System.out.println("Average percent: " + percent);
        System.out.println("Letter result (Strategy): " + enrollmentService.evaluateFinalResult(enrollment.getId(), letterStrategy));
        System.out.println("Pass/Fail result (Strategy): " + enrollmentService.evaluateFinalResult(enrollment.getId(), passFailStrategy));

        student.setFaculty("Computer Science");
        studentService.update(student);
        enrollmentService.updateStatus(enrollment.getId(), EnrollmentStatus.COMPLETED);
        System.out.println("=== UPDATE DEMO ===");
        System.out.println("Updated faculty: " + studentService.read(student.getId()).getFaculty());
        System.out.println("Updated enrollment status: " + enrollmentService.read(enrollment.getId()).getStatus());

        enrollmentService.delete(enrollment.getId());
        courseService.delete(course.getId());
        studentService.delete(student.getId());

        System.out.println("=== DELETE DEMO ===");
        System.out.println("Students after delete: " + studentService.readAll().size());
        System.out.println("Courses after delete: " + courseService.readAll().size());
        System.out.println("Enrollments after delete: " + enrollmentService.readAll().size());
    }
}
