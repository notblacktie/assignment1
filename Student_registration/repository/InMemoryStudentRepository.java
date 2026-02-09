package assignment4.Student_registration.repository;

import assignment4.Student_registration.domain.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStudentRepository implements StudentRepository {
    private Map<Integer, Student> storage = new HashMap<>();

    @Override
    public void add(Student student) { storage.put(student.getId(), student); }

    @Override
    public Student findById(int id) { return storage.get(id); }

    @Override
    public List<Student> findAll() { return new ArrayList<>(storage.values()); }

    @Override
    public void delete(int id) { storage.remove(id); }

    @Override
    public boolean existsByEmail(String email) {
        return storage.values().stream().anyMatch(s -> s.getEmail().equalsIgnoreCase(email));
    }
}