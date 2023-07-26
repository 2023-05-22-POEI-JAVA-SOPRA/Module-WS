package fr.maboite.correction.service;

import fr.maboite.correction.jpa.dao.CommandLineDao;
import fr.maboite.correction.jpa.entity.CommandLine;

public class CommandLineService {
	
	private CommandLineDao commandLineDao = new CommandLineDao();

	public CommandLine getById(Integer id) {
		return commandLineDao.getById(id);
	}

	

	public boolean create(CommandLine commandLine) {
		return commandLineDao.create(commandLine);
	}

	public boolean update(CommandLine commandLine, Integer id) {
		return commandLineDao.update(commandLine, id);
	}

	public boolean delete(Integer id) {
		return commandLineDao.delete(id);
	}
    public static void main(String[] args) {
    	 CommandLineService commandLineService = new CommandLineService();
    	 System.out.println(commandLineService.getById(1));
	}
}
