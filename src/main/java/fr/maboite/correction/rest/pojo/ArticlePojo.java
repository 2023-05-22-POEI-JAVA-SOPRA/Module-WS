package fr.maboite.correction.rest.pojo;

/**
 * Un Plain Old Java Object
 * A chaque attribut correspond un getter et un setter (public)
 * Un constructeur public sans argument (le constructeur par defaut)
 * Il n'est pas final et aucun de ses champs ne l'est
 */

public class ArticlePojo {
	private Integer id;
	private String nom;
	private String manufacturer;
	private Float price;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public Float getPrice() {
		return price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setPrice(Float price) {
		this.price = price;
	}




	public ArticlePojo() {
		super();
	}
	public ArticlePojo(Integer id, String nom, String manufacturer, Float price) {
		super();
		this.id = id;
		this.nom = nom;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	
	
}
