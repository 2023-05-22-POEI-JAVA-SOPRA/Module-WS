package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Articles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.validation.Valid;

public class ArticleDAO {
	
	/**
	 * Renvoie tous les users en base de données. Ne devrait pas être codé en
	 * production : il faut toujours paginer ou filtrer les données.
	 * 
	 * @return
	 */
	public List<Articles> findAll() {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.createQuery("select a from Articles a ", Articles.class).getResultList();
	}
	
	public Articles save(@Valid Articles article) {
		
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(article);
		tx.commit();
		
		Articles savedArticle = this.get(article.getDescription());
		
		return savedArticle;
		
	}

	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Articles get(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(Articles.class, id);
	}
	
	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Articles get(String description) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return (Articles)entityManager.createQuery("Select a From Articles a Where description = ?1").setParameter(1, description).getSingleResult();
	}
	
}
