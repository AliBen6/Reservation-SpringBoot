package be.iccbxl.pid.type;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//Class to store the list of
//all the types in an
//Array List
@JacksonXmlRootElement
public class Types{
	
	@JacksonXmlProperty(localName = "Type")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Collection<Type> types = null;

public Collection<Type> getTypes() {
	if (types == null) {
        
		types = new ArrayList<>();
		
    }

	return types;

}

public void setTypes(Collection<Type> collection) {
    this.types =  collection;
}
}
