package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/articles")
public class ArticleController {

	@GET
	public String dummyMethod() {
		
		System.out.println("Articles get is called");
		return "Articles get is called !";
	}
	
	@GET
	@Path("/id/{id}")
	public String getMethod(@PathParam("id") Integer id )
	{
		System.out.println("article is called with id: " + id );
		return "article is called with id: " + id;
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
