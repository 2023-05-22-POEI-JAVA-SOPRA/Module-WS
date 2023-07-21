package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.ArticlePojo;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/articles")
@Produces("application/json") //par defaut
public class ArticleController {
	
	@GET
	@Produces("text/plain")
	public String bonjour() {
		System.out.println("methode OK");
		return "bonjour";
	}
	
	@GET
	@Path("/{paramRest}")
	public ArticlePojo methodeTest(@PathParam("paramRest") Integer id) {
		System.out.println("id: " + id);
		ArticlePojo ap =  new ArticlePojo();
		ap.setId(id);
		ap.setNom("nom");
		ap.setManufacturer("microsoft");
		ap.setPrice(999.9f);
		return ap;
	}
	
	@DELETE
	@Path("/{paramRest}")
	public int delete(@PathParam("paramRest") Integer id) {
		System.out.println("id:" + id);
		return id;
	}
}
