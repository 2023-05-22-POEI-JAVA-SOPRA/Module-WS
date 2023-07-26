package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.CommandDao;
import fr.maboite.correction.jpa.entity.Command;

public class CommandService {
	
	private CommandDao commandDao = new CommandDao();
	
	public Command save (Command command) {
		return this.commandDao.save(command);
	}
	
	public Command get (Integer id) {
		return this.commandDao.get(id);
	}
	
	public void delete (Integer id) {
		this.commandDao.delete(id);
	}
	
	public List<Command> findAll(){
		return this.commandDao.findAll();
	}
	
	public List<Command> findAllByUserId(Integer id){
		return this.commandDao.findAllByUserId(id);
	}

}
