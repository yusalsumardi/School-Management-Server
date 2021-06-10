package School.Management.Controllers;


import School.Management.Entities.StudentEntity;
import School.Management.Response.CommonResponse;
import School.Management.Response.CommonResponseGenerator;
import School.Management.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @PostMapping(value = "addStudent")
    public CommonResponse<StudentEntity> addStudent(@RequestBody StudentEntity param){
        try{
            StudentEntity newStudent = studentService.addStudent(param);
            return commonResponseGenerator.successResponse(newStudent, "Success");

        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getAllStudent")
    public CommonResponse<List<StudentEntity>> getAllStudent(){
        try{
            List<StudentEntity> students = studentService.findAll();
            return commonResponseGenerator.successResponse(students, "Success");

        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getById")
    public CommonResponse<StudentEntity> getStudent(int id) {
        try {
            return commonResponseGenerator.successResponse(studentService.findById(id), "Success");
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "updateStudent")
    public CommonResponse<StudentEntity> updateStudent(@RequestBody StudentEntity param){
        try {
            studentService.updateStudent(param);
            return commonResponseGenerator.successResponse(param, "Success");
        } catch (Exception e) {
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

}
