package be.iccbxl.pid.show;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.resource.IService;

@Service
public class ShowService implements IService<Show>{

	@Autowired
	private ShowDao showDao;
	
	@Override
	public List<Show> findAll() {
		// TODO Auto-generated method stub
		return showDao.findAll();
	}

	@Override
	public Optional<Show> findById(long id) {
		// TODO Auto-generated method stub
		return showDao.findById(id);
	}

	@Override
	public Show save(@Valid Show t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Show update(@Valid Show t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		return showDao.deleteById(id);
	}

}
