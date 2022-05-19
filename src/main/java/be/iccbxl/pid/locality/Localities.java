package be.iccbxl.pid.locality;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


//Class to store the list of
//all the localities in an
//Array List
@JacksonXmlRootElement
public class Localities{
	
	@JacksonXmlProperty(localName = "Locality")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Collection<Locality> localities = null;

  public Collection<Locality> getLocalities() {
  	if (localities == null) {
          
  		localities = new ArrayList<>();
  		
      }

  	return localities;

  }

  public void setLocalities(Collection<Locality> collection) {
      this.localities =  collection;
  }
}
