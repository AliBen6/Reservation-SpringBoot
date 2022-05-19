package be.iccbxl.pid.show.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import be.iccbxl.pid.show.Show;

public interface ShowRepository extends JpaRepository<Show , Long> {

}
