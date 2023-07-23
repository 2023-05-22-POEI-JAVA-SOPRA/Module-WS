package fr.maboite.correction.jpa.dao;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class UserDao {

	public User save(User user) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		User savedUser = entityManager.merge(user);
		tx.commit();
		return savedUser;
	}

	public User get(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(User.class, id);
	}

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

}
