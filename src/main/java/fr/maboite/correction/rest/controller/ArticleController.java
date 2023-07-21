package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/articles")
public class ArticleController {
	
	@GET
	public String mesArticles() { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
		System.out.println("Affichage des articles");
		return "Bienvenue sur la page article";
	}

}
