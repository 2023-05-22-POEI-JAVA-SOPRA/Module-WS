package fr.maboite.correction.rest.pojo;


import fr.maboite.correction.jpa.entity.CommandLine;

public class CommandLineRestDto {
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
	public CommandLineRestDto() {
		super();
	}
	@Override
	public String toString() {
		return "CommandLineRestDto [idCommandLine=" + idCommandLine + ", idCommand=" + idCommand + ", idArticle="
				+ idArticle + ", quantity=" + quantity + "]";
	}
	public CommandLineRestDto(int idCommand, int idArticle, int quantity) {
		super();
		this.idCommand = idCommand;
		this.idArticle = idArticle;
		this.quantity = quantity;
	}

	public CommandLineRestDto(CommandLine commandLine) {
		idCommandLine = commandLine.getIdCommandLine();
		idCommand = commandLine.getIdCommand();
		idArticle = commandLine.getIdArticle();
		quantity = commandLine.getQuantity();
	}
	
	
	
	
	
	

}
