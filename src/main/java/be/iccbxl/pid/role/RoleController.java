package be.iccbxl.pid.role;

import java.net.URI;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import be.iccbxl.pid.resource.IController;

@Validated
@RestController
@RequestMapping("api/Reservations/V1/roles")
public class RoleController implements IController<Role> {

	private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);

	
	@Autowired
	private RoleService roleService;
	
	@Override
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		Roles roles = new Roles();
		roles.setRoles(roleService.findAll());
		
		return ResponseEntity.ok(roles);
		
	}

	@Override
	public ResponseEntity<Role> findById(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.of(roleService.findById(id));
	}

	@Override
	public ResponseEntity<Role> save(@Valid Role t) {
		// TODO Auto-generated method stub
		Role createdRole = roleService.save(t);
    	
    	URI location = ServletUriComponentsBuilder
    						.fromCurrentRequest()
    						.path("/{id}")
    						.buildAndExpand(createdRole.getId())
    						.toUri();
        
    	return ResponseEntity.created(location).body(createdRole);
	}

	@Override
	public ResponseEntity<Role> update(@Min(1) Long id, @Valid Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Role> patch(@Min(1) Long id, Map<Object, Object> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteById(@Min(1) Long id) {
		// TODO Auto-generated method stub
		roleService.deleteById(id);
		LOG.info("Role with id:{} deleted",id);
    	return ResponseEntity.ok().build();   
	}
	

}
