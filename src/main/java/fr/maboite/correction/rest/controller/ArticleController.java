package fr.maboite.correction.rest.controller;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
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
@Produces("application/json")
public class ArticleController {

	
	

	@GET
	@Path("/{id}")
	public ArticlePojo getArticleById(@PathParam("id") Integer id) {
		System.out.println("coucou console Article Controller");
		ArticlePojo articlePojo = new ArticlePojo();
		articlePojo.setId(id);
		
		return articlePojo;
	}
	@DELETE
	@Path("first")
	public String methodeArticleFirstDelete() {
		System.out.println("coucou console Article Controller delete");
		return "coucou ArticleController delete";
	}
	
	
	@GET
	@Path("second/{id}")
	public String methodeArticleSecond(@PathParam("id") Integer id) {
		System.out.println(id);
		return "coucou id = " + id;
	}
	


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("post")
	public ArticlePojo postArticle(ArticlePojo article) {
		System.out.println("l'article est passé par post");
		System.out.println("id : " + article.getId() + ", name : "+ article.getName());
		if(article.getId() == 0) {
			article.setId(1);
			System.out.println("ArticlePojo Id set à 1");
		}
		
		return article;
	}
	
	
	
	
	
	
}
