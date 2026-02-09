package assignment4.Student_registration.service;

import assignment4.Student_registration.domain.Student;
import assignment4.Student_registration.exception.NotFoundException;
import assignment4.Student_registration.exception.ValidationException;
import assignment4.Student_registration.repository.StudentRepository;
import assignment4.Student_registration.builder.StudentBuilder;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent(int id, String name, String email, String faculty) {
        if (studentRepository.findById(id) != null) {
            throw new ValidationException("Student with ID " + id + " already exists.");
        }
        if (studentRepository.existsByEmail(email)) {
            throw new ValidationException("Email " + email + " is already taken.");
        }
        Student newStudent = new StudentBuilder()
                .setId(id)
                .setFullName(name)
                .setEmail(email)
                .setFaculty(faculty)
                .build();

        studentRepository.add(newStudent);
    }

    public void updateStudent(int id, String newEmail, String newFaculty) {
        Student s = studentRepository.findById(id);
        if (s == null) throw new NotFoundException("Student not found.");

        // email менять можно, проверить уникальность
        if (newEmail != null && !newEmail.trim().isEmpty()) {
            if (!s.getEmail().equalsIgnoreCase(newEmail) && studentRepository.existsByEmail(newEmail)) {
                throw new ValidationException("Email " + newEmail + " is already taken.");
            }
            s.setEmail(newEmail);
        }

        if (newFaculty != null && !newFaculty.trim().isEmpty()) {
            s.setFaculty(newFaculty);
        }
    }

    public void deleteStudent(int id) {
        Student s = studentRepository.findById(id);
        if (s == null) throw new NotFoundException("Student not found.");
        studentRepository.delete(id);
    }

    public Student getStudent(int id) {
        Student s = studentRepository.findById(id);
        if (s == null) throw new NotFoundException("Student not found.");
        return s;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
