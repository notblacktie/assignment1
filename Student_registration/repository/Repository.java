package assignment4.Student_registration.repository;

import java.util.List;

// Pattern: REPOSITORY
public interface Repository<T> {
    void add(T item);
    T findById(int id);
    List<T> findAll();
    void delete(int id);
}