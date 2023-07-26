package fr.maboite.correction.jpa.dao;

import fr.maboite.correction.jpa.entity.CommandLine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CommandLineDao {
	
	String configName = "persistenceUnit";
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public CommandLine getById(Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			return em.find(CommandLine.class, id);
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



	public boolean update(CommandLine commandLine, Integer id) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			CommandLine co = em.find(CommandLine.class, id);
			co.setIdArticle(commandLine.getIdArticle());
			co.setIdCommand(commandLine.getIdCommand());
			co.setQuantity(commandLine.getQuantity());
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

	public boolean create(CommandLine commandLine) {
		try {
			emf = Persistence.createEntityManagerFactory(configName);
			em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			em.persist(commandLine);
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
			em.remove(em.find(CommandLine.class, id));
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
