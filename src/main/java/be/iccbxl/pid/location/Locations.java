package be.iccbxl.pid.location;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//Class to store the list of
//all the locations in an
//Array List
@JacksonXmlRootElement
public class Locations {

	@JacksonXmlProperty(localName = "Location")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Collection<Location> locations = null;

	public Collection<Location> getLocations() {
		if (locations == null) {

			locations = new ArrayList<>();

		}

		return locations;

	}

	public void setLocations(Collection<Location> collection) {
		this.locations = collection;
	}

}