package service;

import domain.Teacher;
import exception.DuplicateEntityException;
import exception.EntityNotFoundException;
import repository.TeacherRepository;

import java.util.List;

public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void create(Teacher teacher) {
        if (teacherRepository.findById(teacher.getId()).isPresent()) {
            throw new DuplicateEntityException("Teacher with id " + teacher.getId() + " already exists");
        }
        teacherRepository.save(teacher);
    }

    public Teacher read(int id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher with id " + id + " not found"));
    }

    public List<Teacher> readAll() {
        return teacherRepository.findAll();
    }
}
