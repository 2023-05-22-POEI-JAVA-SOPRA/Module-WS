package fr.maboite.correction.rest.controller;

import java.util.Locale;

import fr.maboite.correction.rest.controller.rest.pojo.ArticlePojo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON) // returned MIME type by default
//@Consumes()    //input MIME type by default
public class ArticleController {

	@GET
	public String dummyMethod() {

		System.out.println("Articles get is called");
		return "Articles get is called !";
	}

	@GET
	@Path("/id/{id}")
//Reassigned the MIME type
	public Response getMethod(@PathParam("id") Integer id) {
		System.out.println("article is called with id: " + id);
		if (id < 0) {
			return Response.status(Response.Status.NOT_FOUND).entity("{'cause': 'not found id is negative'}").type(MediaType.APPLICATION_JSON).header("typeOfInputMIME","json").header("typeOfOutputMIME", "json").build();
		}

		ArticlePojo artpojo = new ArticlePojo(id, "Article " + id, "Brand" + id, id * 20);
		return Response.ok(artpojo, MediaType.APPLICATION_JSON).build();

	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.TEXT_PLAIN) // Reassigned the MIME type
	public Response getMethodTextPlain(@PathParam("id") Integer id) {

		System.out.println("article is called with id: " + id);
		if (id <= 0)
			return Response.status(Response.Status.NOT_FOUND).entity("{'cause': 'not found id is negative tp'}")/*.type(MediaType.TEXT_PLAIN)*/.header("typeOfInputMIME","tp").header("typeOfOutputMIME", "json").build();

		ArticlePojo artPojoToGet = new ArticlePojo(id, "Article " + id, "Brand" + id, id * 20);
		
		return Response.ok(artPojoToGet.toString(), MediaType.TEXT_PLAIN).build();
//		return " Text plain : " +  new ArticlePojo(id,"Article " + id,"Brand"+id ,id*20).toString();

	}

	@DELETE
	@Path("/id/{id}")
	public String deleteMethod(@PathParam("id") Integer id) {
		System.out.println("delete article " + id);
		return "delete article whith id: " + id;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postMethod(ArticlePojo articlePojo) {
		System.out.println("Article pojo created" + articlePojo);
		if (articlePojo.getId() == null) {
			articlePojo.setId();
		}
		return Response.ok(articlePojo, MediaType.APPLICATION_JSON).status(Response.Status.CREATED).build();
	}

//	@POST
//	@Path("/id/{param}")
//	public String  postMethod(@PathParam("param") String param)
//	{
//		System.out.println("post article " + param) ;
//		
//	
//		return "post article whith id: " + param ;
//	}
	@PUT
	@Path("/id/{param}")
	public String putMethod(@PathParam("param") String param) {
		System.out.println("modify article  " + param);
		return "modify article whith id: " + param;
	}

}
