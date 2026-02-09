package assignment4.Student_registration.service;

import assignment4.Student_registration.domain.Course;
import assignment4.Student_registration.domain.Enrollment;
import assignment4.Student_registration.domain.EnrollmentStatus;
import assignment4.Student_registration.domain.Student;
import assignment4.Student_registration.exception.NotFoundException;
import assignment4.Student_registration.exception.ValidationException;
import assignment4.Student_registration.repository.CourseRepository;
import assignment4.Student_registration.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public EnrollmentStatus enroll(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId);
        Course course = courseRepository.findById(courseId);

        if (student == null) throw new NotFoundException("Student not found.");
        if (course == null) throw new NotFoundException("Course not found.");

        // запрет дублей (ACTIVE/WAITLISTED)
        if (student.hasActiveOrWaitlistedEnrollment(courseId)) {
            throw new ValidationException("Student is already enrolled or waitlisted for this course.");
        }

        int activeCount = countActive(courseId);
        EnrollmentStatus status = (activeCount < course.getCapacity())
                ? EnrollmentStatus.ACTIVE
                : EnrollmentStatus.WAITLISTED;

        student.addEnrollment(new Enrollment(course, status));
        return status;
    }

    public void drop(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId);
        if (student == null) throw new NotFoundException("Student not found.");

        Enrollment e = student.findEnrollmentByCourseId(courseId);
        if (e == null) throw new NotFoundException("Enrollment not found.");

        if (e.getStatus() == EnrollmentStatus.DROPPED) {
            throw new ValidationException("Enrollment already dropped.");
        }

        EnrollmentStatus was = e.getStatus();
        e.drop();

        // если студент уходил с ACTIVE то освобождается место и продвигаем из waitlist
        if (was == EnrollmentStatus.ACTIVE) {
            promoteFromWaitlist(courseId);
        }
    }

    public void setGrade(int studentId, int courseId, double grade) {
        if (grade < 0 || grade > 100) {
            throw new ValidationException("Grade must be between 0 and 100.");
        }

        Student student = studentRepository.findById(studentId);
        if (student == null) throw new NotFoundException("Student not found.");

        Enrollment e = student.findEnrollmentByCourseId(courseId);
        if (e == null) throw new NotFoundException("Enrollment not found.");

        if (e.getStatus() == EnrollmentStatus.DROPPED) {
            throw new ValidationException("Cannot grade a dropped enrollment.");
        }

        e.completeWithGrade(grade);
    }

    public int countActive(int courseId) {
        int count = 0;
        for (Student s : studentRepository.findAll()) {
            Enrollment e = s.findEnrollmentByCourseId(courseId);
            if (e != null && e.getStatus() == EnrollmentStatus.ACTIVE) count++;
        }
        return count;
    }

    public int countWaitlisted(int courseId) {
        int count = 0;
        for (Student s : studentRepository.findAll()) {
            Enrollment e = s.findEnrollmentByCourseId(courseId);
            if (e != null && e.getStatus() == EnrollmentStatus.WAITLISTED) count++;
        }
        return count;
    }

    private void promoteFromWaitlist(int courseId) {
        Course course = courseRepository.findById(courseId);
        if (course == null) return;

        // пока есть место - продвигаем по FIFO
        while (countActive(courseId) < course.getCapacity()) {
            Enrollment earliest = null;

            for (Student s : studentRepository.findAll()) {
                Enrollment e = s.findEnrollmentByCourseId(courseId);
                if (e != null && e.getStatus() == EnrollmentStatus.WAITLISTED) {
                    if (earliest == null || e.getCreatedAtMillis() < earliest.getCreatedAtMillis()) {
                        earliest = e;
                    }
                }
            }

            if (earliest == null) break; // никого в очереди нет
            earliest.setActive();
        }
    }

    // "аккуратно" освободить места и продвинуть очередь
    public void dropAllForStudent(int studentId) {
        Student student = studentRepository.findById(studentId);
        if (student == null) throw new NotFoundException("Student not found.");

        List<Integer> courseIds = new ArrayList<>();
        for (Enrollment e : student.getEnrollments()) {
            if (e.getStatus() != EnrollmentStatus.DROPPED) {
                courseIds.add(e.getCourse().getCourseId());
            }
        }

        for (int courseId : courseIds) {
            drop(studentId, courseId);
        }
    }
}
