package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.CommandeDAO;
import fr.maboite.correction.jpa.entity.Commande;

public class CommandeService {
	
	CommandeDAO commandeDAO = new CommandeDAO();
	
	public Commande get(Integer id) {
		
		return commandeDAO.get(id);
	}
	
	public List<Commande> get() {
		
		return commandeDAO.findAll();
	}
	
	
	public Commande save(Commande commande) {
		
		return commandeDAO.save(commande);
	}
	
}
