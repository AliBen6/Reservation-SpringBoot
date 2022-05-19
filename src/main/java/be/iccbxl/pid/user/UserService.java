package be.iccbxl.pid.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.exception.ResourceNotFoundException;
import be.iccbxl.pid.resource.IService;

@Service
public class UserService implements IService<User> {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id)
    			.map(user -> userDao.findById(id))
    			.orElseThrow(()->new ResourceNotFoundException("User with id:"+id+" Not Found"));
	}

	@Override
	public User save(@Valid User t) {
		// TODO Auto-generated method stub
		User userCreated = userDao.save(t);
		return userCreated;
	}

	@Override
	public User update(@Valid User t) {
		// TODO Auto-generated method stub
		User userUpdated = userDao.save(t);
		return userUpdated;
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		if(userDao.existsById(id))
    		userDao.deleteById(id);
    	else
    		throw new ResourceNotFoundException("User with id:"+id+" Not Found");
        
    	return id;
	}

}
