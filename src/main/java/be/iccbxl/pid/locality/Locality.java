package be.iccbxl.pid.locality;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import be.iccbxl.pid.location.Location;


@Entity
@Table(name="localities")
public class Locality {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "The postal code must not be empty.")
	@Size(max=6, message = "The postal cannot exceed 6 characters long.")
	private String postalCode;
	
	@NotEmpty(message = "The locality must not be empty.")
	@Size(max=60, message = "The locality cannot exceed 60 characters long.")
	private String locality;
	
	
	@OneToMany( targetEntity=Location.class, mappedBy="locality", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonIgnore
	//@JsonIgnoreProperties("locality")
	private List<Location> locations = new ArrayList<>();

	
	protected Locality() {	}

	public Locality(String postalCode, String locality) {
		this.postalCode = postalCode;
		this.locality = locality;
	}

	public Long getId() {
		return id;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getLocality() {
		return locality;
	}
	
	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	public List<Location> getLocations() {
		return locations;
	}

	public Locality addLocation(Location location) {
		if(!this.locations.contains(location)) {
			this.locations.add(location);
			location.setLocality(this);
		}
		
		return this;
	}
	
	public Locality removeLocation(Location location) {
		if(this.locations.contains(location)) {
			this.locations.remove(location);
			if(location.getLocality().equals(this)) {
				location.setLocality(null);
			}
		}
		
		return this;
	}

	
	@Override
	public String toString() {
		return "Locality [id=" + id + ", postalCode=" + postalCode + ", locality=" + locality + "]";
	}
	
}
