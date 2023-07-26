package fr.maboite.correction.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.maboite.correction.jpa.entity.Article;
import fr.maboite.correction.rest.pojo.ArticlePojo;
import fr.maboite.correction.rest.pojo.ArticleRestDto;
import fr.maboite.correction.service.ArticleService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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
	
	private ArticleService articleService = new ArticleService();
	
	
	@GET
	public List<ArticleRestDto> getArticles() {
		System.out.println("getArticles called");
		List<Article> articles = this.articleService.findAll();
		List<ArticleRestDto> articleDtos = new ArrayList<ArticleRestDto>();
		for (Article article:articles) {
			ArticleRestDto articleDto = new ArticleRestDto(article);
			articleDtos.add(articleDto);
		}
		return articleDtos;
	}
	
	@GET
	@Path("/{idArticle}")
	public ArticleRestDto getArticles(@PathParam("idArticle") Integer id) {
		System.out.println("getById called with Id : "+id);
		Article article = this.articleService.get(id);
		if(article==null) {
			return null;
		}
		return new ArticleRestDto(article);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(@Valid ArticleRestDto articlePojo) {
		System.out.println("save is called");
		if(articleService.checkPrice(articlePojo)) {
			this.articleService.save(articlePojo.toArticle());
		}
	}

	@DELETE
	@Path("/{idArticle}")
	public void deleteArticles(@PathParam("idArticle") Integer id) {
		System.out.println("delete called with Id : "+id);
		this.articleService.delete(id);
	}

}