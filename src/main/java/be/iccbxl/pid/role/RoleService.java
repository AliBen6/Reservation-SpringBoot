package be.iccbxl.pid.role;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.resource.IService;

@Service
public class RoleService implements IService<Role> {

	private static final Logger LOG = LoggerFactory.getLogger(RoleService.class);

	
	@Autowired RoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public Optional<Role> findById(long id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

	@Override
	public Role save(@Valid Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role update(@Valid Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
