package School.Management.Controllers;


import School.Management.Entities.Role;
import School.Management.Response.CommonResponse;
import School.Management.Response.CommonResponseGenerator;
import School.Management.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "getAllRole")
    public CommonResponse<List<Role>> getAllRole(){
        try{
            List<Role> students = roleService.findAll();
            return commonResponseGenerator.successResponse(students, "Success");

        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
