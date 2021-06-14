package School.Management.Services.Login;

import School.Management.Entities.StudentEntity;
import School.Management.Entities.UserEntity;
import School.Management.Repositories.StudentRepository;
import School.Management.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginLogoutServiceImpl implements LoginLogoutService{

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean LoginMet(UserEntity param) {
        UserEntity userDB = userRepository.findByUsername(param.getUsername());
        if (param.getUsername().equals(userDB.getUsername())&&param.getPassword().equals(userDB.getPassword())){
            System.out.println("Success Validasi Username && Password");
            return true;
        }
        return false;
    }
}
