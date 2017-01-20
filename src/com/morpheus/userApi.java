package com.morpheus;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class userApi {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public User userList() {

		User u = new User();
		u.setName("Marcel");
		return u;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean userInsert(User u) {
		return true;
	}
	
}