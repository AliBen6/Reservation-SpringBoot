package be.iccbxl.pid.role.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.role.Role;
import be.iccbxl.pid.role.RoleDao;

@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class RoleDatabaseJPA implements RoleDao {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> findById(long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
		return id;
	}

	@Override
	public Role save(Role t) {
		// TODO Auto-generated method stub
		return roleRepository.save(t);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return roleRepository.existsById(id);
	}

}
