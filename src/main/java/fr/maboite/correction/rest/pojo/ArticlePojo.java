package fr.maboite.correction.rest.pojo;

/** 
 *Un Plain Old Java Object.
 *A chaque attribut correspond un getter et un setter
 *(public)
 * Un constructeur public sans argument (constructeur par défaut) Il est présent d'office dans la classe sauf 
 * si on ajoute un constructeur dans ce cas il faut qu'on ajoute le constructeur sans arguments
 * Il n'est pas final et aucune de ses champs ne l'est
 * 
 * NB : si une classe est mise en "final" on ne peut plus hériter de cette classe
 */


public class ArticlePojo {
	
	private int id;
	
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArticlePojo(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}

	public ArticlePojo() {
		super();
	}
	
	
}
