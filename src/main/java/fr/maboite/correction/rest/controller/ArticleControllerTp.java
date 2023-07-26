package fr.maboite.correction.rest.controller;


import java.util.ArrayList;
import java.util.List;


import fr.maboite.correction.jpa.entity.Article;
import fr.maboite.correction.jpa.entity.User;
import fr.maboite.correction.rest.pojo.ArticleRestDto;
import fr.maboite.correction.service.ArticlesService;
import fr.maboite.correction.validator.RequestValidator;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleControllerTp {

	private ArticlesService articleService = new ArticlesService();
	private RequestValidator rq = new RequestValidator();

	@GET
	public Response getAllArticles() { 

		System.out.println("getAllArticles est appelée");
		List<Article> articles = this.articleService.findAll();
		System.out.println("======================================" +articles);
		List<ArticleRestDto> articlesDtos = new ArrayList<>();
		for (Article article : articles) {
			ArticleRestDto articleDto = new ArticleRestDto(article);
			articlesDtos.add(articleDto);
		}
		return Response.ok(articlesDtos).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getArticle(@PathParam("id") Integer id)
	{
		System.out.println("getArticle est appelée");
		
		
		if (!rq.validateId(id)) {
			return rq.response404();
		}
		Article art = this.articleService.getById(id);
		
		if (art == null) {
			return Response.status(Status.NOT_FOUND).entity("{'cause': 'article not found'}").build();
		}
		return Response.ok(art,MediaType.APPLICATION_JSON).build();
		
		
	}
	
	@POST
	public Response save(@Valid ArticleRestDto articlePojo)
	{
		System.out.println("POST save Article est appelée");
		
		if(articlePojo.getIdArticle() >= 0)
		{
			return Response.status(Status.BAD_REQUEST).entity("{'cause': ' article price can't be superior or equal to 500 because its brand is not luxuous'}").build();
		}
		
		Article savedArticle = this.articleService.save(articlePojo.toArticle());
				
		return Response.ok(savedArticle,MediaType.APPLICATION_JSON).build();
		
	}
	
	
	
	
}


