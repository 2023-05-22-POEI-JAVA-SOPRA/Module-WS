package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.controller.rest.pojo.ArticlePojo;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON)//returned MIME type by default
//@Consumes()    //input MIME type by default
public class ArticleController {

	@GET
	public String dummyMethod() {
		
		System.out.println("Articles get is called");
		return "Articles get is called !";
	}
	
	@GET
	@Path("/id/{id}")
//	@Produces("text/plain") //Reassigned the MIME type
	public ArticlePojo getMethod(@PathParam("id") Integer id )
	{
		System.out.println("article is called with id: " + id );
		
		return new ArticlePojo(id,"Article " + id,"Brand"+id ,id*20);
		
	}
	
	@DELETE
	@Path("/id/{id}")
	public String deleteMethod(@PathParam("id") Integer id) {
		System.out.println("delete article " + id) ;
		return "delete article whith id: " + id ;
	}
	
	@POST
	@Path("/id/{param}")
	public String  postMethod(@PathParam("param") String param)
	{
		System.out.println("post article " + param) ;
		return "post article whith id: " + param ;
	}
	@PUT
	@Path("/id/{param}")
	public String  putMethod(@PathParam("param") String param)
	{
		System.out.println("modify article  " + param) ;
		return "modify article whith id: " + param ;
	}
	
	
}
