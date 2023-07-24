package fr.maboite.correction.rest.controller;

import fr.maboite.pojo.ArticlePojo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
	
	@GET
	@Path("articlePojo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArticlePojo getArticlePojo(@PathParam(value = "id") Integer id) {
		
		ArticlePojo ap = new ArticlePojo();
		
		ap.setId(id);
		ap.setName("ca marche");
		
		return ap;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArticlePojo postArticlePojo(ArticlePojo ap) {	
		ArticlePojo res = new ArticlePojo();
		res.setName(ap.getName());
		
		if(res.getId() == 0) {
			res.setId(ap.getId());
		}
		System.out.println("l'article a été crée");
		return res;
	}
	

}
