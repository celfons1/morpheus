package rest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

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
                
        File temp = File.createTempFile("nomes", ".txt");
		File save = new File(Paths.get(temp.getAbsolutePath()).getParent()+"\\nomes.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(save));
        writer.write(json);
        writer.close();
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/insert")
	public void insert(String name) throws IOException {
		
		list.add(new User(name));  
		String json = new Gson().toJson(list);
		
		File temp = File.createTempFile("nomes", ".txt");
		FileWriter fw = new FileWriter(Paths.get(temp.getAbsolutePath()).getParent()+"\\nomes.txt",true);
	    fw.write(json);
	    fw.close();
	}
	
	@GET
	@Path("/download")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public Response list() throws IOException{
		
		 StreamingOutput fileStream =  new StreamingOutput() 
	        {
	            @Override
	            public void write(java.io.OutputStream output) throws IOException, WebApplicationException 
	            {
	                try
	                {
	                	File temp = File.createTempFile("nomes", ".txt");
	                    java.nio.file.Path path = Paths.get(Paths.get(temp.getAbsolutePath()).getParent()+"\\nomes.txt");
	                    byte[] data = Files.readAllBytes(path);
	                    output.write(data);
	                    output.flush();
	                } 
	                catch (Exception e) 
	                {
	                    throw new WebApplicationException();
	                }
	            }
	        };
	        return Response
	                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
	                .header("content-disposition","attachment; filename = nomes.txt")
	                .build();
	    }
				
	
}