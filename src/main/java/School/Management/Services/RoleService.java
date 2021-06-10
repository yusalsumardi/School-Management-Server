package School.Management.Services;

import School.Management.Entities.Role;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface RoleService {
    public List<Role> findAll();
}
