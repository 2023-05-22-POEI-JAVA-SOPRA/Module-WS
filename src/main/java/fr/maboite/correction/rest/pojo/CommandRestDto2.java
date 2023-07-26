package fr.maboite.correction.rest.pojo;

import java.time.LocalDateTime;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.User;
import fr.maboite.correction.service.UserService;

public class CommandRestDto2 {

	private Integer idCommand;

	private Integer idUser;

	private LocalDateTime commandDate;

	public CommandRestDto2() {
		
	}

	public CommandRestDto2(Command command) {
		
		this.idCommand = command.getIdCommand();
		this.idUser = command.getUser().getIdUser();
		this.commandDate = command.getCommandDate();
	}

	public Integer getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public LocalDateTime getCommandDate() {
		return commandDate;
	}

	public void setCommandDate(LocalDateTime commandDate) {
		this.commandDate = commandDate;
	}

	public Command toCommand() {

		Command command = new Command();
		UserService userService = new UserService();
		User user = userService.get(idUser);
		
		command.setCommandDate(this.commandDate);
		command.setIdCommand(this.idCommand);
		command.setUser(user);

		return command;
	}

}
