package repository;

import domain.Enrollment;

import java.util.List;

public interface EnrollmentRepository extends CrudRepository<Enrollment> {
    List<Enrollment> findByStudentId(int studentId);
}
