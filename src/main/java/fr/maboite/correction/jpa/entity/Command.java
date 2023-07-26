package fr.maboite.correction.jpa.entity;

import java.sql.Date;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity @Table(name = "command")
public class Command {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id_command")
	private Integer idCommand;
	@ManyToOne @JoinColumn(name = "id_user")
	private User user;
	@Column(name = "command_date")
	private Date commandDate;
	
	
	public Command() {
		super();
	}


	public Command(User user, Date commandDate) {
		super();
		this.user = user;
		this.commandDate = commandDate;
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


	@Override
	public String toString() {
		return "Command [idCommand=" + idCommand + ", user=" + user + ", commandDate=" + commandDate + "]";
	}
	
	
}
