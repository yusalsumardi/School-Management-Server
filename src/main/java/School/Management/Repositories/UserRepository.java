package School.Management.Repositories;

import School.Management.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT u from user u where u.name=?1")
    List<UserEntity> findByName(String param);

    @Query("SELECT u from user u where u.role=?1")
    List<UserEntity> findByRole(Integer param);

    @Query("SELECT u FROM user u WHERE u.username = :username")
    UserEntity findByUsername(
            @Param("username") String param
    );
}
