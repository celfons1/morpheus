package rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
	public Response userFile(File file) throws IOException {	
		
		FileInputStream receive = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(receive));
		
		String line = reader.readLine();
        while(line != null){
            line = reader.readLine();
            System.out.println("{\"name\":"+line+"}");
        }        
        return Response.ok("{\"name\": \"Marcel\"}",MediaType.APPLICATION_JSON).build();
	}
}