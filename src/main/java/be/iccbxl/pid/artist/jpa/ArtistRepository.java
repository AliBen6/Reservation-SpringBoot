package be.iccbxl.pid.artist.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.iccbxl.pid.artist.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}