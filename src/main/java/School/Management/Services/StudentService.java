package School.Management.Services;


import School.Management.Entities.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {
    StudentEntity addStudent(StudentEntity param);

    List<StudentEntity> findAll();

    StudentEntity findById(int id);

    void deleteById(int id);

    StudentEntity updateStudent(StudentEntity param);
}
