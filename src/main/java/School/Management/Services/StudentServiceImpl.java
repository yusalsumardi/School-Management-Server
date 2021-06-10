package School.Management.Services;

import School.Management.Entities.StudentEntity;
import School.Management.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentEntity addStudent(StudentEntity param) {
        return studentRepository.save(param);
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentEntity updateStudent(StudentEntity param) {
        StudentEntity newstudent = studentRepository.getById(param.getId());
        newstudent.setName(param.getName());
        newstudent.setStudentclass(param.getStudentclass());
        newstudent.setStudentstatus(param.getStudentclass());
        newstudent.setSchoolorigin(param.getSchoolorigin());
        newstudent.setAge(param.getAge());
        newstudent.setBirthPlace(param.getBirthPlace());
        newstudent.setBirthDate(param.getBirthDate());
        return newstudent;
    }
}
