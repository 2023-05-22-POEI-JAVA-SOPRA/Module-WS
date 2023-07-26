package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.entity.Command;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CommandDao {
	String configName = "persistenceUnit";
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public Command getById(Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			return em.find(Command.class, id);
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

	public List<Command> getAll() {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			return em.createQuery("From Command").getResultList();
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

	public boolean update(Command command, Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			Command c = em.find(Command.class, id);
			c.setCommandDate(command.getCommandDate());
			c.setUser(command.getUser());
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

	public boolean create(Command command) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			em.persist(command);
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
			em.remove(em.find(Command.class, id));
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
