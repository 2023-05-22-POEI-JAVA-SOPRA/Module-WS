package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class ArticleDao {

	/**
	 * Sauvegarde (insère ou met à jour) article.
	 * 
	 * @param article
	 * @return
	 */
	public Article save(Article article) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Article savedArticle = entityManager.merge(article);
		tx.commit();
		return savedArticle;
	}

	/**
	 * Renvoie le Article ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Article get(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(Article.class, id);
	}

	/**
	 * Supprime l'user avec l'id id
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		if (id == null) {
			return;
		}
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Query query = entityManager.createQuery(
				"delete Article article where article.idArticle = :id ");
		query.setParameter("idArticle", id);
		query.executeUpdate();
		tx.commit();

	}

	/**
	 * Renvoie tous les articles en base de données. Ne devrait pas être codé en
	 * production : il faut toujours paginer ou filtrer les données.
	 * 
	 * @return
	 */
	public List<Article> findAll() {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.createQuery("select article from Article article ", Article.class).getResultList();
	}
	
}
