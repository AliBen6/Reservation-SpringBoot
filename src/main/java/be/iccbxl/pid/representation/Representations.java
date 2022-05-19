package be.iccbxl.pid.representation;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//Class to store the list of
//all the representations in an
//Array List
@JacksonXmlRootElement
public class Representations{
	
	@JacksonXmlProperty(localName = "Representation")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Collection<Representation> representations = null;

	public Collection<Representation> getRepresentations() {
		if ( representations == null) {
      
			representations = new ArrayList<>();
		
		}

		return representations;

	}

	public void setRepresentation(Collection<Representation> collection) {
		this.representations =  collection;
	}
	
}