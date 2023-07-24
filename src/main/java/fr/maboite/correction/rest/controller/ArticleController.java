package fr.maboite.correction.rest.controller;

import entity.Article;
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
	public String getArticles() {
		System.out.println("getArticles called");
		return("Articles");
	}
	
	@GET
	//@Produces("application/json")
	@Produces("text/plain")
	@Path("/{id}/{description}/{brand}/{price}")
	public String getById(
			@PathParam("id") Integer id,
			@PathParam("description") String description,
			@PathParam("brand") String brand,
			@PathParam("price") float price) {
		System.out.println("getById called with Id : "+id);
		Article article = new Article();
		article.setIdArticle(id);
		article.setDescription(description);
		article.setBrand(brand);
		article.setPrice(price);
		return article.toString();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Article save(Article article) {
		if(article.getIdArticle()!=null) {
			System.out.println("The article "+article.getIdArticle()+" passed by POST");
		}else {article.setIdArticle();}
		
		return article;
	}

	@DELETE
	@Path("/{id}")
	public String delete(@PathParam("id") Integer id) {
		System.out.println("delete called with Id : "+id);
		return "Articles";
	}
}
