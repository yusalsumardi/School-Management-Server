package School.Management.Repositories;

import School.Management.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
