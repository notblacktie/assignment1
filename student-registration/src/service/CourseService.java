package service;

import domain.Course;
import exception.DuplicateEntityException;
import exception.EntityNotFoundException;
import repository.CourseRepository;

import java.util.List;

public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void create(Course course) {
        if (courseRepository.findById(course.getId()).isPresent()) {
            throw new DuplicateEntityException("Course with id " + course.getId() + " already exists");
        }
        courseRepository.save(course);
    }

    public Course read(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course with id " + id + " not found"));
    }

    public List<Course> readAll() {
        return courseRepository.findAll();
    }

    public void update(Course course) {
        read(course.getId());
        courseRepository.update(course);
    }

    public void delete(int id) {
        read(id);
        courseRepository.deleteById(id);
    }
}
