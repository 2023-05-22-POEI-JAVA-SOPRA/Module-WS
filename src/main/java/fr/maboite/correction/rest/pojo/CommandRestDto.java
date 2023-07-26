package fr.maboite.correction.rest.pojo;

import java.sql.Date;

import fr.maboite.correction.jpa.entity.Command;
import fr.maboite.correction.jpa.entity.User;


public class CommandRestDto {
	private Integer idCommand;
	private User user;
	private Date commandDate;
	
	
	public CommandRestDto() {
		super();
	}


	public CommandRestDto(User user, Date commandDate) {
		super();
		this.user = user;
		this.commandDate = commandDate;
	}
	
	public CommandRestDto(Command command) {
		user = command.getUser();
		commandDate = command.getCommandDate();
	}

	public Command convertToCommand() {
		return new Command(user, commandDate);
	}
	

	public Integer getIdCommand() {
		return idCommand;
	}


	public User getUser() {
		return user;
	}


	public Date getCommandDate() {
		return commandDate;
	}


	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setCommandDate(Date commandDate) {
		this.commandDate = commandDate;
	}
	
	
	
	
}
