package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.ArticlePojo;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/articles")
@Produces("application/json") //par defaut
public class ArticleController {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String get(ArticlePojo articlePojo) {
		System.out.println(articlePojo);
		return articlePojo.toString();
	}
	
	@GET
	@Path("/{paramRest}")
	public Response methodeTest(@PathParam("paramRest") Integer id) {
		System.out.println("Article avrc id: " + id + " appele");
		if (id < 0) {
			return Response.status(Status.NOT_FOUND).entity("{'error': 'not found'}").build();
		} else {
			ArticlePojo ap = new ArticlePojo();
			ap.setId(id);
			return Response.ok(ap).build();
		}
		
	}
	
	@DELETE
	@Path("/{paramRest}")
	public int delete(@PathParam("paramRest") Integer id) {
		System.out.println("id:" + id);
		return id;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public ArticlePojo post(ArticlePojo articlePojo) {
		if (articlePojo.getId() == null) 
			articlePojo.setId();
		return articlePojo;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response add(@Valid ArticlePojo articlePojo) {
		return Response.ok(articlePojo).build();
	}
	
}
