package be.iccbxl.pid.representation.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.iccbxl.pid.representation.Representation;

@Repository
public interface RepresentationRepository extends JpaRepository<Representation , Long>{

}
