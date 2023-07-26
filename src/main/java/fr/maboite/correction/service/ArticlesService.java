package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.ArticleDAO;
import fr.maboite.correction.jpa.entity.Article;

public class ArticlesService {
	
	ArticleDAO articleDao = new ArticleDAO();
	
	public List<Article> findAll(){
		
		return articleDao.findAll();
		
	}
	
	public Article getById(Integer id){
		
		return articleDao.get(id);
		
	}
	
	public Article save(Article article){

		return articleDao.save(article);
	}
	
	
}
