package fr.maboite.correction.rest.pojo;

import java.time.LocalDateTime;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.User;

public class CommandRestDto {

	private Integer idCommand;

	private User user;

	private LocalDateTime commandDate;
	
	

	public CommandRestDto() {
		
	}

	public CommandRestDto(Command command) {
		
		this.idCommand = command.getIdCommand();
		this.user = command.getUser();
		this.commandDate = command.getCommandDate();
	}

	public Integer getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		command.setUser(this.user);
		
		return command;
	}
	
	
	

}
