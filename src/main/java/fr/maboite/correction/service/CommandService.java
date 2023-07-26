package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.CommandDao;
import fr.maboite.correction.jpa.entity.Command;

public class CommandService {
	
	private CommandDao commandDao = new CommandDao();
		
	public Command getById(Integer id) {
		return commandDao.getById(id);
	}
	
	public List<Command> getAll() {
		return commandDao.getAll();
	}
	
	public boolean create(Command command) {
		return commandDao.create(command);
	}
	
	public boolean update(Command command, Integer id) {
		return commandDao.update(command, id);
	}
	
	public boolean delete(Integer id) {
		return commandDao.delete(id);
	}
	
}
