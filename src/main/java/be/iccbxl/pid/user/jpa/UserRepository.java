package be.iccbxl.pid.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.iccbxl.pid.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
