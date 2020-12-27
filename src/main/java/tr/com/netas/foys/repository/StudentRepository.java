package tr.com.netas.foys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.netas.foys.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
