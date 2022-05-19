package be.iccbxl.pid.locality.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.locality.Locality;
import be.iccbxl.pid.locality.LocalityDao;

@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class LocalityDatabaseJPA implements LocalityDao{

	@Autowired
	private LocalityRepository localityRepository;
	
	@Override
	public List<Locality> findAll() {
		// TODO Auto-generated method stub
		return localityRepository.findAll();
	}

	@Override
	public Optional<Locality> findById(long id) {
		// TODO Auto-generated method stub
		return localityRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		localityRepository.deleteById(id);
		return id;
	}

	@Override
	public Locality save(Locality t) {
		// TODO Auto-generated method stub
		return localityRepository.save(t);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return localityRepository.existsById(id);
	}

}
