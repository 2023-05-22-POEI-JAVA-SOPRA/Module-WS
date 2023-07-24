package fr.maboite.correction.rest.controller;


import fr.maboite.correction.rest.pojo.ArticlePojo;
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
public class ArticleController {

	
	

	@GET
	@Path("{id}")
	public Response getArticleById(@PathParam("id") Integer id) {
		System.out.println("coucou console Article Controller");
		
		if(id == null) {
			//je ne rentre jamais ici ?
			return Response.status(Response.Status.BAD_REQUEST)
					.header("mon_header", "coucou")
					.build();
		} else if (id < 0) {
			return Response.status(Response.Status.NOT_FOUND)
					.header("mon_header", "coucou 2")
					.build();	
		}
		
		
		ArticlePojo articlePojo = new ArticlePojo();
		articlePojo.setId(id);
		
		return Response.ok(articlePojo).build();
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
	public ArticlePojo postArticle(@Valid ArticlePojo article) {
		System.out.println("l'article est passé par post");
		System.out.println("id : " + article.getId() + ", name : "+ article.getName());
		
		if (article.getId() < 0) {
			System.out.println("l'article est passé par if négatif");	
		}
		
		
		if(article.getId() == null) {
			article.setId(1);
			System.out.println("ArticlePojo Id set à 1");
		}
		
		return article;
	}
	
	
	
	
	
	
}
