package fr.maboite.correction.rest.pojo;


import java.time.LocalDateTime;

public class CommandPojo {
	
	private Integer idCommand;
	
	private UserRestDto idUser;
	
	private LocalDateTime commandDate;
	

	public Integer getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}

	public UserRestDto getIdUser() {
		return idUser;
	}

	public void setIdUser(UserRestDto idUser) {
		this.idUser = idUser;
	}

	public LocalDateTime getCommandDate() {
		return commandDate;
	}

	public void setCommandDate(LocalDateTime commandDate) {
		this.commandDate = commandDate;
	}
	
	
	
	

}
