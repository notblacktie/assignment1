package repository.memory;

import domain.Course;
import repository.CourseRepository;

public class InMemoryCourseRepository extends InMemoryCrudRepository<Course> implements CourseRepository {
}
