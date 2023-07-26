package fr.maboite.correction.rest.pojo;

public class CommandLinePojo {
	
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
	@Override
	public String toString() {
		return "CommandLinePojo [idCommandLine=" + idCommandLine + ", idCommand=" + idCommand + ", idArticle="
				+ idArticle + ", quantity=" + quantity + "]";
	}
	public CommandLinePojo() {
		super();
	}
	
	

}
