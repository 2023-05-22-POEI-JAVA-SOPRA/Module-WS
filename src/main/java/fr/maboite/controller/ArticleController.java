package fr.maboite.controller;

import java.util.Random;

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
@Produces("application/json")
@Consumes("application/json")
public class ArticleController {

//	@GET // http://localhost:8080/poe-java-ws/rest/v1/articles/id
//	@Path("/{id}")
//	public ArticlePojo getById(@PathParam("id") Integer id) { // URL que traite cette méthode :
//		// URL application + URL de la classe + URL de la méthode
//		System.out.println("Article numéro " + id + " récupéré");
//		ArticlePojo article = new ArticlePojo();
//		article.setId(id);
//		article.setNom("Article numéro " + id);
//		return article;
//	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getByIdToText(@PathParam("id") Integer id) { // URL que traite cette méthode :
		// URL application + URL de la classe + URL de la méthode
		ArticlePojo article = new ArticlePojo();
		article.setId(id);
		article.setNom("Article numéro " + id);
		return article.toString();
	}

	@DELETE
	@Path("/{id}")
	public String delById(@PathParam("id") Integer id) { // URL que traite cette méthode :
		// URL application + URL de la classe + URL de la méthode
		System.out.println("Article numéro " + id + " supprimé");
		return "Suppression Article numéro " + id;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public ArticlePojo postArticle(ArticlePojo article) {
		if (article.getId() < 1) {
			Random random = new Random();
			int randomId = random.nextInt(1000) + 1;
			article.setId(randomId);
		}
		System.out.println("Article crée : " + article.toString());
		return article;
	}
}
