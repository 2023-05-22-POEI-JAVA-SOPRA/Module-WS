package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.validation.Valid;

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
	public User update(@Valid User user) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		User savedUser = entityManager.merge(user);
		tx.commit();
		return savedUser;
	}
	
	public User save(@Valid User user) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(user);
		tx.commit();
		
		User savedUser = this.get(user.getLogin());
		
		return savedUser;
	}

	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public User get(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(User.class, id);
	}
	
	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public User get(String login) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return (User)entityManager.createQuery("Select u From User u Where login = ?1").setParameter(1, login).getSingleResult();
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
				"delete User u where u.id = :id ");
		query.setParameter("id", id);
		query.executeUpdate();
		tx.commit();

	}

	/**
	 * Renvoie tous les users en base de données. Ne devrait pas être codé en
	 * production : il faut toujours paginer ou filtrer les données.
	 * 
	 * @return
	 */
	public List<User> findAll() {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.createQuery("select u from User u ", User.class).getResultList();
	}

}
