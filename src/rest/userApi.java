package rest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;


@Path("/")
public class UserApi {	
	
	List<User> list = new ArrayList();		
	
	@POST
	@Path("/attachment")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({MediaType.APPLICATION_JSON})
	public Response attachment(File file) throws IOException {	
				
		FileInputStream receive = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(receive));
		
		String line = reader.readLine();
        while(line != null){
            line = reader.readLine();
            list.add(new User(line));
        }        
        String json = new Gson().toJson(list);
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/insert")
	public void insert(String name) {	
		
		list.add(new User(name));     

	}
	
	@GET
	@Path("/download")
	@Produces("text/plain")
	public Response list() throws IOException{
		
		String json = new Gson().toJson(list);
		File file =  File.createTempFile("nomes", ".txt"); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(json);
        writer.close();
		ResponseBuilder response = Response.ok(file);
		response.type("text/plain");
		return response.build();
				
	}
	
}