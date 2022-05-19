package be.iccbxl.pid.artist;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import be.iccbxl.pid.exception.ResourceNotFoundException;

@Service
@Validated
public class ArtistService {

	private static final Logger LOG = LoggerFactory.getLogger(ArtistService.class);

	@Autowired
	private ArtistDao artistDao;

	/*
	 * @Autowired private ArtistDaoProducer artistDaoProducer;
	 */

	public List<Artist> getAllArtist() {

		return artistDao.findAll();

	}

	// @Cacheable("Artist")
	public Optional<Artist> getArtistById(long id) {
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		return artistDao.findById(id).map(artist -> artistDao.findById(id))
				.orElseThrow(() -> new ResourceNotFoundException("Artist with id:" + id + " Not Found"));

	}

	public Artist addArtist(@Valid Artist artist) {

		Artist artistCreated = artistDao.save(artist);

		LOG.info("Artist created :" + artistCreated);
		// artistDAOProducer.sendNewArtist(artistInserted).orElse(artist));

		return artistCreated;

	}

	public Artist updateArtist(@Valid Artist artist) {

		return artistDao.save(artist);

	}

	public long deleteArtistById(long id) {

		if (artistDao.existsById(id))
			artistDao.deleteById(id);
		else
			throw new ResourceNotFoundException("Artist with id:" + id + " Not Found");

		return id;

	}

}