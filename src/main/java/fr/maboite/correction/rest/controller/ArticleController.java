package fr.maboite.correction.rest.controller;

import entity.Article;
import entity.ArticlePojo;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;


@Path("/articles")
public class ArticleController {

	public ArticleController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GET
	public String afficherArticle() {
		Article a=new Article("Tres bel article jaune et bleu","Lidl",12.5F);
		System.out.println("Appel methode afficherArticle");
	return a.toString();
	}
	
	
//	@GET
//	@Path("/{idArticle}")
//	public Integer getArticleById(@PathParam("idArticle") Integer idArticle){
//		System.out.println("Test methode getArticleById - id : "+idArticle);
//		return idArticle;
//	}
	
	@GET
	@Produces("application/json")
	@Path("/{idArticle}")
	public ArticlePojo getArticlePojo(@PathParam("idArticle") Integer idArticle){
		ArticlePojo monPojo=new ArticlePojo();
		monPojo.setId(idArticle);
		monPojo.setName("maBelPojo309");
		System.out.println("Test methode getArticlePojo - objet ArticlePojo : "+monPojo);
		return monPojo;
	}
	
	
	@DELETE
	@Path("/{babibu}")
	public int methodeDelete(@PathParam("babibu") int babibu){
		System.out.println("Test methode methodeDelete - id : "+babibu);
		return babibu;
	}
}
