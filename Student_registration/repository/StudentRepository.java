package assignment4.Student_registration.repository;


import assignment4.Student_registration.domain.Student;

public interface StudentRepository extends Repository<Student> {
    boolean existsByEmail(String email);
}