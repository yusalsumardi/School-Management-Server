package School.Management.Services;

import School.Management.Entities.UserEntity;
import School.Management.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public UserEntity addUser(UserEntity param) {
        return userRepository.save(param);
    }

    @Override
    public List<UserEntity> findAllUser() {
        List<UserEntity> users = userRepository.findAll();
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserEntity> findByRole(Integer param) {
        return userRepository.findByRole(param);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> findByName(String param) {
        return userRepository.findByName(param);
    }

    @Override
    public UserEntity updateUser(UserEntity param) {
        UserEntity newuser = userRepository.getById(param.getId());
        newuser.setName(param.getName());
        newuser.setUsername(param.getUsername());
        newuser.setPassword(param.getPassword());
        newuser.setRole(param.getRole());
        return userRepository.save(newuser);
    }

    @Override
    public UserEntity findByUsername(String param) {
        return userRepository.findByUsername(param);
    }
}
