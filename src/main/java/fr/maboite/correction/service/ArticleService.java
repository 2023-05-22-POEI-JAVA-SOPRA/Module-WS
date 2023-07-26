package fr.maboite.correction.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.maboite.correction.jpa.dao.ArtcileDao;
import fr.maboite.correction.jpa.entity.Article;
import fr.maboite.correction.rest.pojo.ArticleRestDto;


public class ArticleService {
	
	private ArtcileDao artDao = new ArtcileDao();
	final private List<String> LUXE_BRAND = Arrays.asList("Rolex","Ferrari","Marque repère");
	
	public Article get(Integer id)
	{
		return this.artDao.get(id);
	}
	public List<Article> findAll() {
		return this.artDao.findAll();
	}
	
	public boolean validatePrice(ArticleRestDto articlePojo)
	{

		return articlePojo.getUnitaryPrice() >= 500 && !isLuxeBrand(articlePojo);
	}
	
	public Article save(Article art) {

		return this.artDao.save(art);
	}
	
	public boolean delete(Integer id) {
		return this.artDao.delete(id);
	}
	
	public boolean isLuxeBrand(ArticleRestDto articlePojo)
	{
		return LUXE_BRAND.contains(articlePojo.getBrand());
	}
}
