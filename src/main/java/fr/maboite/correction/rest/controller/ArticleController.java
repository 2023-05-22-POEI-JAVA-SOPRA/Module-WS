package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.ArticlePojo;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/WebShop")

public class ArticleController {

	
	@GET
	public String Premethode(@PathParam("idArticle") Integer id) {
		System.out.println(id);
		return "article est appelé" ;

	}

	
	@GET
	@Path("/{idArticle}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getarticles(@PathParam("idArticle") Integer id) { 

		System.out.println("getarticles avec id: "+id);
		ArticlePojo articlePojo = new ArticlePojo();
		articlePojo.setIdArticle(id);
		articlePojo.setBrand("it's valid"+id);
		
		return Response.ok(articlePojo).build();

	}

	/*
	 * @GET
	 * 
	 * @Path("/{idArticle}")
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String
	 * getArticlesText(@PathParam("id") Integer id) {
	 * System.out.println("getArticles est appelée avec l'id : " + id); ArticlePojo
	 * articlePojo = new ArticlePojo(); articlePojo.setIdArticle(id);
	 * articlePojo.setBrand("Article avec la brande : " + id);
	 * 
	 * return articlePojo.toString(); }
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
