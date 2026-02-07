package repository.memory;

import domain.Student;
import repository.StudentRepository;

public class InMemoryStudentRepository extends InMemoryCrudRepository<Student> implements StudentRepository {
}
