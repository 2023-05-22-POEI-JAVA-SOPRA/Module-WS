package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/articles")
public class ArticleController {
	@GET
	public String articleMethod1() {
		System.out.println("méthode 1 fonctionne ?");
		return "youhou je suis là";
	}
	
	@GET
	@Path("/{id}")
	public int articleById(@PathParam("id") int id) {
		System.out.println(id + " trop fort");
		return id;
	 }
	
	@DELETE
	@Path("/{id}")
	public int deleteArticleById(@PathParam("id") int id) {
		System.out.println(id + " aurevoir");
		return id;
	 }
}
