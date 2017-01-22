package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class userApi {	
	@POST
	@Path("/post")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response userFile(@FormParam("data") FileUploadForm data) {
		/*try {
		      FileReader arq = new FileReader(file);
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine();
		      while (linha != null) {
		        System.out.printf("%s\n", linha);
		        linha = lerArq.readLine();
		      }
		 
		      arq.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }*/
		return Response.ok("{\"name\": \"Marcel\"}", MediaType.APPLICATION_JSON).build();
	}
}