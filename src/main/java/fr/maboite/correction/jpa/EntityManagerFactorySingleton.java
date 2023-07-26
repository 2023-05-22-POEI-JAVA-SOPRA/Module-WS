package fr.maboite.correction.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Singleton utile pour créer un seul EntityManagerFactory par application, et
 * créer à la demande autant d'EntityManager que nécessaire. Utile car
 * EntityManagerFactory est une classe 'lourde' qui doit être créée rarement
 * (une fois par programme). EntityManager est une classe 'légère' qui peut être
 * créée autant de fois que nécessaire. Attention, cette classe est intéressante
 * pour la formation. Vous n'aurez pas à vous en servir en entreprise : des
 * frameworks utilisant JPA à un plus haut niveau vous simplifieront cette
 * tâche.
 */
public class EntityManagerFactorySingleton {
	
	public final static EntityManagerFactorySingleton INSTANCE = new EntityManagerFactorySingleton();
	
	private static final String PERSISTENCE_UNIT_NAME = "persistenceUnit";
	private EntityManagerFactory entityManagerFactory;

	private EntityManagerFactorySingleton() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public EntityManager getEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}

}
