package service;

import domain.Grade;
import exception.DuplicateEntityException;
import exception.EntityNotFoundException;
import repository.GradeRepository;

import java.util.List;

public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void create(Grade grade) {
        if (gradeRepository.findById(grade.getId()).isPresent()) {
            throw new DuplicateEntityException("Grade with id " + grade.getId() + " already exists");
        }
        gradeRepository.save(grade);
    }

    public Grade read(int id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grade with id " + id + " not found"));
    }

    public List<Grade> readAll() {
        return gradeRepository.findAll();
    }

    public void update(Grade grade) {
        read(grade.getId());
        gradeRepository.update(grade);
    }

    public void delete(int id) {
        read(id);
        gradeRepository.deleteById(id);
    }
}
