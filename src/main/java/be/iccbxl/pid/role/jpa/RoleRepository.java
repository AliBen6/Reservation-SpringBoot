package be.iccbxl.pid.role.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import be.iccbxl.pid.role.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
