package rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String name;
	
	public User(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}