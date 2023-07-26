package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.ArticleDAO;
import fr.maboite.correction.jpa.entity.Articles;
import fr.maboite.correction.validator.CheckBrandPrice;

public class ArticlesService {
	
	ArticleDAO articleDao = new ArticleDAO();
	
	public List<Articles> findAll(){
		
		return articleDao.findAll();
		
	}
	
	
	public Articles getById(Integer id){
		
		return articleDao.get(id);
		
	}
	
	public Articles save(Articles article){

		return articleDao.save(article);
	}
	
	
}
