package fr.maboite.correction.rest.controller;

import entity.Article;
import entity.ArticlePojo;
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
import jakarta.ws.rs.core.Response.ResponseBuilder;


@Path("/articles")
@Produces(MediaType.APPLICATION_JSON)
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
	
//	@GET
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{idArticle}")
//	public ArticlePojo getArticlePojo(@PathParam("idArticle") Integer idArticle){
//		ArticlePojo monPojo=new ArticlePojo();
//		monPojo.setId(idArticle);
//		monPojo.setName("maBelPojo309");
//		System.out.println("Test methode getArticlePojo - objet ArticlePojo : "+monPojo);
//		return monPojo;
//	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idArticle}")
	public Response getArticlePojo(@PathParam("idArticle") Integer idArticle){
		if(idArticle<0) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		ArticlePojo monPojo=new ArticlePojo();
		monPojo.setId(idArticle);
		monPojo.setName("maBelPojo309");
		System.out.println("Test methode getArticlePojo - objet ArticlePojo : "+monPojo);
		return Response.ok(monPojo).build();
	}
	
	@GET
	@Produces("text/plain")
	@Path("/blablabla")
	public String getArticlePojoPlainText(){
		ArticlePojo monPojo=new ArticlePojo(12,"maBelPojo309","MaPojo@peugeot.fr");
		System.out.println("PLAIN TEXT getArticlePojoPlainText - objet ArticlePojo : "+monPojo);
		System.out.println(monPojo);
		return monPojo.toString();
	}
	
	
	@DELETE
	@Path("/{babibu}")
	public int methodeDelete(@PathParam("babibu") int babibu){
		System.out.println("Test methode methodeDelete - id : "+babibu);
		return babibu;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public ArticlePojo maMethodePost(@Valid ArticlePojo a) {
		System.out.println(a);
		System.out.println("L'article "+a.getId()+" est passe par POST");
		
		System.out.println("\n\n ArticlePojo MODIFIE : ");
		a.setEmail("BABIBU");
		a.setId(-1);
		a.setId(a.getId()+12);
		System.out.println(a);
		return a;
	}
	
}
