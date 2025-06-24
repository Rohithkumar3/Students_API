package Student_API.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Student_API.Student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
