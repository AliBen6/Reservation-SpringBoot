package be.iccbxl.pid.type.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.iccbxl.pid.type.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long>  {

}
