package fr.maboite.correction.rest.pojo;

import java.time.LocalDateTime;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.User;

public class CommandRestDto {

	private Integer idCommand;

	private User idUser;

	private LocalDateTime commandDate;
	
	

	public CommandRestDto(Command command) {
		
		this.idCommand = command.getIdCommand();
		this.idUser = command.getIdUser();
		this.commandDate = command.getCommandDate();
	}

	public Integer getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public LocalDateTime getCommandDate() {
		return commandDate;
	}

	public void setCommandDate(LocalDateTime commandDate) {
		this.commandDate = commandDate;
	}
	
	public Command toCommand() {
		
		Command command =  new Command();
		command.setCommandDate(this.commandDate);
		command.setIdCommand(this.idCommand);
		command.setIdUser(this.idUser);
		
		return command;
	}
	
	
	

}
