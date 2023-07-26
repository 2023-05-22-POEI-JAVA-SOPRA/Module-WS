package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.EntityManagerFactorySingleton;
import fr.maboite.correction.jpa.entity.Commande;
import fr.maboite.correction.jpa.entity.CommandeLine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.validation.Valid;

public class CommandeLineDAO {
	
	/**
	 * Renvoie tous les users en base de données. Ne devrait pas être codé en
	 * production : il faut toujours paginer ou filtrer les données.
	 * 
	 * @return
	 */
	public List<CommandeLine> findAll() {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.createQuery("select cl from CommandeLine cl ", CommandeLine.class).getResultList();
	}
	
	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public CommandeLine get(Integer id) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		return entityManager.find(CommandeLine.class, id);
	}
	
	public CommandeLine save(@Valid CommandeLine commandeLine) {
		EntityManager entityManager = EntityManagerFactorySingleton.INSTANCE.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(commandeLine);
		tx.commit();
		
		//Commande savedUser = this.get(commande.getLogin());
		//TODO: CREER METHODE POUR RECUP A PARTIR DE IDUSER ET DATECOMMAND -> Sûre, car peux pas créer 2 commandes en même temps. => Passer en DateTime.
		
		return commandeLine;
	}
	
}
