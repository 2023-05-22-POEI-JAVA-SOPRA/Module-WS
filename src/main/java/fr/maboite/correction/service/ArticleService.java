package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.ArticleDao;
import fr.maboite.correction.jpa.entity.Article;
import fr.maboite.correction.rest.pojo.ArticleRestDto;

public class ArticleService {

	private ArticleDao articleDao = new ArticleDao();

	/**
	 * Sauvegarde (insère ou met à jour) article.
	 * 
	 * @param article
	 * @return
	 */
	public Article save(Article article) {
		return this.articleDao.save(article);
	}

	/**
	 * Renvoie le Article ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Article get(Integer id) {
		return this.articleDao.get(id);
	}

	/**
	 * Supprime l'article avec l'id id
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		this.articleDao.delete(id);
	}

	/**
	 * Renvoie tous les Users en base de données.
	 * 
	 * @return
	 */
	public List<Article> findAll() {
		return this.articleDao.findAll();
	}
	
	public boolean checkPrice(ArticleRestDto articleRestDto) {
		String brand = articleRestDto.getBrand();
		double unitaryPrice = articleRestDto.getUnitaryPrice();
		if(unitaryPrice>500) {
			if (!(brand.equals("Rolex") || brand.equals("Ferrari")) || brand.equals("Marque repère")) {
				return false;
			}
		}
		return true;
	}
	
}
