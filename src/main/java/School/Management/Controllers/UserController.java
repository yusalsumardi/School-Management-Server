package School.Management.Controllers;


import School.Management.Entities.UserEntity;
import School.Management.Response.CommonResponseGenerator;
import School.Management.Response.CommonResponse;
import School.Management.Services.Login.LoginLogoutService;
import School.Management.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    

    @Autowired
    UserService userService;

    @Autowired
    LoginLogoutService loginLogoutService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @PostMapping(value = "addUser")
    public CommonResponse<UserEntity> addNewUser(@RequestBody UserEntity param){
        try {
            UserEntity user = userService.addUser(param);
            return commonResponseGenerator.successResponse(user, "Success");
        } catch (Exception e){
            System.out.println("Gagal");
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getAllUser")
    public CommonResponse<List<UserEntity>> getAllUser(){
        try{
            List<UserEntity> users = userService.findAllUser();
            return commonResponseGenerator.successResponse(users, "Success");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getUserById")
    public CommonResponse<UserEntity> getUserById(@RequestParam int id){

        try {
            return commonResponseGenerator.successResponse(userService.findById(id), "Success");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @PostMapping(value = "updateUser")
    public CommonResponse<UserEntity> updateUser(@RequestBody UserEntity param){
        try {
            userService.updateUser(param);
            return commonResponseGenerator.successResponse(param, "Success");

        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @DeleteMapping(value = "delete")
    public CommonResponse<UserEntity> deleteUser(@RequestParam int id){
        try {
            userService.deleteById(id);
            List<UserEntity> usr = userService.findAllUser();
            return commonResponseGenerator.successResponse(usr, "Success");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "getByRole")
    public CommonResponse<List<UserEntity>> getByRole(@RequestParam(value = "role") Integer param){
        try {
            List<UserEntity> users;
            users = userService.findByRole(param);
            System.out.println(users);
            return commonResponseGenerator.successResponse(users, "Success");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getByName")
    public CommonResponse<List<UserEntity>> getByName(@RequestParam(value = "name") String param){
        try {
            List<UserEntity> users;
            users = userService.findByName(param);
            if (users == null) {
                return commonResponseGenerator.dataIsNull(param, "Name");
            }
            return commonResponseGenerator.successResponse(users, "Success");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getByUsername")
    public CommonResponse<List<UserEntity>> getByUsername(@RequestParam(value = "username") String param){
        try {
            UserEntity users;
            users = userService.findByUsername(param);
            System.out.println(users);
            if (users == null) {
                return commonResponseGenerator.dataIsNull(param, "Username");
            }
            return commonResponseGenerator.successResponse(users, "Success");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "login")
    public CommonResponse<UserEntity> Login(@RequestBody UserEntity param){
        try {
            boolean isLogin;
            UserEntity user = userService.findByUsername(param.getUsername());
            isLogin = loginLogoutService.LoginMet(param);
            System.out.println(isLogin);
            if (isLogin==false){
                userService.updateIsLogin(user.getId());
                return commonResponseGenerator.successResponse(user, "Success");
            } return commonResponseGenerator.dataIsNull(param.getUsername(), "Login");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
