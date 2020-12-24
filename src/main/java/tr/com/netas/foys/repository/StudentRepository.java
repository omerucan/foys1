package tr.com.netas.foys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.netas.foys.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
