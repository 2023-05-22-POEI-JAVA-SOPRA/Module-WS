package fr.maboite.correction.rest.controller;

import fr.maboite.pojo.ArticlePojo;
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
public class ArticleController {
	
	@GET
	public String mesArticles() { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
		System.out.println("Affichage des articles");
		return "Bienvenue sur la page article";
	}
	@GET
	@Path("/{id}")
	public String getArticleById(@PathParam(value = "id") Integer id) {
		System.out.println(id);
		return "ca marche voici l'id: " +id;
	}
	@DELETE
	@Path("/{id}")
	public String deleteArticleById(@PathParam(value = "id") Integer id) {
		System.out.println(id);
		return "ca marche l'article à l'id " +id+" a été supprimé";
	}
	
//	@GET
//	@Path("articlePojo/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArticlePojo getArticlePojo(@PathParam(value = "id") Integer id) {
//		
//		ArticlePojo ap = new ArticlePojo();
//		
//		ap.setId(id);
//		ap.setName("je suis un article en json");
//		
//		return ap;
//	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArticlePojo postArticlePojo(@Valid ArticlePojo ap) {	

		if(ap.getId() == null) {
			ap.setCounterId();
		}
		System.out.println("l'article a été crée avec l'id " + ap.getId());
		return ap;
	}
	
//	@GET
//	@Path("articlePojo/{id}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getArticlePojoText(@PathParam(value = "id") Integer id) {
//		
//		ArticlePojo ap = new ArticlePojo();
//		
//		ap.setId(id);
//		ap.setName("je suis un article en texte");
//		
//		return ap.toString();
//	}
//	
	@GET
	@Path("articlePojo/{id}")
	
	public Response getArticlePojoResponse(@PathParam(value = "id") Integer id) {
		
		ArticlePojo ap = new ArticlePojo();
		
		if(id < 0 ) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		ap.setId(id);
		ap.setName("je suis un article");
		
		return Response.ok(ap).build();
	}
	

}
