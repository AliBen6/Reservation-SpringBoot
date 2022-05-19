package be.iccbxl.pid.representation;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.iccbxl.pid.resource.IController;

@Validated
@RestController
@RequestMapping("api/Reservations/V1/representations")
public class RepresentationController implements IController<Representation>{
	
	@Autowired
	private RepresentationService representationService;

	@Override
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		Representations representations = new Representations();
		representations.setRepresentation(representationService.findAll());
		return ResponseEntity.ok(representations);
	}

	@Override
	public ResponseEntity<Representation> findById(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.of(representationService.findById(id));
	}

	@Override
	public ResponseEntity<Representation> save(@Valid Representation t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Representation> update(@Min(1) Long id, @Valid Representation t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Representation> patch(@Min(1) Long id, Map<Object, Object> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteById(@Min(1) Long id) {
		// TODO Auto-generated method stub
		representationService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	
}
