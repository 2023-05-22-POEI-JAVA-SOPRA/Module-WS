package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.ArticleDao;
import fr.maboite.correction.jpa.entity.Article;

public class ArticleService {

	private ArticleDao articleDao = new ArticleDao();

	/**
	 * Sauvegarde (insère ou met à jour) user.
	 * 
	 * @param user
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

	public Article get(Integer idArticle) {
		return this.articleDao.get(idArticle);
	}

	/**
	 * Supprime l'Article avec l'id 
	 * 
	 * @param id
	 */

	public void delete(Integer idArticle) {
		this.articleDao.delete(idArticle);
	}

	/**
	 * Renvoie tous les Articles en base de données.
	 * 
	 * @return
	 */
	public List<Article> findAll() {
		return this.articleDao.findAll();
	}

}
