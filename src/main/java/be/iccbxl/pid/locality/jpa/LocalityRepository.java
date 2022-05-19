package be.iccbxl.pid.locality.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.iccbxl.pid.locality.Locality;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long>  {

}
