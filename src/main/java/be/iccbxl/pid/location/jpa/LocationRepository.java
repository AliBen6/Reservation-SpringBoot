package be.iccbxl.pid.location.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.iccbxl.pid.location.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
