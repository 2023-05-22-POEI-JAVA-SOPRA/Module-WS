package fr.maboite.controller;
import fr.maboite.pojo.ArticlePojo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/articles")
@Produces("application/json")
@Consumes("application/json")
public class ArticleController {
	
	@GET //http://localhost:8080/poe-java-ws/rest/v1/articles/id
	@Path("/{id}")
	public ArticlePojo get_by_id(@PathParam("id") Integer id) { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
		System.out.println("Article numéro "+id+" récupéré");
		ArticlePojo article = new ArticlePojo();
		article.setId(id);
		article.setNom("Article numéro "+id);
		return article;
	}
	
	@DELETE
	@Path("/{id}")
	public String del_by_id(@PathParam("id") Integer id) { // URL que traite cette méthode : 
		// URL application + URL de la classe + URL de la méthode
		System.out.println("Article numéro "+id+" supprimé");
		return "Suppression Article numéro "+id;
	}
}
