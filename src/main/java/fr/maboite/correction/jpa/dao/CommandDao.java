package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CommandDao {
	
	public Command save(Command command) {
		
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;
		
		
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("maConfiguration");
			entityManager = entityManagerFactory.createEntityManager();
			
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin();
			
			Command savedCommand = entityManager.merge(command);
			
			trans.commit();
			
			return savedCommand;
				
		}finally {
			if(entityManagerFactory != null) {
				entityManagerFactory.close();
			}
			if(entityManager != null) {
				entityManager.close();
			}
		}
		
	}
	
	public Command get(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(Command.class, id);
	}
	
	public void delete(Integer id) {
		if (id == null) {
			return;
		}
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Query query = entityManager.createQuery(
				"delete Command c where c.id = :id ");
		query.setParameter("id", id);
		query.executeUpdate();
		tx.commit();

	}
	
	public List<Command> findAll() {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		List<Command> commands = entityManager.createQuery("From Command").getResultList();
		return commands;
	}
	
	public List<Command> findAllByUserId(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		List<Command> commandsUser = entityManager.createQuery("select c from Command c where c.id = :id ").getResultList();
		return commandsUser;
	}

}
