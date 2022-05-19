package be.iccbxl.pid.location.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.location.Location;
import be.iccbxl.pid.location.LocationDao;

@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class LocationDatabaseJPA implements LocationDao{

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}

	@Override
	public Optional<Location> findById(long id) {
		// TODO Auto-generated method stub
		return locationRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		locationRepository.deleteById(id);
		return id;
	}

	@Override
	public Location save(Location t) {
		// TODO Auto-generated method stub
		return locationRepository.save(t);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return locationRepository.existsById(id);
	}

	
}
