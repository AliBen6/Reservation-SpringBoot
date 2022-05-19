package be.iccbxl.pid.location;

import java.net.URI;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import be.iccbxl.pid.resource.IController;

@Validated
@RestController
@RequestMapping("api/Reservations/V1/locations")
public class LocationController implements IController<Location> {

	@Autowired
	private LocationService locationService;

	@Override
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		Locations locations = new Locations();
		locations.setLocations(locationService.findAll());
		
		return ResponseEntity.ok(locations);
	}

	@Override
	public ResponseEntity<Location> findById(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.of(locationService.findById(id));
	}

	@Override
	public ResponseEntity<Location> save(@Valid Location t) {
		// TODO Auto-generated method stub
		Location createdLocation = locationService.save(t);
    	
    	URI location = ServletUriComponentsBuilder
    						.fromCurrentRequest()
    						.path("/{id}")
    						.buildAndExpand(createdLocation.getId())
    						.toUri();
        
    	return ResponseEntity.created(location).body(createdLocation);
	}

	@Override
	public ResponseEntity<Location> update(@Min(1) Long id, @Valid Location t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Location> patch(@Min(1) Long id, Map<Object, Object> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteById(@Min(1) Long id) {
		// TODO Auto-generated method stub
		locationService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
