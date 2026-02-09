package assignment4.Student_registration.service;

import assignment4.Student_registration.domain.Course;
import assignment4.Student_registration.exception.NotFoundException;
import assignment4.Student_registration.repository.CourseRepository;

import java.util.List;

public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(int id) {
        Course c = courseRepository.findById(id);
        if (c == null) throw new NotFoundException("Course not found.");
        return c;
    }
}
