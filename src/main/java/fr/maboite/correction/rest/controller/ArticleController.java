package fr.maboite.correction.rest.controller;

import java.util.Random;

import fr.maboite.correction.rest.pojo.ArticlePojo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleController {
	
	@GET
	public String getArticles() { 
		System.out.println("getArticles est appelée");
		return "Voici de beaux articles";
	}
	
	@GET
	@Path("/{id}")
	public ArticlePojo getArticles(@PathParam("id") Integer id) { 
		System.out.println("getArticles est appelée avec l'id : " + id);
		ArticlePojo articlePojo = new ArticlePojo();
		articlePojo.setId(id);
		articlePojo.setNom("Article avec l'id : " + id);
		
		return articlePojo;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getArticlesText(@PathParam("id") Integer id) {
		System.out.println("getArticles est appelée avec l'id : " + id);
		ArticlePojo articlePojo = new ArticlePojo();
		articlePojo.setId(id);
		articlePojo.setNom("Article avec l'id : " + id);

		return articlePojo.toString();
	}

	@DELETE
	@Path("/{id}")
	public String deleteArticles(@PathParam("id") Integer id) { 
		System.out.println("deleteArticles est appelée avec l'id : " + id);
		return "Je supprime l'article, avec l'id : " + id;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public ArticlePojo sauvegarde(ArticlePojo articlePojo) {
		System.out.println("L'article :  " + articlePojo + " a été soumis par POST.");
		if (articlePojo.getId() == null) {
			articlePojo.setId(new Random().nextInt());
		}
		return articlePojo;
	}

}
