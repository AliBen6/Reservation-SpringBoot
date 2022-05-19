package be.iccbxl.pid.locality;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.exception.ResourceNotFoundException;

@Service
public class LocalityService {

	private static final Logger LOG = LoggerFactory.getLogger(LocalityService.class);
	
	@Autowired
	private LocalityDao localityDao;
	
	public List<Locality> findAll() {
    	
		return localityDao.findAll();
    
    }
    
    //@Cacheable("Locality")
    public Optional<Locality> findById(long id) {
    	/*
    	try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	 */
    	return localityDao.findById(id)
    			.map(locality -> localityDao.findById(id))
    			.orElseThrow(()->new ResourceNotFoundException("Locality with id:"+id+" Not Found"));

    }
    
    
    public Locality save(@Valid Locality locality) {
    	
    	Locality localityCreated = localityDao.save(locality);
  
        return localityCreated;

    }
    
    
    public Locality update(@Valid Locality locality){
    
    	return localityDao.save(locality);
    
    }

    
    public long deleteById(long id) {
    
    	if(localityDao.existsById(id))
    		localityDao.deleteById(id);
    	else
    		throw new ResourceNotFoundException("Locality with id:"+id+" Not Found");
        
    	return id;
    
    }

}