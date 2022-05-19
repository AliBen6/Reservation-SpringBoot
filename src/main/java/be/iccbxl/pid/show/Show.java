package be.iccbxl.pid.show;

import java.time.LocalDateTime;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import be.iccbxl.pid.artisttype.ArtistType;
import be.iccbxl.pid.location.Location;
import be.iccbxl.pid.representation.Representation;

@Entity
@Table(name="shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(unique=true)
	private String slug;

	private String title;
	
	private String description;

	@Column(name="poster_url")
	private String posterUrl;
	
	/**
	 * Lieu de création du spectacle
	 */
	@ManyToOne
	@JoinColumn(name="location_id", nullable=true)
	@JsonIgnoreProperties("shows")
	private Location location;
	
	private boolean bookable;
	
	private double price;
	
	/**
	 * Date de création du spectacle
	 */
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	/**
	 * Date de modification du spectacle
	 */
	@Column(name="updated_at")
	private LocalDateTime updatedAt;

	@OneToMany(targetEntity=Representation.class, mappedBy="show", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Representation> representations = new ArrayList<>();
	
	@ManyToMany(mappedBy = "shows")
	@JsonIgnoreProperties("shows")
	private List<ArtistType> artistTypes = new ArrayList<>();
	
	public Show() { }
	
	public Show(String title, String description, String posterUrl, Location location, boolean bookable,
			double price) {
		//Slugify slg = new Slugify();
		
		//this.slug = slg.slugify(title);
		this.title = title;
		this.description = description;
		this.posterUrl = posterUrl;
		this.location = location;
		this.bookable = bookable;
		this.price = price;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = null;
	}


	public Long getId() {
		return id;
	}

	public String getSlug() {
		return slug;
	}

	private void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		
		//Slugify slg = new Slugify();
		
		//this.setSlug(slg.slugify(title));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location.removeShow(this);	//déménager de l’ancien lieu
		this.location = location;
		this.location.addShow(this);		//emménager dans le nouveau lieu
	}

	public boolean isBookable() {
		return bookable;
	}

	public void setBookable(boolean bookable) {
		this.bookable = bookable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public List<Representation> getRepresentations() {
		return representations;
	}

	public Show addRepresentation(Representation representation) {
		if(!this.representations.contains(representation)) {
			this.representations.add(representation);
			representation.setShow(this);
		}
		
		return this;
	}
	
	public Show removeRepresentation(Representation representation) {
		if(this.representations.contains(representation)) {
			this.representations.remove(representation);
			if(representation.getLocation().equals(this)) {
				representation.setLocation(null);
			}
		}
		
		return this;
	}
	
	public List<ArtistType> getArtistTypes() {
		return artistTypes;
	}

	public Show addArtistType(ArtistType artistType) {
		if(!this.artistTypes.contains(artistType)) {
			this.artistTypes.add(artistType);
			artistType.addShow(this);
		}
		
		return this;
	}
	
	public Show removeArtistType(ArtistType artistType) {
		if(this.artistTypes.contains(artistType)) {
			this.artistTypes.remove(artistType);
			artistType.getShows().remove(this);
		}
		
		return this;
	}


	@Override
	public String toString() {
		return "Show [id=" + id + ", slug=" + slug + ", title=" + title 
			+ ", description=" + description + ", posterUrl=" + posterUrl + ", location=" 
			+ location + ", bookable=" + bookable + ", price=" + price
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt 
			+ ", representations=" + representations.size() + "]";
	}

	
}
