package app;

import repository.memory.InMemoryCourseRepository;
import repository.memory.InMemoryEnrollmentRepository;
import repository.memory.InMemoryGradeRepository;
import repository.memory.InMemoryStudentRepository;
import repository.memory.InMemoryTeacherRepository;
import service.CourseService;
import service.EnrollmentService;
import service.StudentService;
import service.TeacherService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService(new InMemoryStudentRepository());
        TeacherService teacherService = new TeacherService(new InMemoryTeacherRepository());
        CourseService courseService = new CourseService(new InMemoryCourseRepository());
        EnrollmentService enrollmentService = new EnrollmentService(
                new InMemoryEnrollmentRepository(),
                new InMemoryGradeRepository(),
                studentService,
                courseService
        );

        new DemoRunner(studentService, teacherService, courseService, enrollmentService).run();
    }
}
