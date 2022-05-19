package be.iccbxl.pid.artist;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import be.iccbxl.pid.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/Reservations/V1/artists")
@Validated
public class ArtistController {

	private static final Logger LOG = LoggerFactory.getLogger(ArtistController.class);

	@Autowired
	private ArtistService artistService;

	@GetMapping
	public ResponseEntity<List<Artist>> getAllArtist() {
		Artists artists = new Artists();
		artists.setArtists(artistService.getAllArtist());

		//return ResponseEntity.ok(artists);
		return ResponseEntity.ok(artistService.getAllArtist());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Artist> getArtistById(@PathVariable("id") @Min(1) long id) {

		return ResponseEntity.of(artistService.getArtistById(id));

	}

	@PostMapping
	public ResponseEntity<Artist> addArtist(@Valid @RequestBody Artist artist) {

		Artist createdArtist = artistService.addArtist(artist);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdArtist.getId()).toUri();

		return ResponseEntity.created(location).body(createdArtist);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Artist> updateArtistById(@PathVariable("id") @Min(1) long id,
			@Valid @NonNull @RequestBody Artist artist) {

		Artist artistToUpdate = artistService.getArtistById(id).get();
		artistToUpdate.setFirstname(artist.getFirstname());
		artistToUpdate.setLastname(artist.getLastname());
		artistService.updateArtist(artistToUpdate);

		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();

		return ResponseEntity.created(location).body(artistToUpdate);
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<String> updateArtistPartiallyById(@PathVariable("id") @Min(1) long id,
			@RequestBody Map<String, Object> fields) {

		Artist artistToPatch = artistService.getArtistById(id).get();

		Map<String, String> map = new HashMap<>();
		Field[] artistFields = Artist.class.getDeclaredFields();

		for (Field field : artistFields) {
			if (field.isAnnotationPresent(JsonProperty.class)) {
				String annotationValue = field.getAnnotation(JsonProperty.class).value();
				map.put(annotationValue, field.getName());
				System.out.println(map.toString());
			} else {
				map.put(field.getName(), field.getName());
				System.out.println(map.toString());

			}
		}

		fields.forEach((k, v) -> {
			String value;
			if (map.containsKey(k)) {
				value = map.get(k);
				// System.out.println("map key: "+map.get(k));
				System.out.println("map value: " + value);

				try {
					Field field = ReflectionUtils.findField(Artist.class, value);
					field.setAccessible(true);
					ReflectionUtils.setField(field, artistToPatch, (String) v);
				} catch (IllegalArgumentException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// adapt with approriate exception
				throw new ResourceNotFoundException("Field :" + k + " not valid");
			}
		});

		artistService.updateArtist(artistToPatch);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteArtistById(@PathVariable("id") @Min(1) long id) {

		artistService.deleteArtistById(id);
		LOG.info("Artist with id:{} deleted", id);
		return ResponseEntity.ok().build();

	}

}