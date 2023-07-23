package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.ArticlePojo;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
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
	
	@DELETE
	@Path("/{id}")
	public String deleteArticles(@PathParam("id") Integer id) { 
		System.out.println("deleteArticles est appelée avec l'id : " + id);
		return "Je supprime l'article, avec l'id : " + id;
	}

}
