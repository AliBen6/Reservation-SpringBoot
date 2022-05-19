package be.iccbxl.pid.show;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//Class to store the list of
//all the shows in an
//Array List
@JacksonXmlRootElement
public class Shows{
	
	@JacksonXmlProperty(localName = "Show")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Collection<Show> shows = null;

	public Collection<Show> getShows() {
		if (shows == null) {
      
			shows = new ArrayList<>();
		
		}

		return shows;

	}

	public void setShows(Collection<Show> collection) {
		this.shows =  collection;
	}
	
}