package rest;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class UserApi {	
	@POST
	@Path("/post")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({MediaType.APPLICATION_JSON})
	public Response userFile(File file) {	
        return Response.ok("{\"name\": \"Marcel\"}",MediaType.APPLICATION_JSON).build();
	}
}