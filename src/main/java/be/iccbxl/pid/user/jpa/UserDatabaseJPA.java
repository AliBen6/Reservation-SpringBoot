package be.iccbxl.pid.user.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.user.User;
import be.iccbxl.pid.user.UserDao;

@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class UserDatabaseJPA implements UserDao {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return id;
	}

	@Override
	public User save(User t) {
		// TODO Auto-generated method stub
		return userRepository.save(t);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return userRepository.existsById(id);
	}

}
