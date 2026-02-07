package service;

import domain.Enrollment;
import domain.EnrollmentStatus;
import domain.Grade;
import domain.Student;
import exception.DuplicateEntityException;
import exception.EntityNotFoundException;
import exception.ValidationException;
import repository.EnrollmentRepository;
import repository.GradeRepository;
import strategy.GradingStrategy;

import java.util.List;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final GradeRepository gradeRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             GradeRepository gradeRepository,
                             StudentService studentService,
                             CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.gradeRepository = gradeRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void create(Enrollment enrollment) {
        if (enrollmentRepository.findById(enrollment.getId()).isPresent()) {
            throw new DuplicateEntityException("Enrollment with id " + enrollment.getId() + " already exists");
        }
        studentService.read(enrollment.getStudentId());
        courseService.read(enrollment.getCourseId());
        enrollmentRepository.save(enrollment);

        Student student = studentService.read(enrollment.getStudentId());
        student.getEnrollments().add(enrollment);
        studentService.update(student);
    }

    public Enrollment read(int id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment with id " + id + " not found"));
    }

    public List<Enrollment> readAll() {
        return enrollmentRepository.findAll();
    }

    public void updateStatus(int enrollmentId, EnrollmentStatus status) {
        Enrollment enrollment = read(enrollmentId);
        enrollment.setStatus(status);
        enrollmentRepository.update(enrollment);
    }

    public void delete(int id) {
        Enrollment enrollment = read(id);
        enrollmentRepository.deleteById(id);

        Student student = studentService.read(enrollment.getStudentId());
        student.getEnrollments().removeIf(item -> item.getId() == id);
        studentService.update(student);
    }

    public void addGrade(int enrollmentId, Grade grade) {
        if (grade.getMaxPoints() <= 0 || grade.getPoints() < 0 || grade.getPoints() > grade.getMaxPoints()) {
            throw new ValidationException("Incorrect grade boundaries");
        }

        Enrollment enrollment = read(enrollmentId);
        gradeRepository.save(grade);
        enrollment.getGrades().add(grade);
        enrollmentRepository.update(enrollment);
    }

    public double calculatePercentage(int enrollmentId) {
        Enrollment enrollment = read(enrollmentId);
        double points = 0;
        double maxPoints = 0;

        for (Grade grade : enrollment.getGrades()) {
            points += grade.getPoints();
            maxPoints += grade.getMaxPoints();
        }

        if (maxPoints == 0) {
            return 0;
        }
        return (points / maxPoints) * 100;
    }

    public String evaluateFinalResult(int enrollmentId, GradingStrategy gradingStrategy) {
        double percentage = calculatePercentage(enrollmentId);
        return gradingStrategy.evaluate(percentage);
    }
}
