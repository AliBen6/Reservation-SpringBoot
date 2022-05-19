package be.iccbxl.pid.location;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.resource.IService;

@Service
public class LocationService implements IService<Location> {

	private static final Logger LOG = LoggerFactory.getLogger(LocationService.class);

	@Autowired
	private LocationDao locationDao;

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return locationDao.findAll();
	}

	@Override
	public Optional<Location> findById(long id) {
		// TODO Auto-generated method stub
		return locationDao.findById(id);
	}

	@Override
	public Location save(@Valid Location t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location update(@Valid Location t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		return locationDao.deleteById(id);
	}

}
