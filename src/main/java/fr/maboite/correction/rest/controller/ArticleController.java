package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/articles")
public class ArticleController {
	@GET
	public String articleMethod1() {
		System.out.println("méthode 1 fonctionne ?");
		return "youhou je suis là";
	}
}
