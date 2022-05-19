package be.iccbxl.pid.artist.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.artist.Artist;
import be.iccbxl.pid.artist.ArtistDao;

@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class ArtistDatabaseJPA implements ArtistDao {

	//@Autowired
	private ArtistRepository artistRepository;

	public ArtistDatabaseJPA(ArtistRepository artistRepository){
		this.artistRepository= artistRepository;
	}

	@Override
	public List<Artist> findAll() {
		// TODO Auto-generated method stub
		return artistRepository.findAll();
	}

	@Override
	public Optional<Artist> findById(long id) {
		// TODO Auto-generated method stub
		return artistRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		artistRepository.deleteById(id);
		return id;
	}

	@Override
	public Artist save(Artist artist) {
		// TODO Auto-generated method stub
		// return artistRepository.saveAndFlush(artist);
		return artistRepository.save(artist);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return artistRepository.existsById(id);
	}

}