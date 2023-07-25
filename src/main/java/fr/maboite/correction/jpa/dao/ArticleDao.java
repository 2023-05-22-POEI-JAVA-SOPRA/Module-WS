package fr.maboite.correction.jpa.dao;

import java.util.List;


import fr.maboite.correction.jpa.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class ArticleDao {

	
	public Article save(Article article) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Article savedArticle = entityManager.merge(article);
		tx.commit();
		return savedArticle;
	}

	
	public Article get(Integer idArticle) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(Article.class, idArticle);
	}

	/**
	 * Supprime l'Article avec l'id id
	 * 
	 * @param id
	 */
	public void delete(Integer idArticle) {
		if (idArticle == null) {
			return;
		}
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Query query = entityManager.createQuery(
				"delete Article a where a.id = :id ");
		query.setParameter("id", idArticle);
		query.executeUpdate();
		tx.commit();

	}

	/**
	 * Renvoie tous les users en base de données. Ne devrait pas être codé en
	 * production : il faut toujours paginer ou filtrer les données.
	 * 
	 * @return
	 */
	public List<Article> findAll() {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.createQuery("select a from Article a ", Article.class).getResultList();
	}
	
}
