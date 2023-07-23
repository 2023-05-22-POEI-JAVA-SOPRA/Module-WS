package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.pojo.ArticlePojo;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/articles")
@Produces("application/json")
public class ArticleController {

	@GET
	public String getArticles() {
		System.out.println("Get Method");
		return "Liste d'articles";
	}

	@GET
	@Path("/{id}")
	public ArticlePojo getMethod(@PathParam("id") Integer id ) {
		System.out.println(" Article id :" + id );
		ArticlePojo articlePojo = new ArticlePojo();
		articlePojo.setId(id);
		articlePojo.setName("Article avec l'id : " + id);
		return articlePojo;

	}

	@DELETE
	@Path("/{id}")
	public String deleteMethod(@PathParam("id") Integer id) {
		System.out.println("Delete article : " + id) ;
		return "Delete article whith id: " + id ;
	}

}
