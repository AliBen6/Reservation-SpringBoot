package be.iccbxl.pid.type.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.type.Type;
import be.iccbxl.pid.type.TypeDao;


@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class TypeDatabaseJPA implements TypeDao{

	@Autowired
	private TypeRepository typeRepository;

	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		return typeRepository.findAll();
	}

	@Override
	public Optional<Type> findById(long id) {
		// TODO Auto-generated method stub
		return typeRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		typeRepository.deleteById(id);
		return id;
	}

	@Override
	public Type save(Type t) {
		// TODO Auto-generated method stub
		return typeRepository.save(t);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return typeRepository.existsById(id);
	}

}