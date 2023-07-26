package fr.maboite.correction.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "commandline")
public class CommandLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	
	private int idCommandLine;
	private int idCommand;
	private int idArticle;
	private int quantity;
	
	
	public int getIdCommandLine() {
		return idCommandLine;
	}
	public void setIdCommandLine(int idCommandLine) {
		this.idCommandLine = idCommandLine;
	}
	public int getIdCommand() {
		return idCommand;
	}
	public void setIdCommand(int idCommand) {
		this.idCommand = idCommand;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CommandLine(int idCommand, int idArticle, int quantity) {
		super();
		this.idCommand = idCommand;
		this.idArticle = idArticle;
		this.quantity = quantity;
	}
	public CommandLine() {
		super();
	}
	
	
}
