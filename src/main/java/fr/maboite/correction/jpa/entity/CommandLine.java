package fr.maboite.correction.jpa.entity;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "commandline")
public class CommandLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	
	private int idCommandLine;
	
	@ManyToOne @JoinColumn(name = "idArticle")
	private Article article;
	
	@ManyToOne @JoinColumn(name = "idCommand")
	private Command command;
	
	//private int idCommand;
	//private int idArticle;
	private int quantity;
	
	
	public int getIdCommandLine() {
		return idCommandLine;
	}
	public void setIdCommandLine(int idCommandLine) {
		this.idCommandLine = idCommandLine;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public CommandLine(Article article, Command command, int quantity) {
		super();
		this.article = article;
		this.command = command;
		this.quantity = quantity;
	}
	public CommandLine() {
		super();
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	@Override
	public String toString() {
		return "CommandLine [idCommandLine=" + idCommandLine + ", article=" + article + ", command=" + command
				+ ", quantity=" + quantity + "]";
	}
	public CommandLine(int idCommandLine, Article article, Command command, int quantity) {
		super();
		this.idCommandLine = idCommandLine;
		this.article = article;
		this.command = command;
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(article, command, idCommandLine, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandLine other = (CommandLine) obj;
		return Objects.equals(article, other.article) && Objects.equals(command, other.command)
				&& idCommandLine == other.idCommandLine && quantity == other.quantity;
	}
	
	
	
}
