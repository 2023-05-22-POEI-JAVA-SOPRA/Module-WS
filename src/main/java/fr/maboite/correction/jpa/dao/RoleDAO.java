package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Roles;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;

public class RoleDAO {
	
	public List<Roles> getAll() {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.createQuery("Select r From Roles r", Roles.class).getResultList();
	}
	
	public Roles getById(Integer id) {
		
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(Roles.class, id);
		
	}
	
	public Roles getByLibelle(String libelle) {
		
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return (Roles)entityManager.createQuery("Select r From Roles r Where roleName = ?1")
				.setParameter(1, libelle)
				.getSingleResult();
		
	}

	public Roles save(@Valid Roles role) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(role);
		entityManager.getTransaction().commit();
		
		return this.getByLibelle(role.getRoleName());
	}
}
