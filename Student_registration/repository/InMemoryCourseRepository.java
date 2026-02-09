package assignment4.Student_registration.repository;

import assignment4.Student_registration.domain.Course;
import assignment4.Student_registration.domain.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCourseRepository implements CourseRepository {
    private Map<Integer, Course> courses = new HashMap<>();

    public InMemoryCourseRepository() {
        Teacher t1 = new Teacher(201, "Altynbek Toleu", "toleu@uni.edu", "CS");
        Teacher t2 = new Teacher(202, "Arman Kudaibergen", "arman@uni.edu", "Math");
        Teacher t3 = new Teacher(203, "Zhanat Maral", "zhanat@uni.edu", "Arts");

        add(new Course(101, "Object Oriented Programming", t1, 2));
        add(new Course(102, "Calculus II", t2, 1));
        add(new Course(103, "History of Art", t3, 3));
    }

    @Override
    public void add(Course course) { courses.put(course.getCourseId(), course); }

    @Override
    public Course findById(int id) { return courses.get(id); }

    @Override
    public List<Course> findAll() { return new ArrayList<>(courses.values()); }

    @Override
    public void delete(int id) { courses.remove(id); }
}
