package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Commande;
import fr.maboite.correction.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.validation.Valid;

public class CommandeDAO {
	
	/**
	 * Renvoie tous les users en base de données. Ne devrait pas être codé en
	 * production : il faut toujours paginer ou filtrer les données.
	 * 
	 * @return
	 */
	public List<Commande> findAll() {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.createQuery("select c from Commande c ", Commande.class).getResultList();
	}
	
	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Commande get(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(Commande.class, id);
	}
	
	public Commande save(@Valid Commande commande) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(commande);
		tx.commit();
		
		//Commande savedUser = this.get(commande.getLogin());
		//TODO: CREER METHODE POUR RECUP A PARTIR DE IDUSER ET DATECOMMAND -> Sûre, car peux pas créer 2 commandes en même temps. => Passer en DateTime.
		
		return commande;
	}
	
	//Get by IdUser et Date pour après insert
}
