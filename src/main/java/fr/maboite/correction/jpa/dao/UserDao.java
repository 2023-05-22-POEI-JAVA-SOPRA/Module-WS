package fr.maboite.correction.jpa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import fr.maboite.correction.jpa.entity.User;

public class UserDao {
	String configName = "persistenceUnit";
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public User getById(Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			return em.find(User.class, id);
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
	
	public List<User> getAll() {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			return em.createQuery("From User").getResultList();
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
	
	public boolean update(User user, Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			User u = em.find(User.class, id);
			u.setLogin(user.getLogin());
			u.setPassword(user.getPassword());
			u.setConnectionNumber(user.getConnectionNumber());
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
	
	public boolean create(User user) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			em.persist(user);
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
			em.remove(em.find(User.class, id));
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
