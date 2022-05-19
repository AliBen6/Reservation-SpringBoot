package be.iccbxl.pid.show;

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
@RequestMapping("api/Reservations/V1/shows")
public class ShowController implements IController<Show> {
	
	@Autowired
	private ShowService showService;

	@Override
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		Shows shows = new Shows();
		shows.setShows(showService.findAll());
		return ResponseEntity.ok(shows);
	}

	@Override
	public ResponseEntity<Show> findById(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.of(showService.findById(id));
	}

	@Override
	public ResponseEntity<Show> save(@Valid Show t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Show> update(@Min(1) Long id, @Valid Show t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Show> patch(@Min(1) Long id, Map<Object, Object> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteById(@Min(1) Long id) {
		// TODO Auto-generated method stub
		showService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
