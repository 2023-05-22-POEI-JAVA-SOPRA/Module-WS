package fr.maboite.correction.jpa.entity;

import fr.maboite.correction.validator.CheckCommandeLinePrice;
import jakarta.persistence.*;

@Entity
@Table(name = "t_commandlines")
@CheckCommandeLinePrice
public class CommandeLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcommandline")
	private Integer idCommandLine;
	
	@Column(name="idcommand")
	private Integer idCommand;
	
	@Column(name="idarticle")
	private Integer idArticle;
	
	
	private Integer quantity;

	
	public CommandeLine() {}

	/**
	 * @param idCommandLine
	 * @param idCommand
	 * @param idArticle
	 * @param quantity
	 */
	public CommandeLine(Integer idCommandLine, Integer idCommand, Integer idArticle, Integer quantity) {
		this.idCommandLine = idCommandLine;
		this.idCommand = idCommand;
		this.idArticle = idArticle;
		this.quantity = quantity;
	}


	public Integer getIdCommandLine() {
		return idCommandLine;
	}


	public void setIdCommandLine(Integer idCommandLine) {
		this.idCommandLine = idCommandLine;
	}


	public Integer getIdCommand() {
		return idCommand;
	}


	public void setIdCommand(Integer idCommand) {
		this.idCommand = idCommand;
	}


	public Integer getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
