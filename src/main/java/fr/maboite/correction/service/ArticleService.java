package fr.maboite.correction.service;

import fr.maboite.correction.jpa.dao.ArticleDao;
import fr.maboite.correction.jpa.entity.Article;

public class ArticleService {

	private ArticleDao articleDao = new ArticleDao();

	public Article getById(Integer id) {
		return articleDao.getById(id);
	}

	/*
	 * public List<Article> getAll() { return articleDao.getAll(); }
	 */

	public boolean create(Article article) {
		return articleDao.create(article);
	}

	public boolean update(Article article, Integer id) {
		return articleDao.update(article, id);
	}

	public boolean delete(Integer id) {
		return articleDao.delete(id);
	}

}
