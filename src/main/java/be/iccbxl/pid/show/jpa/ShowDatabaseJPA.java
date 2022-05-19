package be.iccbxl.pid.show.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.show.Show;
import be.iccbxl.pid.show.ShowDao;

@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class ShowDatabaseJPA implements ShowDao{

	@Autowired
	private ShowRepository showRepository;
	
	@Override
	public List<Show> findAll() {
		// TODO Auto-generated method stub
		return showRepository.findAll();
	}

	@Override
	public Optional<Show> findById(long id) {
		// TODO Auto-generated method stub
		return showRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		showRepository.deleteById(id);
		return id;
	}

	@Override
	public Show save(Show t) {
		// TODO Auto-generated method stub
		return showRepository.save(t);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return showRepository.existsById(id);
	}
	

}
