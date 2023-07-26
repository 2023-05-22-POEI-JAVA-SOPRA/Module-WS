package fr.maboite.correction.jpa.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "t_commands")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcommand")
	private Integer idCommand;
	
	@Column(name = "iduser")
	private Integer idUser;
	
	@Column(name = "commanddate")
	private Date commandDate;
	
	public Commande() {	}
	
	/**
	 * @param idCommand
	 * @param idUser
	 * @param commandDate
	 */
	public Commande(Integer idUser, Date commandDate) {
		this.idUser = idUser;
		this.commandDate = commandDate;
	}
	public Integer getIdCommand() {
		return idCommand;
	}
	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Date getCommandDate() {
		return commandDate;
	}
	public void setCommandDate(Date commandDate) {
		this.commandDate = commandDate;
	}
	
}
