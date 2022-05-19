package be.iccbxl.pid.resource;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IController<T> {
	
	
	@GetMapping
	ResponseEntity<?> findAll();
	
	@GetMapping("/{id}")
	ResponseEntity<T> findById(@PathVariable Long id);

	@PostMapping
	ResponseEntity<T> save(@Valid @NonNull @RequestBody T t);

	@PutMapping("/{id}")
	ResponseEntity<T> update(@PathVariable @Min(1) Long id,@Valid @NonNull @RequestBody T t);

	@PatchMapping("/{id}")
	ResponseEntity<T> patch(@PathVariable  @Min(1) Long id, @RequestBody Map<Object, Object> fields);

	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteById(@PathVariable @Min(1) Long id);

}