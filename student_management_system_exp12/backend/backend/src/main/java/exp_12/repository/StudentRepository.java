package exp_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import exp_12.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}