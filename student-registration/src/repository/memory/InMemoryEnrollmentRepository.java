package repository.memory;

import domain.Enrollment;
import repository.EnrollmentRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEnrollmentRepository extends InMemoryCrudRepository<Enrollment> implements EnrollmentRepository {
    @Override
    public List<Enrollment> findByStudentId(int studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : findAll()) {
            if (enrollment.getStudentId() == studentId) {
                result.add(enrollment);
            }
        }
        return result;
    }
}
