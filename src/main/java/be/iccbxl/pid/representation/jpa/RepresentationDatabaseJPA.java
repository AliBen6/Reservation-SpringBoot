package be.iccbxl.pid.representation.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.representation.Representation;
import be.iccbxl.pid.representation.RepresentationDao;

@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class RepresentationDatabaseJPA implements RepresentationDao {
	
	@Autowired
	private RepresentationRepository representationRepository;

	@Override
	public List<Representation> findAll() {
		// TODO Auto-generated method stub
		return representationRepository.findAll();
	}

	@Override
	public Optional<Representation> findById(long id) {
		// TODO Auto-generated method stub
		return representationRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		representationRepository.deleteById(id);
		return id;
	}

	@Override
	public Representation save(Representation t) {
		// TODO Auto-generated method stub
		return representationRepository.save(t);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return representationRepository.existsById(id);
	}
	
	

}
