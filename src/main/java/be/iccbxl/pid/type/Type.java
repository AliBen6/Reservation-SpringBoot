package be.iccbxl.pid.type;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import be.iccbxl.pid.artist.Artist;

@Entity
@Table(name="types")
public class Type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "type must not be empty")
	@Column(name = "type", nullable = false)
	@Size(min = 2,max = 30) 
	private String type;
	
	@ManyToMany
	@JoinTable(
		  name = "artist_type", 
		  joinColumns = @JoinColumn (name = "type_id"), 
		  inverseJoinColumns = @JoinColumn(name = "artist_id"))
	@JsonIgnoreProperties("types")
	private List<Artist> artists = new ArrayList<>();

	protected Type() { }
	
	public Type(Long id,String type) {
		this.id = id;
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public Type addArtist(Artist artist) {
		if(!this.artists.contains(artist)) {
			this.artists.add(artist);
			artist.addType(this);
		}
		
		return this;
	}
	
	public Type removeArtist(Artist artist) {
		if(this.artists.contains(artist)) {
			this.artists.remove(artist);
			artist.getTypes().remove(this);
		}
		
		return this;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + "]";
	}
	
}