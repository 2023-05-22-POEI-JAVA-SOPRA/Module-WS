package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.CommandeLineDAO;
import fr.maboite.correction.jpa.entity.CommandeLine;

public class CommandeLineService {
	
CommandeLineDAO commandeLineDAO = new CommandeLineDAO();
	
	public CommandeLine get(Integer id) {
		
		return commandeLineDAO.get(id);
	}
	
	public List<CommandeLine> get() {
		
		return commandeLineDAO.findAll();
	}
	
	
	public CommandeLine save(CommandeLine commandeLine) {
		
		return commandeLineDAO.save(commandeLine);
	}
	
}
