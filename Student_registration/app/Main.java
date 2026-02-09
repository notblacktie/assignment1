package assignment4.Student_registration.app;

import assignment4.Student_registration.repository.InMemoryCourseRepository;
import assignment4.Student_registration.repository.InMemoryStudentRepository;
import assignment4.Student_registration.repository.CourseRepository;
import assignment4.Student_registration.repository.StudentRepository;
import assignment4.Student_registration.service.CourseService;
import assignment4.Student_registration.service.EnrollmentService;
import assignment4.Student_registration.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepo = new InMemoryStudentRepository();
        CourseRepository courseRepo = new InMemoryCourseRepository();

        StudentService studentService = new StudentService(studentRepo);
        CourseService courseService = new CourseService(courseRepo);
        EnrollmentService enrollmentService = new EnrollmentService(studentRepo, courseRepo);

        ConsoleUI ui = new ConsoleUI(studentService, courseService, enrollmentService);
        ui.run();
    }
}
