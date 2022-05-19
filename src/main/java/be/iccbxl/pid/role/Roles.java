package be.iccbxl.pid.role;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//Class to store the list of
//all the roles in an
//Array List
@JacksonXmlRootElement
public class Roles{
	
	@JacksonXmlProperty(localName = "Role")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Collection<Role> roles = null;

	public Collection<Role> getRoles() {
		if (roles == null) {
        
			roles = new ArrayList<>();
		
		}

		return roles;

	}

	public void setRoles(Collection<Role> collection) {
		this.roles =  collection;
	}

}
