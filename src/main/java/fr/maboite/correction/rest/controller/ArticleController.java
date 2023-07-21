package fr.maboite.correction.rest.controller;

import fr.rest.pojo.ArticlePojo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/articles")
@Produces("application/json")
public class ArticleController {
	
	@GET
	public String getarticles() { 
		System.out.println("ma Methode est appelée ");
		return "voilà article";
	}
	
		@GET
		@Path("/{id}") //jax pour différencier avec l'id
		public ArticlePojo getarticles(@PathParam("id")Integer id) { // URL que traite cette méthode : 
			System.out.println("getarticles est : "+id);
			ArticlePojo articlePojo = new ArticlePojo();
			articlePojo.setId(id);
			articlePojo.setNom("article"+id);
			return articlePojo;
		}

}
