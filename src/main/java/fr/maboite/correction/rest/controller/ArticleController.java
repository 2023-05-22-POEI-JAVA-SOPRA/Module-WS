package fr.maboite.correction.rest.controller;

import java.util.Random;

import fr.maboite.correction.rest.pojo.ArticleRestDto;
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

@Path("/articlesssss")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleController {
	
	@GET
	public String getArticles() { 
		System.out.println("getArticles est appelée");
		return "Voici de beaux articles";
	}
	
	@GET
	@Path("/{id}")
	public Response getArticles(@PathParam("id") Integer id) {
		System.out.println("getArticles est appelée avec l'id : " + id);
		if (id < 0) {
			return Response.status(Response.Status.NOT_FOUND)
					.build();
		}

		ArticleRestDto articlePojo = new ArticleRestDto();
		articlePojo.setIdArticle(id);
		articlePojo.setDescription("Article avec l'id : " + id);
		
		return Response.ok(articlePojo).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getArticlesText(@PathParam("id") Integer id) {
		System.out.println("getArticles est appelée avec l'id : " + id);
		ArticleRestDto articlePojo = new ArticleRestDto();
		articlePojo.setIdArticle(id);
		articlePojo.setDescription("Article avec l'id : " + id);

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
	public ArticleRestDto sauvegarde(@Valid ArticleRestDto articlePojo) {
		System.out.println("L'article :  " + articlePojo + " a été soumis par POST.");
		if (articlePojo.getIdArticle() == null) {
			articlePojo.setIdArticle(new Random().nextInt());
		}
		return articlePojo;
	}

}