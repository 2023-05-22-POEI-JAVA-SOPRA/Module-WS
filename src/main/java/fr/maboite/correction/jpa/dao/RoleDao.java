package fr.maboite.correction.jpa.dao;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RoleDao {

	

	/**
	 * Sauvegarde (insère ou met à jour) role.
	 * 
	 * @param role
	 * @return
	 */
	public Role save(Role role) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Role savedRole = entityManager.merge(role);
		tx.commit();
		return savedRole;
	}

	/**
	 * Renvoie le role ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Role get(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(Role.class, id);
	}
	
	
	
}
