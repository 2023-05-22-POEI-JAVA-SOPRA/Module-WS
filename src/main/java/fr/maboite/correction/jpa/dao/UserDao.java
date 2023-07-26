package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * DAO (Data Access Object) pour les entités User
 */
public class UserDao {

	/**
	 * Sauvegarde (insère ou met à jour) user.
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user) {
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin();
			entityManager.persist(user);
			trans.commit();
			return user;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			if (entityManager != null)
				entityManager.close();
		}

	}

	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public User get(Integer id) {
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
			return entityManager.find(User.class, id);
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

		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
			EntityTransaction trans = entityManager.getTransaction();
			User user = entityManager.find(User.class, id);
			trans.begin();
			entityManager.remove(user);
			trans.commit();
			
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			if (entityManager != null)
				entityManager.close();
		}

	}

	/**
	 * Renvoie tous les users en base de données. Ne devrait pas être codé en
	 * production : il faut toujours paginer ou filtrer les données.
	 * 
	 * @return
	 */
	public List<User> findAll() {

		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
			List<User> result=  entityManager.createQuery("select u from User u Order by id ", User.class).getResultList();
			if(result.size() > 0)
			{
				return result;
			}
			 return null;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public boolean deleteAll() {

		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin();
			entityManager.createQuery("Delete from User").executeUpdate();
			trans.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			if (entityManager != null)
				entityManager.close();

		}

	}

}
