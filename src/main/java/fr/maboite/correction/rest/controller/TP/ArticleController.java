package fr.maboite.correction.rest.controller.TP;

import java.util.List;

import fr.maboite.correction.jpa.entity.Article;
import fr.maboite.correction.jpa.entity.Articles;
import fr.maboite.correction.service.ArticlesService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleController {
	
	private ArticlesService articleService = new ArticlesService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticles() {
		System.out.println("getUsers est appelée");
		List<Article> articles = this.articleService.findAll();
		
		if(articles == null || articles.stream().count() < 0)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(articles).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@PathParam("id") Integer id) {
		System.out.println("getUsers est appelée avec l'id : " + id);
		Article article = this.articleService.getById(id);
		if (article == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(article).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Article article) {
		System.out.println("save est appelée");
		Article savedArticles = this.articleService.save(article);
		
		if(savedArticles == null || savedArticles.getIdArticle() <= 0 )
		{
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return Response.ok(savedArticles).build();
	}
}