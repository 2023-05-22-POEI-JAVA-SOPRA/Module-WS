package fr.maboite.correction.rest.controller;

import fr.maboite.correction.jpa.entity.Article;
import fr.maboite.correction.rest.pojo.ArticlePojo;
import fr.maboite.correction.rest.pojo.ArticleRestDto;
import fr.maboite.correction.service.ArticleService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/WebShop")

public class ArticleController {

	private ArticleService service = new ArticleService();
	
	@GET
	public String Premethode(@PathParam("idArticle") Integer id) {
		System.out.println(id);
		return " article est appele " ;

	}
	
	@GET
	@Path("/{idArticle}")
	public Response getById(@PathParam("idArticle") Integer id) {
		Article a = service.getById(id);
		if (a == null) {
			return Response.status(Status.NOT_FOUND).entity("Article not found").type(MediaType.TEXT_PLAIN).build();
		} else {
			return Response.ok(new ArticleRestDto(a)).build();
		}
	}
	
	
	 
	  
	  
	/*
	 * @GET
	 * 
	 * @Path("/{idArticle}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getarticles(@PathParam("idArticle") Integer id) {
	 * 
	 * System.out.println("getarticles avec id: "+id); ArticlePojo articlePojo = new
	 * ArticlePojo(); articlePojo.setIdArticle(id);
	 * articlePojo.setBrand("it's valid :"+id);
	 * 
	 * return Response.ok(articlePojo).build();
	 * 
	 * }
	 */
	 


	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String sauvegarde(@Valid ArticlePojo articlePojo) {
		System.out.println("L'article :  " + articlePojo + " a été soumis par POST.");
		if (articlePojo.getBrand().equals("Rolex")||articlePojo.getBrand().equals("Ferrari")||articlePojo.getBrand().equals("Marque repere") ) {
			return "le prix peut dépasser 500";
		}
		else {
			return "le prix doit être inférieur à 500€";
		}
	}
	
	
}
