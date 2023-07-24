package fr.maboite.controller;

import java.util.Random;

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
	
//	@GET
//	@Path("/{id}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getByIdToText(@PathParam("id") Integer id) { // URL que traite cette méthode :
//		// URL application + URL de la classe + URL de la méthode
//		ArticlePojo article = new ArticlePojo();
//		article.setId(id);
//		article.setNom("Article numéro " + id);
//		return article.toString();
//	}
	
	@GET // http://localhost:8080/poe-java-ws/rest/v1/articles/id
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer  id) { // URL que traite cette méthode :
		// URL application + URL de la classe + URL de la méthode
		if (id < 0) {
			return Response.status(Response.Status.NOT_FOUND)
					.header("newHeader", "header test")
					.entity("Id négatif")
					.build();
		}

		ArticlePojo articlePojo = new ArticlePojo();
		articlePojo.setId(id);
		articlePojo.setNom("Article avec l'id : " + id);
		
		return Response.ok(articlePojo).build();
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
	public ArticlePojo postArticle(@Valid ArticlePojo article) {
		if (article.getId() == null) {
			Random random = new Random();
			int randomId = random.nextInt(1000) + 1;
			article.setId(randomId);
		}
		System.out.println("Article crée : " + article.toString());
		return article;
	}
}
