package be.iccbxl.pid.locality;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import be.iccbxl.pid.exception.ResourceNotFoundException;
import be.iccbxl.pid.resource.IController;

@Validated
@RestController
@RequestMapping("api/Reservations/V1/localities")
public class LocalityController implements IController<Locality> {

	private static final Logger LOG = LoggerFactory.getLogger(LocalityController.class);

    @Autowired
    private LocalityService localityService;
	
	public ResponseEntity<Localities> findAll() {
		// TODO Auto-generated method stub
		Localities localities= new Localities();
    	localities.setLocalities(localityService.findAll());

		return ResponseEntity.ok(localities);	
	}

	@Override
	public ResponseEntity<Locality> findById(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.of(localityService.findById(id));
	}

	@Override
	public ResponseEntity<Locality> save(Locality t) {
		// TODO Auto-generated method stub
		Locality createdLocality = localityService.save(t);
    	
    	URI location = ServletUriComponentsBuilder
    						.fromCurrentRequest()
    						.path("/{id}")
    						.buildAndExpand(createdLocality.getId())
    						.toUri();
        
    	return ResponseEntity.created(location).body(createdLocality);	
    	
	}

	
	@Override
	public ResponseEntity<Locality> update(Long id, Locality t) {
		// TODO Auto-generated method stub
		Locality localityToUpdate = localityService.findById(id).get();
	    localityToUpdate.setLocality(t.getLocality());
	    localityToUpdate.setPostalCode(t.getPostalCode());
		localityService.update(localityToUpdate);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
		
		return ResponseEntity.created(location).body(localityToUpdate);
	}
	
	
	@Override
	public ResponseEntity<Locality> patch(Long id, Map<Object, Object> fields) {
		// TODO Auto-generated method stub
		Locality localityToPatch = localityService.findById(id).get();
        
    	Map<String, String> map = new HashMap<>();
        Field[] localityFields = Locality.class.getDeclaredFields();
        
        for (Field field : localityFields) {
            if (field.isAnnotationPresent(JsonProperty.class)) {
                String annotationValue = field.getAnnotation(JsonProperty.class).value();
                map.put(annotationValue, field.getName());
                System.out.println(map.toString());
            }
            else
            {
            	map.put(field.getName(), field.getName());
            	System.out.println(map.toString());
        
            }
        }
        
    	fields.forEach((k,v)-> {
    		String value;
    		if(map.containsKey(k))
        	{
    			value=map.get(k);
    			//System.out.println("map key: "+map.get(k));
    			System.out.println("map value: "+value);
        		
        		try {
            		Field field = ReflectionUtils.findField(Locality.class, value );
            		field.setAccessible(true);
            		ReflectionUtils.setField(field, localityToPatch, (String) v);
				} catch (IllegalArgumentException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	else
        	{
        		//a adapter avec la bonne exception
        		throw new ResourceNotFoundException("Field :"+k+ " not valid");
        	}
    	}
    	);

        localityService.update(localityToPatch);
    	URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
		
		return ResponseEntity.created(location).build();
	}

	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		// TODO Auto-generated method stub
		
		localityService.deleteById(id);
    	LOG.info("Locality with id:{} deleted",id);
    	return ResponseEntity.ok().build();    
	
	}

}