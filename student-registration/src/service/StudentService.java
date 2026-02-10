package service;

import domain.Student;
import exception.DuplicateEntityException;
import exception.EntityNotFoundException;
import repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) {
        if (studentRepository.findById(student.getId()).isPresent()) {
            throw new DuplicateEntityException("Student with id " + student.getId() + " already exists");
        }
        studentRepository.save(student);
    }

    public Student read(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
    }

    public List<Student> readAll() {
        return studentRepository.findAll();
    }

    public void update(Student student) {
        read(student.getId());
        studentRepository.update(student);
    }

    public void delete(int id) {
        read(id);
        studentRepository.deleteById(id);
    }
}
