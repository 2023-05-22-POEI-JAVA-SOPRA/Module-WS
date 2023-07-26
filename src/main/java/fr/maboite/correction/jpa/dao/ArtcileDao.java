package fr.maboite.correction.jpa.dao;

import java.util.List;



import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ArtcileDao {
	


	/**
	 * DAO (Data Access Object) pour les entités Article
	 */

		/**
		 * Sauvegarde (insère ou met à jour) Article.
		 * 
		 * @param Article
		 * @return
		 */
		public Article save(Article article) {
			EntityManager entityManager =null;
			try {
				entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
				EntityTransaction trans = entityManager.getTransaction();
				trans.begin();
				entityManager.persist(article);
				trans.commit();
				return article;

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return null;
			} finally {
				if (entityManager != null)
					entityManager.close();
			}
			
			
		}

		/**
		 * Renvoie l' Article ayant id, peut renvoyer null.
		 * 
		 * @param id
		 * @return
		 */
		public Article get(Integer id) {
			EntityManager entityManager = null;
			try {
				 entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
				 return entityManager.find(Article.class, id);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return null;
			} finally {
				if (entityManager != null)
					entityManager.close();

			}
		}

		/**
		 * Supprime l'user avec l'id id
		 * 
		 * @param id
		 */
		public boolean delete(Integer id) {
			
			
			EntityManager entityManager = null;
			if (id == null) {
				return false;
			}
			System.out.println(" ID "+ id);
	
				try {
					entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
					EntityTransaction trans = entityManager.getTransaction();
					Article article = entityManager.find(Article.class, id);
					trans.begin();
					entityManager.remove(article);
					trans.commit();
					return true;

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					return false;
				} finally {
					if (entityManager != null)
						entityManager.close();
//					if (em != null)
//						em.close();
				}

			
			
		}

		/**
		 * Renvoie tous les articles en base de données. Ne devrait pas être codé en
		 * production : il faut toujours paginer ou filtrer les données.
		 * 
		 * @return
		 */
		public List<Article> findAll() {
			
			EntityManager entityManager = null;
			try {
				 entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
				return entityManager.createQuery("select a from Article a Order by id", Article.class).getResultList();
				 
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return null;
			} finally {
				if (entityManager != null)
					entityManager.close();

			}
			
		}

	


}
