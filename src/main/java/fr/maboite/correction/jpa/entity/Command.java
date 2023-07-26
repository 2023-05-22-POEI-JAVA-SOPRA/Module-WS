package fr.maboite.correction.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;





@Entity
@Table(name="T_Commands")
public class Command {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCommand;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User idUser;
	
	private LocalDateTime commandDate;
	
	

	public Command() {
		
	}

	public Command(Integer idCommand, User idUser, LocalDateTime commandDate) {
		this.idCommand = idCommand;
		this.idUser = idUser;
		this.commandDate = commandDate;
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
	
	

}
