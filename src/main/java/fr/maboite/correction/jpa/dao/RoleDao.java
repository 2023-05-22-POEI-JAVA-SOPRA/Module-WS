package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Role;
import fr.maboite.correction.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * DAO (Data Access Object) pour les entités Role
 */
public class RoleDao {

	/**
	 * Sauvegarde (insère ou met à jour) role.
	 * 
	 * @param role
	 * @return
	 */
	public Role save(Role role) {
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin();
			entityManager.persist(role);
			trans.commit();
			return role;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}

		}
	}

	/**
	 * Renvoie le Role ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Role get(Integer id) {
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
//			 System.out.println("===============================================");
//			 System.out.println("===============================================");
//			 System.out.println("===============================================");
//			 System.out.println("====================dfs===========================");
//			 User user = entityManager.find( User.class, 1 );            
//		        System.out.println( "Rôles associés à Anderson" );
//		        for( Role associatedRole : user.getRoles() ) {
//		            System.out.println( associatedRole );
//		        }
//
//		        Role role = entityManager.find( Role.class, 1 );            
//		        System.out.println( "Utilisateurs possédant le rôle client" );
//		        for( User associatedUser : role.getUsers() ) {
//		            System.out.println( associatedUser );
//		        }
			return entityManager.find(Role.class, id);
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
	 * Supprime le role avec l'id id
	 * 
	 * @param id
	 */
	public boolean delete(Integer id) {

		EntityManager entityManager = null;
		if (id == null) {
			return false;
		}
		System.out.println(" ID " + id);

		// try catch -- error 404

		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
			EntityTransaction trans = entityManager.getTransaction();
			Role role = entityManager.find(Role.class, id);
			trans.begin();
			entityManager.remove(role);
			trans.commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		} finally {
			if (entityManager != null)
				entityManager.close();
//				if (em != null)
//					em.close();
		}

	}

	/**
	 * Renvoie tous les roles en base de données. Ne devrait pas être codé en
	 * production : il faut toujours paginer ou filtrer les données.
	 * 
	 * @return
	 */
	public List<Role> findAll() {

		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
			return entityManager.createQuery("select r from Role r Order by id", Role.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		} finally {
			if (entityManager != null)
				entityManager.close();

		}

	}

}
