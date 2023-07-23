package fr.maboite.correction.rest.pojo;

/**
 * Un Plain Old Java Object. 
 * A chaque attribut correspond un getter et un setter
 * (public)
 * Un contructeur public sans argument (le constructeur par défaut).
 * Il n'est pas final et aucun de ses champs ne l'est
 */
public class ArticlePojo {

	private Integer id;

	private String nom;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
