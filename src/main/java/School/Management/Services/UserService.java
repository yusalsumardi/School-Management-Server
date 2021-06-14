package School.Management.Services;


import School.Management.Entities.UserEntity;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public interface UserService {

    UserEntity addUser(UserEntity param);

    List<UserEntity> findAllUser();

    UserEntity findById(int id);

    List<UserEntity>findByRole(Integer param);

    void deleteById(int id);

    List<UserEntity> findByName(String param);

    UserEntity updateUser(UserEntity param);

    UserEntity findByUsername(String param);

    UserEntity updateIsLogin(String param);
}
