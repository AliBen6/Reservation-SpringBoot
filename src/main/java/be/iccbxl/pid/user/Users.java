package be.iccbxl.pid.user;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//Class to store the list of
//all the users in an
//Array List
@JacksonXmlRootElement
public class Users{

	@JacksonXmlProperty(localName = "User")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Collection<User> users = null;

	public Collection<User> getUser() {
		if (users == null) {

			users = new ArrayList<>();

		}

		return users;

	}

	public void setUsers(Collection<User> collection) {
		this.users =  collection;
	}
	
}