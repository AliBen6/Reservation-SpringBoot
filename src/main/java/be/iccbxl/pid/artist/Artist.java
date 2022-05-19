package be.iccbxl.pid.artist;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import be.iccbxl.pid.type.Type;

@Entity
@Table(name = "artists")
// @JacksonXmlRootElement(localName = "Artist")
// @Cache(region = "artistsCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "The firstname must not be empty.")
	@Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.")
	// @JsonProperty("firstName")
	private String firstname;

	@NotEmpty(message = "The lastname must not be empty.")
	@Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.")
	// @JsonProperty("lastName")
	private String lastname;

	@ManyToMany(mappedBy = "artists")
	@JsonIgnoreProperties("artists")
	private List<Type> types = new ArrayList<>();

	protected Artist() {
	}

	public Artist(long id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Type> getTypes() {
		return types;
	}

	public Artist addType(Type type) {
		if (!this.types.contains(type)) {
			this.types.add(type);
			type.addArtist(this);
		}

		return this;

	}

	public Artist removeType(Type type) {
		if (this.types.contains(type)) {
			this.types.remove(type);
			type.addArtist(this);
		}

		return this;

	}

	@Override
	public String toString() {
		return "Artist [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}