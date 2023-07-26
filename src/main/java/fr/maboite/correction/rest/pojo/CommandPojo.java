package fr.maboite.correction.rest.pojo;


import java.time.LocalDateTime;

public class CommandPojo {
	
	private Integer idCommand;
	
	private UserRestDto user;
	
	private LocalDateTime commandDate;
	

	public Integer getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}

	public UserRestDto getUser() {
		return user;
	}

	public void setUser(UserRestDto user) {
		this.user = user;
	}

	public LocalDateTime getCommandDate() {
		return commandDate;
	}

	public void setCommandDate(LocalDateTime commandDate) {
		this.commandDate = commandDate;
	}
	
	
	
	

}
