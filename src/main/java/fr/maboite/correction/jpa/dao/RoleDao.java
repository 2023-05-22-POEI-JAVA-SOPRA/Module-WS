package fr.maboite.correction.jpa.dao;

import fr.maboite.correction.jpa.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


/**
 * DAO (Data Access Object) pour l'entité Role
 */
public class RoleDao {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public RoleDao() {
        emf = Persistence.createEntityManagerFactory("maConfiguration");
        em = emf.createEntityManager();
    }

    public Role get(Integer id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Role role = em.find(Role.class, id);
            tx.commit();
            return role;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public Role save(Role role) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Role savedRole = em.merge(role);
		tx.commit();
		return savedRole;
	}

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}	