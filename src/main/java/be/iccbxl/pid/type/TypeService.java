package be.iccbxl.pid.type;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.exception.ResourceNotFoundException;
import be.iccbxl.pid.resource.IService;

@Service
public class TypeService implements IService<Type>{

	private static final Logger LOG = LoggerFactory.getLogger(TypeService.class);

	@Autowired
	private TypeDao typeDao;
	
	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		return typeDao.findAll();
	}

	//@Cacheable("Type")
	@Override
	public Optional<Type> findById(long id) {
		// TODO Auto-generated method stub
		return typeDao.findById(id)
    			.map(type -> typeDao.findById(id))
    			.orElseThrow(()->new ResourceNotFoundException("Type with id:"+id+" Not Found"));
	}


	@Override
	public Type save(@Valid Type t) {
		// TODO Auto-generated method stub
		Type typeCreated = typeDao.save(t);

	    //TypeDAOProducer.sendNewType(typeCreated).orElse(t));
	        
	    return typeCreated;
	}


	@Override
	public Type update(@Valid Type t) {
		// TODO Auto-generated method stub
		return typeDao.save(t);
	}


	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		if(typeDao.existsById(id))
    		typeDao.deleteById(id);
    	else
    		throw new ResourceNotFoundException("Type with id:"+id+" Not Found");
        
    	return id;
	}

}
