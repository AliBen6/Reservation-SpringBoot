package be.iccbxl.pid.representation;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.resource.IService;

@Service
public class RepresentationService implements IService<Representation>{
	
	@Autowired
	private RepresentationDao representationDao;

	@Override
	public List<Representation> findAll() {
		// TODO Auto-generated method stub
		return representationDao.findAll();
	}

	@Override
	public Optional<Representation> findById(long id) {
		// TODO Auto-generated method stub
		return representationDao.findById(id);
	}

	@Override
	public Representation save(@Valid Representation t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Representation update(@Valid Representation t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		return representationDao.deleteById(id);
	}
	
	

}
