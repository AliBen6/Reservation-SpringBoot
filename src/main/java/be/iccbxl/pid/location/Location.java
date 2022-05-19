package be.iccbxl.pid.location;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import be.iccbxl.pid.locality.Locality;
import be.iccbxl.pid.representation.Representation;
import be.iccbxl.pid.show.Show;

@Entity
@Table(name="locations")
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(unique=true)
	private String slug;

	private String designation;
	
	private String address;
	
	@ManyToOne
	@JoinColumn(name="locality_id", nullable=false)
    @JsonIgnoreProperties("locations")
	private Locality locality;
	
	private String website;
	
	private String phone;

	@OneToMany(targetEntity=Show.class, mappedBy="location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	//@JsonIgnoreProperties("locality")
	private List<Show> shows = new ArrayList<>();
	
	@OneToMany(targetEntity=Representation.class, mappedBy="location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Representation> representations = new ArrayList<>();


	
	protected Location() {
		
	}
	
	public Location(String slug, String designation, String address, Locality locality, String website, String phone) {
		
		this.slug = slug;
		this.designation = designation;
		this.address = address;
		this.locality = locality;
		this.website = website;
		this.phone = phone;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality.removeLocation(this);	//déménager de l’ancienne localité
		this.locality = locality;
		this.locality.addLocation(this);		//emménager dans la nouvelle localité

	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<Show> getShows() {
		return shows;
	}

	public Location addShow(Show show) {
		if(!this.shows.contains(show)) {
			this.shows.add(show);
			show.setLocation(this);
		}
		
		return this;
	}
	
	public Location removeShow(Show show) {
		if(this.shows.contains(show)) {
			this.shows.remove(show);
			if(show.getLocation().equals(this)) {
				show.setLocation(null);
			}
		}
		
		return this;
	}

	public List<Representation> getRepresentations() {
		return representations;
	}

	public Location addRepresentation(Representation representation) {
		if(!this.representations.contains(representation)) {
			this.representations.add(representation);
			representation.setLocation(this);
		}
		
		return this;
	}
	
	public Location removeRepresentation(Representation representation) {
		if(this.representations.contains(representation)) {
			this.representations.remove(representation);
			if(representation.getLocation().equals(this)) {
				representation.setLocation(null);
			}
		}
		
		return this;
	}	
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", slug=" + slug + ", designation=" + designation + ", address=" + address
				+ ", locality=" + locality + ", website=" + website + ", phone=" + phone + ", shows=" + shows.size()
				+ ", representations=" + representations.size() + "]";
	}

	
	
}
