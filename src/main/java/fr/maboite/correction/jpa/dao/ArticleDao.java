package fr.maboite.correction.jpa.dao;


import fr.maboite.correction.jpa.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ArticleDao {
	
	String configName = "persistenceUnit";
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public Article getById(Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			return em.find(Article.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (emf != null)
				emf.close();
			if (em != null)
				em.close();
		}
	}

	/*
	 * public List<Article> getAll() { try { emf =
	 * Persistence.createEntityManagerFactory(configName); em =
	 * emf.createEntityManager(); return
	 * em.createQuery("From Article").getResultList(); } catch (Exception e) {
	 * e.printStackTrace(); return null; } finally { if (emf != null) emf.close();
	 * if (em != null) em.close(); } }
	 */

	public boolean update(Article article, Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			Article a = em.find(Article.class, id);
			a.setDescription(article.getDescription());
			a.setBrand(article.getBrand());
			a.setUnitaryPrice(article.getUnitaryPrice());
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (emf != null)
				emf.close();
			if (em != null)
				em.close();
		}
	}

	public boolean create(Article article) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			em.persist(article);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (emf != null)
				emf.close();
			if (em != null)
				em.close();
		}
	}

	public boolean delete(Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			em.remove(em.find(Article.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (emf != null)
				emf.close();
			if (em != null)
				em.close();
		}
	}
	
	
	

	
}




	/*
	 * public Article save(Article article) { EntityManager entityManager =
	 * EntityManagerFactorySingleton.INSTANCE.getEntityManager(); EntityTransaction
	 * tx = entityManager.getTransaction(); tx.begin(); Article savedArticle =
	 * entityManager.merge(article); tx.commit(); return savedArticle; }
	 * 
	 * 
	 * public Article get(Integer idArticle) { EntityManager entityManager =
	 * EntityManagerFactorySingleton.INSTANCE.getEntityManager(); return
	 * entityManager.find(Article.class, idArticle); }
	 * 
	 *//**
		 * Supprime l'Article avec l'id id
		 * 
		 * @param id
		 */
	/*
	 * public void delete(Integer idArticle) { if (idArticle == null) { return; }
	 * EntityManager entityManager =
	 * EntityManagerFactorySingleton.INSTANCE.getEntityManager(); EntityTransaction
	 * tx = entityManager.getTransaction(); tx.begin(); Query query =
	 * entityManager.createQuery( "delete Article a where a.id = :id ");
	 * query.setParameter("id", idArticle); query.executeUpdate(); tx.commit();
	 * 
	 * }
	 * 
	 *//**
		 * Renvoie tous les articles en base de données. Ne devrait pas être codé en
		 * production : il faut toujours paginer ou filtrer les données.
		 * 
		 * @return
		 *//*
			 * public List<Article> findAll() { EntityManager entityManager =
			 * EntityManagerFactorySingleton.INSTANCE.getEntityManager(); return
			 * entityManager.createQuery("select a from Article a ",
			 * Article.class).getResultList(); }
			 */


