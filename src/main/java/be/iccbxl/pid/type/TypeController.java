package be.iccbxl.pid.type;

import java.net.URI;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Validated
@RestController
@RequestMapping("api/Reservations/V1/types")
public class TypeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TypeController.class);

    @Autowired
    private TypeService typeService;

    @GetMapping
    public ResponseEntity<Types> getAllType() {
    	
    	Types types = new Types();
    	types.setTypes(typeService.findAll());
    	
    	return ResponseEntity.ok(types);
    
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Type> getTypeById(
            @PathVariable("id")@Min(1) long id) {
    	
    	return ResponseEntity.of(typeService.findById(id));
    	
    }
    
    @PostMapping
    public ResponseEntity<Type> addType(
    		@Valid @RequestBody Type type) {
    	
    	Type createdType = typeService.save(type);
        	
    	URI location = ServletUriComponentsBuilder
    						.fromCurrentRequest()
    						.path("/{id}")
    						.buildAndExpand(createdType.getId())
    						.toUri();
        
    	return ResponseEntity.created(location).body(createdType);
    	
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Type> updateTypeById(
            @PathVariable("id")@Min(1) long id,
            @Valid @NonNull @RequestBody Type type) {
    	
    	Type typeToUpdate = typeService.findById(id).get();
        typeToUpdate.setType(type.getType());
        typeService.update(typeToUpdate);
    	
    	URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
		
		return ResponseEntity.created(location).body(typeToUpdate);
    }    
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTypeById(
            @PathVariable("id")@Min(1) long id) {
    	
    	typeService.deleteById(id);
    	LOG.info("Type with id:{} deleted",id);
    	return ResponseEntity.ok().build();      

    }

}
