package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.ArticlePojo;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/articles")
//@Produces("application/json")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleController {
	@GET
	public String articleMethod1() {
		System.out.println("méthode 1 fonctionne ?");
		return "youhou je suis là";
	}
	
//	@GET
//	@Path("/{id}")
//	public int articleById(@PathParam("id") Integer id) {
//		System.out.println(id + " trop fort");
//		return id;
//	 }
	
	
//	@GET
//	@Path("/{id}")
//	public ArticlePojo getArticles1(@PathParam("id") Integer id) {
//		System.out.println(id + " trop fort");
//		return new ArticlePojo();
//	 }
	
	@GET
	@Path("/{id}")
	public ArticlePojo getArticles(@PathParam("id") Integer id) {
		System.out.println(id + " trop fort");
		ArticlePojo articlePojo = new ArticlePojo();
		articlePojo.setId(id);
		articlePojo.setCategory("Category avec l'id: " + id);
		return articlePojo;
	}
	
	@DELETE
	@Path("/{id}")
	public int deleteArticleById(@PathParam("id") Integer id) {
		System.out.println(id + " aurevoir");
		return id;
	 }
}
